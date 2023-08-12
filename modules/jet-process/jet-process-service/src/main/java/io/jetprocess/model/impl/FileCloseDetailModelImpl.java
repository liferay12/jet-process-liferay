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

package io.jetprocess.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import io.jetprocess.model.FileCloseDetail;
import io.jetprocess.model.FileCloseDetailModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the FileCloseDetail service. Represents a row in the &quot;JET_PROCESS_FileCloseDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FileCloseDetailModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileCloseDetailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCloseDetailImpl
 * @generated
 */
@JSON(strict = true)
public class FileCloseDetailModelImpl
	extends BaseModelImpl<FileCloseDetail> implements FileCloseDetailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file close detail model instance should use the <code>FileCloseDetail</code> interface instead.
	 */
	public static final String TABLE_NAME = "JET_PROCESS_FileCloseDetail";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"fileClosedId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"fileId", Types.BIGINT}, {"closedBy", Types.BIGINT},
		{"closingRemarks", Types.VARCHAR}, {"reopenDate", Types.TIMESTAMP},
		{"reopenRemarks", Types.VARCHAR}, {"closedMovementId", Types.BIGINT},
		{"reopenBy", Types.BIGINT}, {"reopenMovementId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileClosedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("closedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("closingRemarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reopenDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("reopenRemarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("closedMovementId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reopenBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reopenMovementId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JET_PROCESS_FileCloseDetail (uuid_ VARCHAR(75) null,fileClosedId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,fileId LONG,closedBy LONG,closingRemarks VARCHAR(500) null,reopenDate DATE null,reopenRemarks VARCHAR(75) null,closedMovementId LONG,reopenBy LONG,reopenMovementId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table JET_PROCESS_FileCloseDetail";

	public static final String ORDER_BY_JPQL =
		" ORDER BY fileCloseDetail.fileClosedId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JET_PROCESS_FileCloseDetail.fileClosedId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILECLOSEDID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public FileCloseDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileClosedId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileClosedId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileClosedId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FileCloseDetail.class;
	}

	@Override
	public String getModelClassName() {
		return FileCloseDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FileCloseDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FileCloseDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCloseDetail, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FileCloseDetail)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FileCloseDetail, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FileCloseDetail, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FileCloseDetail)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FileCloseDetail, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FileCloseDetail, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FileCloseDetail, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FileCloseDetail, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FileCloseDetail, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<FileCloseDetail, Object>>();
		Map<String, BiConsumer<FileCloseDetail, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<FileCloseDetail, ?>>();

		attributeGetterFunctions.put("uuid", FileCloseDetail::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FileCloseDetail, String>)FileCloseDetail::setUuid);
		attributeGetterFunctions.put(
			"fileClosedId", FileCloseDetail::getFileClosedId);
		attributeSetterBiConsumers.put(
			"fileClosedId",
			(BiConsumer<FileCloseDetail, Long>)
				FileCloseDetail::setFileClosedId);
		attributeGetterFunctions.put("groupId", FileCloseDetail::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FileCloseDetail::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setCompanyId);
		attributeGetterFunctions.put("userId", FileCloseDetail::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setUserId);
		attributeGetterFunctions.put("userName", FileCloseDetail::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<FileCloseDetail, String>)FileCloseDetail::setUserName);
		attributeGetterFunctions.put(
			"createDate", FileCloseDetail::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FileCloseDetail, Date>)FileCloseDetail::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FileCloseDetail::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FileCloseDetail, Date>)
				FileCloseDetail::setModifiedDate);
		attributeGetterFunctions.put("fileId", FileCloseDetail::getFileId);
		attributeSetterBiConsumers.put(
			"fileId",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setFileId);
		attributeGetterFunctions.put("closedBy", FileCloseDetail::getClosedBy);
		attributeSetterBiConsumers.put(
			"closedBy",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setClosedBy);
		attributeGetterFunctions.put(
			"closingRemarks", FileCloseDetail::getClosingRemarks);
		attributeSetterBiConsumers.put(
			"closingRemarks",
			(BiConsumer<FileCloseDetail, String>)
				FileCloseDetail::setClosingRemarks);
		attributeGetterFunctions.put(
			"reopenDate", FileCloseDetail::getReopenDate);
		attributeSetterBiConsumers.put(
			"reopenDate",
			(BiConsumer<FileCloseDetail, Date>)FileCloseDetail::setReopenDate);
		attributeGetterFunctions.put(
			"reopenRemarks", FileCloseDetail::getReopenRemarks);
		attributeSetterBiConsumers.put(
			"reopenRemarks",
			(BiConsumer<FileCloseDetail, String>)
				FileCloseDetail::setReopenRemarks);
		attributeGetterFunctions.put(
			"closedMovementId", FileCloseDetail::getClosedMovementId);
		attributeSetterBiConsumers.put(
			"closedMovementId",
			(BiConsumer<FileCloseDetail, Long>)
				FileCloseDetail::setClosedMovementId);
		attributeGetterFunctions.put("reopenBy", FileCloseDetail::getReopenBy);
		attributeSetterBiConsumers.put(
			"reopenBy",
			(BiConsumer<FileCloseDetail, Long>)FileCloseDetail::setReopenBy);
		attributeGetterFunctions.put(
			"reopenMovementId", FileCloseDetail::getReopenMovementId);
		attributeSetterBiConsumers.put(
			"reopenMovementId",
			(BiConsumer<FileCloseDetail, Long>)
				FileCloseDetail::setReopenMovementId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getFileClosedId() {
		return _fileClosedId;
	}

	@Override
	public void setFileClosedId(long fileClosedId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileClosedId = fileClosedId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileId = fileId;
	}

	@JSON
	@Override
	public long getClosedBy() {
		return _closedBy;
	}

	@Override
	public void setClosedBy(long closedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_closedBy = closedBy;
	}

	@JSON
	@Override
	public String getClosingRemarks() {
		if (_closingRemarks == null) {
			return "";
		}
		else {
			return _closingRemarks;
		}
	}

	@Override
	public void setClosingRemarks(String closingRemarks) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_closingRemarks = closingRemarks;
	}

	@JSON
	@Override
	public Date getReopenDate() {
		return _reopenDate;
	}

	@Override
	public void setReopenDate(Date reopenDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reopenDate = reopenDate;
	}

	@JSON
	@Override
	public String getReopenRemarks() {
		if (_reopenRemarks == null) {
			return "";
		}
		else {
			return _reopenRemarks;
		}
	}

	@Override
	public void setReopenRemarks(String reopenRemarks) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reopenRemarks = reopenRemarks;
	}

	@JSON
	@Override
	public long getClosedMovementId() {
		return _closedMovementId;
	}

	@Override
	public void setClosedMovementId(long closedMovementId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_closedMovementId = closedMovementId;
	}

	@JSON
	@Override
	public long getReopenBy() {
		return _reopenBy;
	}

	@Override
	public void setReopenBy(long reopenBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reopenBy = reopenBy;
	}

	@JSON
	@Override
	public long getReopenMovementId() {
		return _reopenMovementId;
	}

	@Override
	public void setReopenMovementId(long reopenMovementId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reopenMovementId = reopenMovementId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(FileCloseDetail.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), FileCloseDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileCloseDetail toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FileCloseDetail>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FileCloseDetailImpl fileCloseDetailImpl = new FileCloseDetailImpl();

		fileCloseDetailImpl.setUuid(getUuid());
		fileCloseDetailImpl.setFileClosedId(getFileClosedId());
		fileCloseDetailImpl.setGroupId(getGroupId());
		fileCloseDetailImpl.setCompanyId(getCompanyId());
		fileCloseDetailImpl.setUserId(getUserId());
		fileCloseDetailImpl.setUserName(getUserName());
		fileCloseDetailImpl.setCreateDate(getCreateDate());
		fileCloseDetailImpl.setModifiedDate(getModifiedDate());
		fileCloseDetailImpl.setFileId(getFileId());
		fileCloseDetailImpl.setClosedBy(getClosedBy());
		fileCloseDetailImpl.setClosingRemarks(getClosingRemarks());
		fileCloseDetailImpl.setReopenDate(getReopenDate());
		fileCloseDetailImpl.setReopenRemarks(getReopenRemarks());
		fileCloseDetailImpl.setClosedMovementId(getClosedMovementId());
		fileCloseDetailImpl.setReopenBy(getReopenBy());
		fileCloseDetailImpl.setReopenMovementId(getReopenMovementId());

		fileCloseDetailImpl.resetOriginalValues();

		return fileCloseDetailImpl;
	}

	@Override
	public FileCloseDetail cloneWithOriginalValues() {
		FileCloseDetailImpl fileCloseDetailImpl = new FileCloseDetailImpl();

		fileCloseDetailImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		fileCloseDetailImpl.setFileClosedId(
			this.<Long>getColumnOriginalValue("fileClosedId"));
		fileCloseDetailImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		fileCloseDetailImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		fileCloseDetailImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		fileCloseDetailImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		fileCloseDetailImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		fileCloseDetailImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		fileCloseDetailImpl.setFileId(
			this.<Long>getColumnOriginalValue("fileId"));
		fileCloseDetailImpl.setClosedBy(
			this.<Long>getColumnOriginalValue("closedBy"));
		fileCloseDetailImpl.setClosingRemarks(
			this.<String>getColumnOriginalValue("closingRemarks"));
		fileCloseDetailImpl.setReopenDate(
			this.<Date>getColumnOriginalValue("reopenDate"));
		fileCloseDetailImpl.setReopenRemarks(
			this.<String>getColumnOriginalValue("reopenRemarks"));
		fileCloseDetailImpl.setClosedMovementId(
			this.<Long>getColumnOriginalValue("closedMovementId"));
		fileCloseDetailImpl.setReopenBy(
			this.<Long>getColumnOriginalValue("reopenBy"));
		fileCloseDetailImpl.setReopenMovementId(
			this.<Long>getColumnOriginalValue("reopenMovementId"));

		return fileCloseDetailImpl;
	}

	@Override
	public int compareTo(FileCloseDetail fileCloseDetail) {
		long primaryKey = fileCloseDetail.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileCloseDetail)) {
			return false;
		}

		FileCloseDetail fileCloseDetail = (FileCloseDetail)object;

		long primaryKey = fileCloseDetail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<FileCloseDetail> toCacheModel() {
		FileCloseDetailCacheModel fileCloseDetailCacheModel =
			new FileCloseDetailCacheModel();

		fileCloseDetailCacheModel.uuid = getUuid();

		String uuid = fileCloseDetailCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fileCloseDetailCacheModel.uuid = null;
		}

		fileCloseDetailCacheModel.fileClosedId = getFileClosedId();

		fileCloseDetailCacheModel.groupId = getGroupId();

		fileCloseDetailCacheModel.companyId = getCompanyId();

		fileCloseDetailCacheModel.userId = getUserId();

		fileCloseDetailCacheModel.userName = getUserName();

		String userName = fileCloseDetailCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fileCloseDetailCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fileCloseDetailCacheModel.createDate = createDate.getTime();
		}
		else {
			fileCloseDetailCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fileCloseDetailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fileCloseDetailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fileCloseDetailCacheModel.fileId = getFileId();

		fileCloseDetailCacheModel.closedBy = getClosedBy();

		fileCloseDetailCacheModel.closingRemarks = getClosingRemarks();

		String closingRemarks = fileCloseDetailCacheModel.closingRemarks;

		if ((closingRemarks != null) && (closingRemarks.length() == 0)) {
			fileCloseDetailCacheModel.closingRemarks = null;
		}

		Date reopenDate = getReopenDate();

		if (reopenDate != null) {
			fileCloseDetailCacheModel.reopenDate = reopenDate.getTime();
		}
		else {
			fileCloseDetailCacheModel.reopenDate = Long.MIN_VALUE;
		}

		fileCloseDetailCacheModel.reopenRemarks = getReopenRemarks();

		String reopenRemarks = fileCloseDetailCacheModel.reopenRemarks;

		if ((reopenRemarks != null) && (reopenRemarks.length() == 0)) {
			fileCloseDetailCacheModel.reopenRemarks = null;
		}

		fileCloseDetailCacheModel.closedMovementId = getClosedMovementId();

		fileCloseDetailCacheModel.reopenBy = getReopenBy();

		fileCloseDetailCacheModel.reopenMovementId = getReopenMovementId();

		return fileCloseDetailCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FileCloseDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FileCloseDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCloseDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((FileCloseDetail)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<FileCloseDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FileCloseDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCloseDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FileCloseDetail)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FileCloseDetail>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					FileCloseDetail.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _fileClosedId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _fileId;
	private long _closedBy;
	private String _closingRemarks;
	private Date _reopenDate;
	private String _reopenRemarks;
	private long _closedMovementId;
	private long _reopenBy;
	private long _reopenMovementId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FileCloseDetail, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FileCloseDetail)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("fileClosedId", _fileClosedId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("fileId", _fileId);
		_columnOriginalValues.put("closedBy", _closedBy);
		_columnOriginalValues.put("closingRemarks", _closingRemarks);
		_columnOriginalValues.put("reopenDate", _reopenDate);
		_columnOriginalValues.put("reopenRemarks", _reopenRemarks);
		_columnOriginalValues.put("closedMovementId", _closedMovementId);
		_columnOriginalValues.put("reopenBy", _reopenBy);
		_columnOriginalValues.put("reopenMovementId", _reopenMovementId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("fileClosedId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("fileId", 256L);

		columnBitmasks.put("closedBy", 512L);

		columnBitmasks.put("closingRemarks", 1024L);

		columnBitmasks.put("reopenDate", 2048L);

		columnBitmasks.put("reopenRemarks", 4096L);

		columnBitmasks.put("closedMovementId", 8192L);

		columnBitmasks.put("reopenBy", 16384L);

		columnBitmasks.put("reopenMovementId", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FileCloseDetail _escapedModel;

}