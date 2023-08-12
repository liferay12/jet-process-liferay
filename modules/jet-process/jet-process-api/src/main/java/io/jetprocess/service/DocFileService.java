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

package io.jetprocess.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import io.jetprocess.model.DocFile;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DocFile. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DocFileServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DocFileService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>io.jetprocess.service.impl.DocFileServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the doc file remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DocFileServiceUtil} if injection and service tracking are not available.
	 */
	public JSONObject addDocFile(
			long groupId, String nature, String type, long basicHeadId,
			long primaryHeadId, long secondaryHeadId, long tertiaryHeadId,
			long year, long fileCodeId, String subject, String fileNumber,
			long categoryId, long subCategoryId, String remarks,
			String reference, long userPostId, ServiceContext serviceContext)
		throws PortalException;

	public DocFile deleteDocFile(long docFileId) throws PortalException;

	public DocFile editDocFile(
			String subject, long docFileId, long categoryId, long subCategoryId,
			String remarks, String reference)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DocFile getDocFileByDocFileId(long docFileId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DocFile> getDocFileList();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public DocFile updateDocFile(
			long docFileId, String subject, long categoryId, long subCategoryId,
			String remarks, String reference, long userPostId,
			ServiceContext serviceContext)
		throws PortalException;

}