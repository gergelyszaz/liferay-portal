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

package com.liferay.headless.admin.taxonomy.client.serdes.v1_0;

import com.liferay.headless.admin.taxonomy.client.dto.v1_0.Creator;
import com.liferay.headless.admin.taxonomy.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class CreatorSerDes {

	public static Creator toDTO(String json) {
		CreatorJSONParser creatorJSONParser = new CreatorJSONParser();

		return creatorJSONParser.parseToDTO(json);
	}

	public static Creator[] toDTOs(String json) {
		CreatorJSONParser creatorJSONParser = new CreatorJSONParser();

		return creatorJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Creator creator) {
		if (creator == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (creator.getAdditionalName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"additionalName\": ");

			sb.append("\"");

			sb.append(_escape(creator.getAdditionalName()));

			sb.append("\"");
		}

		if (creator.getFamilyName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"familyName\": ");

			sb.append("\"");

			sb.append(_escape(creator.getFamilyName()));

			sb.append("\"");
		}

		if (creator.getGivenName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"givenName\": ");

			sb.append("\"");

			sb.append(_escape(creator.getGivenName()));

			sb.append("\"");
		}

		if (creator.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(creator.getId());
		}

		if (creator.getImage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(creator.getImage()));

			sb.append("\"");
		}

		if (creator.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(creator.getName()));

			sb.append("\"");
		}

		if (creator.getProfileURL() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"profileURL\": ");

			sb.append("\"");

			sb.append(_escape(creator.getProfileURL()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CreatorJSONParser creatorJSONParser = new CreatorJSONParser();

		return creatorJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Creator creator) {
		if (creator == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (creator.getAdditionalName() == null) {
			map.put("additionalName", null);
		}
		else {
			map.put(
				"additionalName", String.valueOf(creator.getAdditionalName()));
		}

		if (creator.getFamilyName() == null) {
			map.put("familyName", null);
		}
		else {
			map.put("familyName", String.valueOf(creator.getFamilyName()));
		}

		if (creator.getGivenName() == null) {
			map.put("givenName", null);
		}
		else {
			map.put("givenName", String.valueOf(creator.getGivenName()));
		}

		if (creator.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(creator.getId()));
		}

		if (creator.getImage() == null) {
			map.put("image", null);
		}
		else {
			map.put("image", String.valueOf(creator.getImage()));
		}

		if (creator.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(creator.getName()));
		}

		if (creator.getProfileURL() == null) {
			map.put("profileURL", null);
		}
		else {
			map.put("profileURL", String.valueOf(creator.getProfileURL()));
		}

		return map;
	}

	public static class CreatorJSONParser extends BaseJSONParser<Creator> {

		@Override
		protected Creator createDTO() {
			return new Creator();
		}

		@Override
		protected Creator[] createDTOArray(int size) {
			return new Creator[size];
		}

		@Override
		protected void setField(
			Creator creator, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "additionalName")) {
				if (jsonParserFieldValue != null) {
					creator.setAdditionalName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "familyName")) {
				if (jsonParserFieldValue != null) {
					creator.setFamilyName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "givenName")) {
				if (jsonParserFieldValue != null) {
					creator.setGivenName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					creator.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "image")) {
				if (jsonParserFieldValue != null) {
					creator.setImage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					creator.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "profileURL")) {
				if (jsonParserFieldValue != null) {
					creator.setProfileURL((String)jsonParserFieldValue);
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