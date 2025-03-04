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

/**
 * @author Michael Hashimoto
 */
public class GitRepositoryArchivesDirResourceMonitor
	extends BaseReadWriteResourceMonitor {

	public GitRepositoryArchivesDirResourceMonitor(String etcdServerURL) {
		super(
			etcdServerURL, _NAME_ETCD_DIR,
			getAllowedResourceConnections(
				_NAME_ETCD_DIR, _ALLOWED_RESOURCE_CONNECTIONS_DEFAULT));
	}

	private static final Integer _ALLOWED_RESOURCE_CONNECTIONS_DEFAULT = 5;

	private static final String _NAME_ETCD_DIR = "git_repository_archives_dir";

}