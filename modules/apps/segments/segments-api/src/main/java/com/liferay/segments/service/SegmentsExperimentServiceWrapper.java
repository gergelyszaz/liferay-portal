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

package com.liferay.segments.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link SegmentsExperimentService}.
 *
 * @author Eduardo Garcia
 * @see SegmentsExperimentService
 * @generated
 */
@ProviderType
public class SegmentsExperimentServiceWrapper
	implements SegmentsExperimentService,
			   ServiceWrapper<SegmentsExperimentService> {

	public SegmentsExperimentServiceWrapper(
		SegmentsExperimentService segmentsExperimentService) {

		_segmentsExperimentService = segmentsExperimentService;
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment addSegmentsExperiment(
			long segmentsExperienceId, long classNameId, long classPK,
			String name, String description, String goal, String goalTarget,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.addSegmentsExperiment(
			segmentsExperienceId, classNameId, classPK, name, description, goal,
			goalTarget, serviceContext);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			deleteSegmentsExperiment(long segmentsExperimentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.deleteSegmentsExperiment(
			segmentsExperimentId);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			deleteSegmentsExperiment(String segmentsExperimentKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.deleteSegmentsExperiment(
			segmentsExperimentKey);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			fetchSegmentsExperiment(
				long segmentsExperienceId, long classNameId, long classPK,
				int[] statuses)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.fetchSegmentsExperiment(
			segmentsExperienceId, classNameId, classPK, statuses);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			fetchSegmentsExperiment(long groupId, String segmentsExperimentKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.fetchSegmentsExperiment(
			groupId, segmentsExperimentKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _segmentsExperimentService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.segments.model.SegmentsExperiment>
			getSegmentsExperienceSegmentsExperiments(
				long[] segmentsExperienceIds, long classNameId, long classPK,
				int[] statuses, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.
			getSegmentsExperienceSegmentsExperiments(
				segmentsExperienceIds, classNameId, classPK, statuses, start,
				end);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment getSegmentsExperiment(
			long segmentsExperimentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.getSegmentsExperiment(
			segmentsExperimentId);
	}

	@Override
	public java.util.List<com.liferay.segments.model.SegmentsExperiment>
		getSegmentsExperiments(long groupId, long classNameId, long classPK) {

		return _segmentsExperimentService.getSegmentsExperiments(
			groupId, classNameId, classPK);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			updateSegmentsExperiment(
				long segmentsExperimentId, double confidenceLevel, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.updateSegmentsExperiment(
			segmentsExperimentId, confidenceLevel, status);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			updateSegmentsExperiment(long segmentsExperimentId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.updateSegmentsExperiment(
			segmentsExperimentId, status);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			updateSegmentsExperiment(
				long segmentsExperimentId, String name, String description,
				String goal, String goalTarget)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.updateSegmentsExperiment(
			segmentsExperimentId, name, description, goal, goalTarget);
	}

	@Override
	public com.liferay.segments.model.SegmentsExperiment
			updateSegmentsExperiment(String segmentsExperimentKey, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _segmentsExperimentService.updateSegmentsExperiment(
			segmentsExperimentKey, status);
	}

	@Override
	public SegmentsExperimentService getWrappedService() {
		return _segmentsExperimentService;
	}

	@Override
	public void setWrappedService(
		SegmentsExperimentService segmentsExperimentService) {

		_segmentsExperimentService = segmentsExperimentService;
	}

	private SegmentsExperimentService _segmentsExperimentService;

}