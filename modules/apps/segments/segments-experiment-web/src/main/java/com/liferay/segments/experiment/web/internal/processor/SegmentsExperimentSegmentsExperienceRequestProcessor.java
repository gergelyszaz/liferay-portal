/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.segments.experiment.web.internal.processor;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.segments.constants.SegmentsExperienceConstants;
import com.liferay.segments.constants.SegmentsExperimentConstants;
import com.liferay.segments.experiment.web.internal.constants.SegmentsExperimentWebKeys;
import com.liferay.segments.experiment.web.internal.util.SegmentsExperimentUtil;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.model.SegmentsExperiment;
import com.liferay.segments.model.SegmentsExperimentRel;
import com.liferay.segments.processor.SegmentsExperienceRequestProcessor;
import com.liferay.segments.service.SegmentsExperienceLocalService;
import com.liferay.segments.service.SegmentsExperimentLocalService;
import com.liferay.segments.service.SegmentsExperimentRelLocalService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = "segments.experience.request.processor.priority:Integer=50",
	service = SegmentsExperienceRequestProcessor.class
)
public class SegmentsExperimentSegmentsExperienceRequestProcessor
	implements SegmentsExperienceRequestProcessor {

	@Override
	public long[] getSegmentsExperienceIds(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, long groupId, long classNameId,
		long classPK, long[] segmentsEntryIds, long[] segmentsExperienceIds) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (!SegmentsExperimentUtil.isAnalyticsEnabled(
				themeDisplay.getCompanyId())) {

			return segmentsExperienceIds;
		}

		long segmentsExperienceId = _getSelectedSegmentsExperienceId(
			httpServletRequest, themeDisplay.isSignedIn());

		if (segmentsExperienceId != -1) {
			return new long[] {segmentsExperienceId};
		}

		segmentsExperienceId = _getCurrentSegmentsExperienceId(
			httpServletRequest, groupId);

		if (segmentsExperienceId != -1) {
			SegmentsExperiment segmentsExperiment =
				_segmentsExperimentLocalService.fetchSegmentsExperiment(
					segmentsExperienceId, classNameId, classPK,
					new int[] {SegmentsExperimentConstants.STATUS_RUNNING});

			if (segmentsExperiment != null) {
				httpServletRequest.setAttribute(
					SegmentsExperimentWebKeys.SEGMENTS_EXPERIMENT,
					segmentsExperiment);

				if (_log.isDebugEnabled()) {
					_log.debug(
						StringBundler.concat(
							"Serving previous experience ",
							segmentsExperienceId, " as its experiment ",
							segmentsExperiment.getSegmentsExperimentId(),
							" is still running"));
				}

				return new long[] {segmentsExperienceId};
			}
		}

		_unsetCookie(httpServletRequest, httpServletResponse);

		LongStream stream = Arrays.stream(segmentsExperienceIds);

		segmentsExperienceId = stream.findFirst(
		).orElse(
			SegmentsExperienceConstants.ID_DEFAULT
		);

		List<SegmentsExperiment> segmentsExperiments =
			_segmentsExperimentLocalService.
				getSegmentsExperienceSegmentsExperiments(
					new long[] {segmentsExperienceId}, classNameId, classPK,
					new int[] {SegmentsExperimentConstants.STATUS_RUNNING}, 0,
					1);

		if (segmentsExperiments.isEmpty()) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"No experiment running for the user experiences " +
						StringUtil.merge(segmentsExperienceIds));
			}

			return segmentsExperienceIds;
		}

		SegmentsExperiment segmentsExperiment = segmentsExperiments.get(0);

		List<SegmentsExperimentRel> segmentsExperimentRels =
			_segmentsExperimentRelLocalService.getSegmentsExperimentRels(
				segmentsExperiment.getSegmentsExperimentId());

		if (segmentsExperimentRels.isEmpty()) {
			return segmentsExperienceIds;
		}

		segmentsExperienceId = getSegmentsExperimentSegmentsExperienceId(
			segmentsExperiment.getSegmentsExperienceId(),
			segmentsExperimentRels);

		_setCookie(
			httpServletRequest, httpServletResponse, segmentsExperienceId);

		httpServletRequest.setAttribute(
			SegmentsExperimentWebKeys.SEGMENTS_EXPERIMENT, segmentsExperiment);

		if (_log.isDebugEnabled()) {
			_log.debug(
				StringBundler.concat(
					"Serving experience ", segmentsExperienceId,
					" for running experiment ",
					segmentsExperiment.getSegmentsExperimentId()));
		}

		return new long[] {segmentsExperienceId};
	}

	protected long getSegmentsExperimentSegmentsExperienceId(
		long controlSegmentsExperienceId,
		List<SegmentsExperimentRel> segmentsExperimentRels) {

		double random = Math.random();

		for (SegmentsExperimentRel segmentsExperimentRel :
				segmentsExperimentRels) {

			random -= segmentsExperimentRel.getSplit();

			if (random <= 0.0D) {
				return segmentsExperimentRel.getSegmentsExperienceId();
			}
		}

		return controlSegmentsExperienceId;
	}

	private long _getCurrentSegmentsExperienceId(
		HttpServletRequest httpServletRequest, long groupId) {

		Cookie[] cookies = httpServletRequest.getCookies();

		if (ArrayUtil.isEmpty(cookies)) {
			return -1;
		}

		String segmentsExperienceKey = Stream.of(
			cookies
		).filter(
			cookie -> Objects.equals(
				cookie.getName(), _AB_TEST_VARIANT_ID_COOKIE_NAME)
		).map(
			Cookie::getValue
		).findFirst(
		).orElse(
			StringPool.BLANK
		);

		if (Objects.equals(
				segmentsExperienceKey,
				SegmentsExperienceConstants.KEY_DEFAULT)) {

			return SegmentsExperienceConstants.ID_DEFAULT;
		}

		if (Validator.isNotNull(segmentsExperienceKey)) {
			SegmentsExperience segmentsExperience =
				_segmentsExperienceLocalService.fetchSegmentsExperience(
					groupId, segmentsExperienceKey);

			if (segmentsExperience != null) {
				return segmentsExperience.getSegmentsExperienceId();
			}
		}

		return -1;
	}

	private String _getSegmentsExperienceKey(long segmentsExperienceId) {
		if (segmentsExperienceId != SegmentsExperienceConstants.ID_DEFAULT) {
			SegmentsExperience segmentsExperience =
				_segmentsExperienceLocalService.fetchSegmentsExperience(
					segmentsExperienceId);

			if (segmentsExperience != null) {
				return segmentsExperience.getSegmentsExperienceKey();
			}
		}

		return SegmentsExperienceConstants.KEY_DEFAULT;
	}

	private long _getSelectedSegmentsExperienceId(
		HttpServletRequest httpServletRequest, boolean signedIn) {

		if (!signedIn) {
			return -1;
		}

		long selectedSegmentsExperienceId = ParamUtil.getLong(
			httpServletRequest, "segmentsExperienceId", -1);

		if ((selectedSegmentsExperienceId != -1) &&
			(selectedSegmentsExperienceId !=
				SegmentsExperienceConstants.ID_DEFAULT)) {

			SegmentsExperience segmentsExperience =
				_segmentsExperienceLocalService.fetchSegmentsExperience(
					selectedSegmentsExperienceId);

			if (segmentsExperience == null) {
				return -1;
			}
		}

		return selectedSegmentsExperienceId;
	}

	private void _setCookie(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, long segmentsExperienceId) {

		Cookie abTestVariantIdCookie = new Cookie(
			_AB_TEST_VARIANT_ID_COOKIE_NAME,
			_getSegmentsExperienceKey(segmentsExperienceId));

		String domain = CookieKeys.getDomain(httpServletRequest);

		if (Validator.isNotNull(domain)) {
			abTestVariantIdCookie.setDomain(domain);
		}

		abTestVariantIdCookie.setMaxAge(CookieKeys.MAX_AGE);
		abTestVariantIdCookie.setPath(StringPool.SLASH);

		CookieKeys.addCookie(
			httpServletRequest, httpServletResponse, abTestVariantIdCookie);
	}

	private void _unsetCookie(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		String domain = CookieKeys.getDomain(httpServletRequest);

		if (Validator.isNull(domain)) {
			domain = null;
		}

		CookieKeys.deleteCookies(
			httpServletRequest, httpServletResponse, domain,
			_AB_TEST_VARIANT_ID_COOKIE_NAME);
	}

	private static final String _AB_TEST_VARIANT_ID_COOKIE_NAME =
		"ab_test_variant_id";

	private static final Log _log = LogFactoryUtil.getLog(
		SegmentsExperimentSegmentsExperienceRequestProcessor.class);

	@Reference
	private Portal _portal;

	@Reference
	private SegmentsExperienceLocalService _segmentsExperienceLocalService;

	@Reference
	private SegmentsExperimentLocalService _segmentsExperimentLocalService;

	@Reference
	private SegmentsExperimentRelLocalService
		_segmentsExperimentRelLocalService;

}