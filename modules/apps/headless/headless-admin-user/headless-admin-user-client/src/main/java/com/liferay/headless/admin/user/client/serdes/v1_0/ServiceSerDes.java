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

package com.liferay.headless.admin.user.client.serdes.v1_0;

import com.liferay.headless.admin.user.client.dto.v1_0.HoursAvailable;
import com.liferay.headless.admin.user.client.dto.v1_0.Service;
import com.liferay.headless.admin.user.client.json.BaseJSONParser;

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
public class ServiceSerDes {

	public static Service toDTO(String json) {
		ServiceJSONParser serviceJSONParser = new ServiceJSONParser();

		return serviceJSONParser.parseToDTO(json);
	}

	public static Service[] toDTOs(String json) {
		ServiceJSONParser serviceJSONParser = new ServiceJSONParser();

		return serviceJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Service service) {
		if (service == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (service.getHoursAvailable() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hoursAvailable\": ");

			sb.append("[");

			for (int i = 0; i < service.getHoursAvailable().length; i++) {
				sb.append(String.valueOf(service.getHoursAvailable()[i]));

				if ((i + 1) < service.getHoursAvailable().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (service.getServiceType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"serviceType\": ");

			sb.append("\"");

			sb.append(_escape(service.getServiceType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ServiceJSONParser serviceJSONParser = new ServiceJSONParser();

		return serviceJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Service service) {
		if (service == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (service.getHoursAvailable() == null) {
			map.put("hoursAvailable", null);
		}
		else {
			map.put(
				"hoursAvailable", String.valueOf(service.getHoursAvailable()));
		}

		if (service.getServiceType() == null) {
			map.put("serviceType", null);
		}
		else {
			map.put("serviceType", String.valueOf(service.getServiceType()));
		}

		return map;
	}

	public static class ServiceJSONParser extends BaseJSONParser<Service> {

		@Override
		protected Service createDTO() {
			return new Service();
		}

		@Override
		protected Service[] createDTOArray(int size) {
			return new Service[size];
		}

		@Override
		protected void setField(
			Service service, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "hoursAvailable")) {
				if (jsonParserFieldValue != null) {
					service.setHoursAvailable(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> HoursAvailableSerDes.toDTO((String)object)
						).toArray(
							size -> new HoursAvailable[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "serviceType")) {
				if (jsonParserFieldValue != null) {
					service.setServiceType((String)jsonParserFieldValue);
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