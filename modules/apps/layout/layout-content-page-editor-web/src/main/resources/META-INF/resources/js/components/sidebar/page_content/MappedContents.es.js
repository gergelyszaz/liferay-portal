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

import PropTypes from 'prop-types';
import React from 'react';

import {MappedContent} from './MappedContent.es';

const MappedContents = props => {
	return (
		<ul className="list-unstyled">
			{props.mappedContents.map(mappedContent => (
				<MappedContent key={mappedContent.classPK} {...mappedContent} />
			))}
		</ul>
	);
};

MappedContents.propTypes = {
	mappedContents: PropTypes.arrayOf(
		PropTypes.shape({
			classPK: PropTypes.string
		})
	)
};

export {MappedContents};
export default MappedContents;
