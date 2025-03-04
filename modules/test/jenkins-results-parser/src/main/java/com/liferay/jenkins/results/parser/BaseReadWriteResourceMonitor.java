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

package com.liferay.jenkins.results.parser;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Michael Hashimoto
 */
public abstract class BaseReadWriteResourceMonitor
	extends BaseResourceMonitor implements ReadWriteResourceMonitor {

	public BaseReadWriteResourceMonitor(
		String etcdServerURL, String monitorName, Integer readMaxConnections) {

		super(etcdServerURL, monitorName, readMaxConnections);

		_writeResourceMonitor = new DefaultResourceMonitor(
			etcdServerURL, monitorName + "_write", 1);
	}

	@Override
	public synchronized List<ResourceConnection> getResourceConnectionQueue() {
		Set<ResourceConnection> resourceConnections = new TreeSet<>();

		resourceConnections.addAll(super.getResourceConnectionQueue());
		resourceConnections.addAll(
			_writeResourceMonitor.getResourceConnectionQueue());

		return new ArrayList<>(resourceConnections);
	}

	@Override
	public void signalWrite(String connectionName) {
		_writeResourceMonitor.signal(connectionName);
	}

	@Override
	public void wait(String connectionName) {
		wait(connectionName, this, _writeResourceMonitor.getName());
	}

	@Override
	public void waitWrite(String connectionName) {
		wait(connectionName, _writeResourceMonitor, getName());
	}

	protected static final Integer getAllowedResourceConnections(
		String etcdBaseDirName, Integer defaultAllowedResourceConnections) {

		try {
			Properties buildProperties =
				JenkinsResultsParserUtil.getBuildProperties();

			String allowedResourceConnectionsKey =
				JenkinsResultsParserUtil.combine(
					"resource.monitor.allowed.resource.connections[",
					etcdBaseDirName, "]");

			if (!buildProperties.containsKey(allowedResourceConnectionsKey)) {
				return defaultAllowedResourceConnections;
			}

			return Integer.valueOf(
				buildProperties.getProperty(allowedResourceConnectionsKey));
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return defaultAllowedResourceConnections;
	}

	private final ResourceMonitor _writeResourceMonitor;

}