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

package com.liferay.headless.delivery.client.serdes.v1_0;

import com.liferay.headless.delivery.client.dto.v1_0.ContentField;
import com.liferay.headless.delivery.client.dto.v1_0.CustomField;
import com.liferay.headless.delivery.client.dto.v1_0.RelatedContent;
import com.liferay.headless.delivery.client.dto.v1_0.RenderedContent;
import com.liferay.headless.delivery.client.dto.v1_0.StructuredContent;
import com.liferay.headless.delivery.client.dto.v1_0.TaxonomyCategory;
import com.liferay.headless.delivery.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class StructuredContentSerDes {

	public static StructuredContent toDTO(String json) {
		StructuredContentJSONParser structuredContentJSONParser =
			new StructuredContentJSONParser();

		return structuredContentJSONParser.parseToDTO(json);
	}

	public static StructuredContent[] toDTOs(String json) {
		StructuredContentJSONParser structuredContentJSONParser =
			new StructuredContentJSONParser();

		return structuredContentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(StructuredContent structuredContent) {
		if (structuredContent == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (structuredContent.getAggregateRating() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"aggregateRating\": ");

			sb.append(String.valueOf(structuredContent.getAggregateRating()));
		}

		if (structuredContent.getAvailableLanguages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableLanguages\": ");

			sb.append("[");

			for (int i = 0;
				 i < structuredContent.getAvailableLanguages().length; i++) {

				sb.append("\"");

				sb.append(
					_escape(structuredContent.getAvailableLanguages()[i]));

				sb.append("\"");

				if ((i + 1) <
						structuredContent.getAvailableLanguages().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getContentFields() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentFields\": ");

			sb.append("[");

			for (int i = 0; i < structuredContent.getContentFields().length;
				 i++) {

				sb.append(
					String.valueOf(structuredContent.getContentFields()[i]));

				if ((i + 1) < structuredContent.getContentFields().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getContentStructureId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentStructureId\": ");

			sb.append(structuredContent.getContentStructureId());
		}

		if (structuredContent.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(structuredContent.getCreator()));
		}

		if (structuredContent.getCustomFields() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"customFields\": ");

			sb.append("[");

			for (int i = 0; i < structuredContent.getCustomFields().length;
				 i++) {

				sb.append(
					String.valueOf(structuredContent.getCustomFields()[i]));

				if ((i + 1) < structuredContent.getCustomFields().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getDateCreated() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateCreated\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					structuredContent.getDateCreated()));

			sb.append("\"");
		}

		if (structuredContent.getDateModified() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateModified\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					structuredContent.getDateModified()));

			sb.append("\"");
		}

		if (structuredContent.getDatePublished() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"datePublished\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(
					structuredContent.getDatePublished()));

			sb.append("\"");
		}

		if (structuredContent.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(structuredContent.getDescription()));

			sb.append("\"");
		}

		if (structuredContent.getFriendlyUrlPath() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"friendlyUrlPath\": ");

			sb.append("\"");

			sb.append(_escape(structuredContent.getFriendlyUrlPath()));

			sb.append("\"");
		}

		if (structuredContent.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(structuredContent.getId());
		}

		if (structuredContent.getKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"key\": ");

			sb.append("\"");

			sb.append(_escape(structuredContent.getKey()));

			sb.append("\"");
		}

		if (structuredContent.getKeywords() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"keywords\": ");

			sb.append("[");

			for (int i = 0; i < structuredContent.getKeywords().length; i++) {
				sb.append("\"");

				sb.append(_escape(structuredContent.getKeywords()[i]));

				sb.append("\"");

				if ((i + 1) < structuredContent.getKeywords().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getNumberOfComments() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"numberOfComments\": ");

			sb.append(structuredContent.getNumberOfComments());
		}

		if (structuredContent.getRelatedContents() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"relatedContents\": ");

			sb.append("[");

			for (int i = 0; i < structuredContent.getRelatedContents().length;
				 i++) {

				sb.append(
					String.valueOf(structuredContent.getRelatedContents()[i]));

				if ((i + 1) < structuredContent.getRelatedContents().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getRenderedContents() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"renderedContents\": ");

			sb.append("[");

			for (int i = 0; i < structuredContent.getRenderedContents().length;
				 i++) {

				sb.append(
					String.valueOf(structuredContent.getRenderedContents()[i]));

				if ((i + 1) < structuredContent.getRenderedContents().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getSiteId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(structuredContent.getSiteId());
		}

		if (structuredContent.getTaxonomyCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxonomyCategories\": ");

			sb.append("[");

			for (int i = 0;
				 i < structuredContent.getTaxonomyCategories().length; i++) {

				sb.append(
					String.valueOf(
						structuredContent.getTaxonomyCategories()[i]));

				if ((i + 1) <
						structuredContent.getTaxonomyCategories().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getTaxonomyCategoryIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxonomyCategoryIds\": ");

			sb.append("[");

			for (int i = 0;
				 i < structuredContent.getTaxonomyCategoryIds().length; i++) {

				sb.append(structuredContent.getTaxonomyCategoryIds()[i]);

				if ((i + 1) <
						structuredContent.getTaxonomyCategoryIds().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (structuredContent.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(structuredContent.getTitle()));

			sb.append("\"");
		}

		if (structuredContent.getUuid() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uuid\": ");

			sb.append("\"");

			sb.append(_escape(structuredContent.getUuid()));

			sb.append("\"");
		}

		if (structuredContent.getViewableBy() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"viewableBy\": ");

			sb.append("\"");

			sb.append(structuredContent.getViewableBy());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StructuredContentJSONParser structuredContentJSONParser =
			new StructuredContentJSONParser();

		return structuredContentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		StructuredContent structuredContent) {

		if (structuredContent == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (structuredContent.getAggregateRating() == null) {
			map.put("aggregateRating", null);
		}
		else {
			map.put(
				"aggregateRating",
				String.valueOf(structuredContent.getAggregateRating()));
		}

		if (structuredContent.getAvailableLanguages() == null) {
			map.put("availableLanguages", null);
		}
		else {
			map.put(
				"availableLanguages",
				String.valueOf(structuredContent.getAvailableLanguages()));
		}

		if (structuredContent.getContentFields() == null) {
			map.put("contentFields", null);
		}
		else {
			map.put(
				"contentFields",
				String.valueOf(structuredContent.getContentFields()));
		}

		if (structuredContent.getContentStructureId() == null) {
			map.put("contentStructureId", null);
		}
		else {
			map.put(
				"contentStructureId",
				String.valueOf(structuredContent.getContentStructureId()));
		}

		if (structuredContent.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(structuredContent.getCreator()));
		}

		if (structuredContent.getCustomFields() == null) {
			map.put("customFields", null);
		}
		else {
			map.put(
				"customFields",
				String.valueOf(structuredContent.getCustomFields()));
		}

		map.put(
			"dateCreated",
			liferayToJSONDateFormat.format(structuredContent.getDateCreated()));

		map.put(
			"dateModified",
			liferayToJSONDateFormat.format(
				structuredContent.getDateModified()));

		map.put(
			"datePublished",
			liferayToJSONDateFormat.format(
				structuredContent.getDatePublished()));

		if (structuredContent.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(structuredContent.getDescription()));
		}

		if (structuredContent.getFriendlyUrlPath() == null) {
			map.put("friendlyUrlPath", null);
		}
		else {
			map.put(
				"friendlyUrlPath",
				String.valueOf(structuredContent.getFriendlyUrlPath()));
		}

		if (structuredContent.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(structuredContent.getId()));
		}

		if (structuredContent.getKey() == null) {
			map.put("key", null);
		}
		else {
			map.put("key", String.valueOf(structuredContent.getKey()));
		}

		if (structuredContent.getKeywords() == null) {
			map.put("keywords", null);
		}
		else {
			map.put(
				"keywords", String.valueOf(structuredContent.getKeywords()));
		}

		if (structuredContent.getNumberOfComments() == null) {
			map.put("numberOfComments", null);
		}
		else {
			map.put(
				"numberOfComments",
				String.valueOf(structuredContent.getNumberOfComments()));
		}

		if (structuredContent.getRelatedContents() == null) {
			map.put("relatedContents", null);
		}
		else {
			map.put(
				"relatedContents",
				String.valueOf(structuredContent.getRelatedContents()));
		}

		if (structuredContent.getRenderedContents() == null) {
			map.put("renderedContents", null);
		}
		else {
			map.put(
				"renderedContents",
				String.valueOf(structuredContent.getRenderedContents()));
		}

		if (structuredContent.getSiteId() == null) {
			map.put("siteId", null);
		}
		else {
			map.put("siteId", String.valueOf(structuredContent.getSiteId()));
		}

		if (structuredContent.getTaxonomyCategories() == null) {
			map.put("taxonomyCategories", null);
		}
		else {
			map.put(
				"taxonomyCategories",
				String.valueOf(structuredContent.getTaxonomyCategories()));
		}

		if (structuredContent.getTaxonomyCategoryIds() == null) {
			map.put("taxonomyCategoryIds", null);
		}
		else {
			map.put(
				"taxonomyCategoryIds",
				String.valueOf(structuredContent.getTaxonomyCategoryIds()));
		}

		if (structuredContent.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(structuredContent.getTitle()));
		}

		if (structuredContent.getUuid() == null) {
			map.put("uuid", null);
		}
		else {
			map.put("uuid", String.valueOf(structuredContent.getUuid()));
		}

		if (structuredContent.getViewableBy() == null) {
			map.put("viewableBy", null);
		}
		else {
			map.put(
				"viewableBy",
				String.valueOf(structuredContent.getViewableBy()));
		}

		return map;
	}

	public static class StructuredContentJSONParser
		extends BaseJSONParser<StructuredContent> {

		@Override
		protected StructuredContent createDTO() {
			return new StructuredContent();
		}

		@Override
		protected StructuredContent[] createDTOArray(int size) {
			return new StructuredContent[size];
		}

		@Override
		protected void setField(
			StructuredContent structuredContent, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "aggregateRating")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setAggregateRating(
						AggregateRatingSerDes.toDTO(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "availableLanguages")) {

				if (jsonParserFieldValue != null) {
					structuredContent.setAvailableLanguages(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contentFields")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setContentFields(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ContentFieldSerDes.toDTO((String)object)
						).toArray(
							size -> new ContentField[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "contentStructureId")) {

				if (jsonParserFieldValue != null) {
					structuredContent.setContentStructureId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "customFields")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setCustomFields(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CustomFieldSerDes.toDTO((String)object)
						).toArray(
							size -> new CustomField[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateCreated")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setDateCreated(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dateModified")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setDateModified(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "datePublished")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setDatePublished(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "friendlyUrlPath")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setFriendlyUrlPath(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "key")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setKey((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "keywords")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setKeywords(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "numberOfComments")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setNumberOfComments(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "relatedContents")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setRelatedContents(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> RelatedContentSerDes.toDTO((String)object)
						).toArray(
							size -> new RelatedContent[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "renderedContents")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setRenderedContents(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> RenderedContentSerDes.toDTO(
								(String)object)
						).toArray(
							size -> new RenderedContent[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "siteId")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setSiteId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "taxonomyCategories")) {

				if (jsonParserFieldValue != null) {
					structuredContent.setTaxonomyCategories(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> TaxonomyCategorySerDes.toDTO(
								(String)object)
						).toArray(
							size -> new TaxonomyCategory[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "taxonomyCategoryIds")) {

				if (jsonParserFieldValue != null) {
					structuredContent.setTaxonomyCategoryIds(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "uuid")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setUuid((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "viewableBy")) {
				if (jsonParserFieldValue != null) {
					structuredContent.setViewableBy(
						StructuredContent.ViewableBy.create(
							(String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		string = string.replace("\\", "\\\\");

		return string.replace("\"", "\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}