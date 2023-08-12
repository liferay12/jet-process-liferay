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

package io.jetprocess.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptMovementService;
import io.jetprocess.service.ReceiptMovementServiceUtil;
import io.jetprocess.service.persistence.DocFilePersistence;
import io.jetprocess.service.persistence.DocumentNoteMapPersistence;
import io.jetprocess.service.persistence.FileCloseDetailPersistence;
import io.jetprocess.service.persistence.FileCorrReceiptPersistence;
import io.jetprocess.service.persistence.FileMovementPersistence;
import io.jetprocess.service.persistence.FileNotePersistence;
import io.jetprocess.service.persistence.NoteDocMovementPersistence;
import io.jetprocess.service.persistence.NoteDocumentPersistence;
import io.jetprocess.service.persistence.NotePersistence;
import io.jetprocess.service.persistence.ReceiptCloseDetailPersistence;
import io.jetprocess.service.persistence.ReceiptMovementPersistence;
import io.jetprocess.service.persistence.ReceiptPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the receipt movement remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link io.jetprocess.service.impl.ReceiptMovementServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.jetprocess.service.impl.ReceiptMovementServiceImpl
 * @generated
 */
public abstract class ReceiptMovementServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, ReceiptMovementService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ReceiptMovementService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ReceiptMovementServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ReceiptMovementService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		receiptMovementService = (ReceiptMovementService)aopProxy;

		_setServiceUtilService(receiptMovementService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ReceiptMovementService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ReceiptMovement.class;
	}

	protected String getModelClassName() {
		return ReceiptMovement.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = receiptMovementPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		ReceiptMovementService receiptMovementService) {

		try {
			Field field = ReceiptMovementServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, receiptMovementService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DocFilePersistence docFilePersistence;

	@Reference
	protected DocumentNoteMapPersistence documentNoteMapPersistence;

	@Reference
	protected FileCloseDetailPersistence fileCloseDetailPersistence;

	@Reference
	protected FileCorrReceiptPersistence fileCorrReceiptPersistence;

	@Reference
	protected FileMovementPersistence fileMovementPersistence;

	@Reference
	protected FileNotePersistence fileNotePersistence;

	@Reference
	protected NotePersistence notePersistence;

	@Reference
	protected NoteDocMovementPersistence noteDocMovementPersistence;

	@Reference
	protected NoteDocumentPersistence noteDocumentPersistence;

	@Reference
	protected ReceiptPersistence receiptPersistence;

	@Reference
	protected ReceiptCloseDetailPersistence receiptCloseDetailPersistence;

	@Reference
	protected io.jetprocess.service.ReceiptMovementLocalService
		receiptMovementLocalService;

	protected ReceiptMovementService receiptMovementService;

	@Reference
	protected ReceiptMovementPersistence receiptMovementPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.GroupService groupService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

}