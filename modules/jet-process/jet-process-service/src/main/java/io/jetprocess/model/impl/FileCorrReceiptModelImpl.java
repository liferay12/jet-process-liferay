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

import io.jetprocess.model.FileCorrReceipt;
import io.jetprocess.model.FileCorrReceiptModel;

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
 * The base model implementation for the FileCorrReceipt service. Represents a row in the &quot;JET_PROCESS_FileCorrReceipt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FileCorrReceiptModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileCorrReceiptImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileCorrReceiptImpl
 * @generated
 */
@JSON(strict = true)
public class FileCorrReceiptModelImpl
	extends BaseModelImpl<FileCorrReceipt> implements FileCorrReceiptModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file corr receipt model instance should use the <code>FileCorrReceipt</code> interface instead.
	 */
	public static final String TABLE_NAME = "JET_PROCESS_FileCorrReceipt";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"fileCorrReceiptId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"docFileId", Types.BIGINT},
		{"receiptId", Types.BIGINT}, {"userPostId", Types.BIGINT},
		{"receiptMovementId", Types.BIGINT},
		{"correspondenceType", Types.VARCHAR}, {"remarks", Types.VARCHAR},
		{"fileMovementId", Types.BIGINT}, {"detachRemark", Types.VARCHAR},
		{"detachBy", Types.BIGINT}, {"detachOn", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileCorrReceiptId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("docFileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("receiptId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userPostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("receiptMovementId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("correspondenceType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("remarks", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileMovementId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("detachRemark", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("detachBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("detachOn", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JET_PROCESS_FileCorrReceipt (uuid_ VARCHAR(75) null,fileCorrReceiptId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,docFileId LONG,receiptId LONG,userPostId LONG,receiptMovementId LONG,correspondenceType VARCHAR(75) null,remarks VARCHAR(75) null,fileMovementId LONG,detachRemark VARCHAR(75) null,detachBy LONG,detachOn DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table JET_PROCESS_FileCorrReceipt";

	public static final String ORDER_BY_JPQL =
		" ORDER BY fileCorrReceipt.fileCorrReceiptId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JET_PROCESS_FileCorrReceipt.fileCorrReceiptId ASC";

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
	public static final long DOCFILEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RECEIPTID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long RECEIPTMOVEMENTID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FILECORRRECEIPTID_COLUMN_BITMASK = 64L;

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

	public FileCorrReceiptModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileCorrReceiptId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileCorrReceiptId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileCorrReceiptId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FileCorrReceipt.class;
	}

	@Override
	public String getModelClassName() {
		return FileCorrReceipt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FileCorrReceipt, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FileCorrReceipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCorrReceipt, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FileCorrReceipt)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FileCorrReceipt, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FileCorrReceipt, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FileCorrReceipt)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FileCorrReceipt, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FileCorrReceipt, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FileCorrReceipt, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FileCorrReceipt, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FileCorrReceipt, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<FileCorrReceipt, Object>>();
		Map<String, BiConsumer<FileCorrReceipt, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<FileCorrReceipt, ?>>();

		attributeGetterFunctions.put("uuid", FileCorrReceipt::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FileCorrReceipt, String>)FileCorrReceipt::setUuid);
		attributeGetterFunctions.put(
			"fileCorrReceiptId", FileCorrReceipt::getFileCorrReceiptId);
		attributeSetterBiConsumers.put(
			"fileCorrReceiptId",
			(BiConsumer<FileCorrReceipt, Long>)
				FileCorrReceipt::setFileCorrReceiptId);
		attributeGetterFunctions.put("groupId", FileCorrReceipt::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FileCorrReceipt::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setCompanyId);
		attributeGetterFunctions.put("userId", FileCorrReceipt::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setUserId);
		attributeGetterFunctions.put(
			"createDate", FileCorrReceipt::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FileCorrReceipt, Date>)FileCorrReceipt::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FileCorrReceipt::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FileCorrReceipt, Date>)
				FileCorrReceipt::setModifiedDate);
		attributeGetterFunctions.put(
			"docFileId", FileCorrReceipt::getDocFileId);
		attributeSetterBiConsumers.put(
			"docFileId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setDocFileId);
		attributeGetterFunctions.put(
			"receiptId", FileCorrReceipt::getReceiptId);
		attributeSetterBiConsumers.put(
			"receiptId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setReceiptId);
		attributeGetterFunctions.put(
			"userPostId", FileCorrReceipt::getUserPostId);
		attributeSetterBiConsumers.put(
			"userPostId",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setUserPostId);
		attributeGetterFunctions.put(
			"receiptMovementId", FileCorrReceipt::getReceiptMovementId);
		attributeSetterBiConsumers.put(
			"receiptMovementId",
			(BiConsumer<FileCorrReceipt, Long>)
				FileCorrReceipt::setReceiptMovementId);
		attributeGetterFunctions.put(
			"correspondenceType", FileCorrReceipt::getCorrespondenceType);
		attributeSetterBiConsumers.put(
			"correspondenceType",
			(BiConsumer<FileCorrReceipt, String>)
				FileCorrReceipt::setCorrespondenceType);
		attributeGetterFunctions.put("remarks", FileCorrReceipt::getRemarks);
		attributeSetterBiConsumers.put(
			"remarks",
			(BiConsumer<FileCorrReceipt, String>)FileCorrReceipt::setRemarks);
		attributeGetterFunctions.put(
			"fileMovementId", FileCorrReceipt::getFileMovementId);
		attributeSetterBiConsumers.put(
			"fileMovementId",
			(BiConsumer<FileCorrReceipt, Long>)
				FileCorrReceipt::setFileMovementId);
		attributeGetterFunctions.put(
			"detachRemark", FileCorrReceipt::getDetachRemark);
		attributeSetterBiConsumers.put(
			"detachRemark",
			(BiConsumer<FileCorrReceipt, String>)
				FileCorrReceipt::setDetachRemark);
		attributeGetterFunctions.put("detachBy", FileCorrReceipt::getDetachBy);
		attributeSetterBiConsumers.put(
			"detachBy",
			(BiConsumer<FileCorrReceipt, Long>)FileCorrReceipt::setDetachBy);
		attributeGetterFunctions.put("detachOn", FileCorrReceipt::getDetachOn);
		attributeSetterBiConsumers.put(
			"detachOn",
			(BiConsumer<FileCorrReceipt, Date>)FileCorrReceipt::setDetachOn);

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
	public long getFileCorrReceiptId() {
		return _fileCorrReceiptId;
	}

	@Override
	public void setFileCorrReceiptId(long fileCorrReceiptId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileCorrReceiptId = fileCorrReceiptId;
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
	public long getDocFileId() {
		return _docFileId;
	}

	@Override
	public void setDocFileId(long docFileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_docFileId = docFileId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDocFileId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("docFileId"));
	}

	@JSON
	@Override
	public long getReceiptId() {
		return _receiptId;
	}

	@Override
	public void setReceiptId(long receiptId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receiptId = receiptId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalReceiptId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("receiptId"));
	}

	@JSON
	@Override
	public long getUserPostId() {
		return _userPostId;
	}

	@Override
	public void setUserPostId(long userPostId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userPostId = userPostId;
	}

	@JSON
	@Override
	public long getReceiptMovementId() {
		return _receiptMovementId;
	}

	@Override
	public void setReceiptMovementId(long receiptMovementId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_receiptMovementId = receiptMovementId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalReceiptMovementId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("receiptMovementId"));
	}

	@JSON
	@Override
	public String getCorrespondenceType() {
		if (_correspondenceType == null) {
			return "";
		}
		else {
			return _correspondenceType;
		}
	}

	@Override
	public void setCorrespondenceType(String correspondenceType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_correspondenceType = correspondenceType;
	}

	@JSON
	@Override
	public String getRemarks() {
		if (_remarks == null) {
			return "";
		}
		else {
			return _remarks;
		}
	}

	@Override
	public void setRemarks(String remarks) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_remarks = remarks;
	}

	@JSON
	@Override
	public long getFileMovementId() {
		return _fileMovementId;
	}

	@Override
	public void setFileMovementId(long fileMovementId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileMovementId = fileMovementId;
	}

	@JSON
	@Override
	public String getDetachRemark() {
		if (_detachRemark == null) {
			return "";
		}
		else {
			return _detachRemark;
		}
	}

	@Override
	public void setDetachRemark(String detachRemark) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detachRemark = detachRemark;
	}

	@JSON
	@Override
	public long getDetachBy() {
		return _detachBy;
	}

	@Override
	public void setDetachBy(long detachBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detachBy = detachBy;
	}

	@JSON
	@Override
	public Date getDetachOn() {
		return _detachOn;
	}

	@Override
	public void setDetachOn(Date detachOn) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detachOn = detachOn;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(FileCorrReceipt.class.getName()));
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
			getCompanyId(), FileCorrReceipt.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileCorrReceipt toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FileCorrReceipt>
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
		FileCorrReceiptImpl fileCorrReceiptImpl = new FileCorrReceiptImpl();

		fileCorrReceiptImpl.setUuid(getUuid());
		fileCorrReceiptImpl.setFileCorrReceiptId(getFileCorrReceiptId());
		fileCorrReceiptImpl.setGroupId(getGroupId());
		fileCorrReceiptImpl.setCompanyId(getCompanyId());
		fileCorrReceiptImpl.setUserId(getUserId());
		fileCorrReceiptImpl.setCreateDate(getCreateDate());
		fileCorrReceiptImpl.setModifiedDate(getModifiedDate());
		fileCorrReceiptImpl.setDocFileId(getDocFileId());
		fileCorrReceiptImpl.setReceiptId(getReceiptId());
		fileCorrReceiptImpl.setUserPostId(getUserPostId());
		fileCorrReceiptImpl.setReceiptMovementId(getReceiptMovementId());
		fileCorrReceiptImpl.setCorrespondenceType(getCorrespondenceType());
		fileCorrReceiptImpl.setRemarks(getRemarks());
		fileCorrReceiptImpl.setFileMovementId(getFileMovementId());
		fileCorrReceiptImpl.setDetachRemark(getDetachRemark());
		fileCorrReceiptImpl.setDetachBy(getDetachBy());
		fileCorrReceiptImpl.setDetachOn(getDetachOn());

		fileCorrReceiptImpl.resetOriginalValues();

		return fileCorrReceiptImpl;
	}

	@Override
	public FileCorrReceipt cloneWithOriginalValues() {
		FileCorrReceiptImpl fileCorrReceiptImpl = new FileCorrReceiptImpl();

		fileCorrReceiptImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		fileCorrReceiptImpl.setFileCorrReceiptId(
			this.<Long>getColumnOriginalValue("fileCorrReceiptId"));
		fileCorrReceiptImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		fileCorrReceiptImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		fileCorrReceiptImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		fileCorrReceiptImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		fileCorrReceiptImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		fileCorrReceiptImpl.setDocFileId(
			this.<Long>getColumnOriginalValue("docFileId"));
		fileCorrReceiptImpl.setReceiptId(
			this.<Long>getColumnOriginalValue("receiptId"));
		fileCorrReceiptImpl.setUserPostId(
			this.<Long>getColumnOriginalValue("userPostId"));
		fileCorrReceiptImpl.setReceiptMovementId(
			this.<Long>getColumnOriginalValue("receiptMovementId"));
		fileCorrReceiptImpl.setCorrespondenceType(
			this.<String>getColumnOriginalValue("correspondenceType"));
		fileCorrReceiptImpl.setRemarks(
			this.<String>getColumnOriginalValue("remarks"));
		fileCorrReceiptImpl.setFileMovementId(
			this.<Long>getColumnOriginalValue("fileMovementId"));
		fileCorrReceiptImpl.setDetachRemark(
			this.<String>getColumnOriginalValue("detachRemark"));
		fileCorrReceiptImpl.setDetachBy(
			this.<Long>getColumnOriginalValue("detachBy"));
		fileCorrReceiptImpl.setDetachOn(
			this.<Date>getColumnOriginalValue("detachOn"));

		return fileCorrReceiptImpl;
	}

	@Override
	public int compareTo(FileCorrReceipt fileCorrReceipt) {
		long primaryKey = fileCorrReceipt.getPrimaryKey();

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

		if (!(object instanceof FileCorrReceipt)) {
			return false;
		}

		FileCorrReceipt fileCorrReceipt = (FileCorrReceipt)object;

		long primaryKey = fileCorrReceipt.getPrimaryKey();

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
	public CacheModel<FileCorrReceipt> toCacheModel() {
		FileCorrReceiptCacheModel fileCorrReceiptCacheModel =
			new FileCorrReceiptCacheModel();

		fileCorrReceiptCacheModel.uuid = getUuid();

		String uuid = fileCorrReceiptCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fileCorrReceiptCacheModel.uuid = null;
		}

		fileCorrReceiptCacheModel.fileCorrReceiptId = getFileCorrReceiptId();

		fileCorrReceiptCacheModel.groupId = getGroupId();

		fileCorrReceiptCacheModel.companyId = getCompanyId();

		fileCorrReceiptCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			fileCorrReceiptCacheModel.createDate = createDate.getTime();
		}
		else {
			fileCorrReceiptCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fileCorrReceiptCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fileCorrReceiptCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fileCorrReceiptCacheModel.docFileId = getDocFileId();

		fileCorrReceiptCacheModel.receiptId = getReceiptId();

		fileCorrReceiptCacheModel.userPostId = getUserPostId();

		fileCorrReceiptCacheModel.receiptMovementId = getReceiptMovementId();

		fileCorrReceiptCacheModel.correspondenceType = getCorrespondenceType();

		String correspondenceType =
			fileCorrReceiptCacheModel.correspondenceType;

		if ((correspondenceType != null) &&
			(correspondenceType.length() == 0)) {

			fileCorrReceiptCacheModel.correspondenceType = null;
		}

		fileCorrReceiptCacheModel.remarks = getRemarks();

		String remarks = fileCorrReceiptCacheModel.remarks;

		if ((remarks != null) && (remarks.length() == 0)) {
			fileCorrReceiptCacheModel.remarks = null;
		}

		fileCorrReceiptCacheModel.fileMovementId = getFileMovementId();

		fileCorrReceiptCacheModel.detachRemark = getDetachRemark();

		String detachRemark = fileCorrReceiptCacheModel.detachRemark;

		if ((detachRemark != null) && (detachRemark.length() == 0)) {
			fileCorrReceiptCacheModel.detachRemark = null;
		}

		fileCorrReceiptCacheModel.detachBy = getDetachBy();

		Date detachOn = getDetachOn();

		if (detachOn != null) {
			fileCorrReceiptCacheModel.detachOn = detachOn.getTime();
		}
		else {
			fileCorrReceiptCacheModel.detachOn = Long.MIN_VALUE;
		}

		return fileCorrReceiptCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FileCorrReceipt, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FileCorrReceipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCorrReceipt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((FileCorrReceipt)this);

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
		Map<String, Function<FileCorrReceipt, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FileCorrReceipt, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileCorrReceipt, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FileCorrReceipt)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FileCorrReceipt>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					FileCorrReceipt.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _fileCorrReceiptId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _docFileId;
	private long _receiptId;
	private long _userPostId;
	private long _receiptMovementId;
	private String _correspondenceType;
	private String _remarks;
	private long _fileMovementId;
	private String _detachRemark;
	private long _detachBy;
	private Date _detachOn;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FileCorrReceipt, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FileCorrReceipt)this);
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
		_columnOriginalValues.put("fileCorrReceiptId", _fileCorrReceiptId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("docFileId", _docFileId);
		_columnOriginalValues.put("receiptId", _receiptId);
		_columnOriginalValues.put("userPostId", _userPostId);
		_columnOriginalValues.put("receiptMovementId", _receiptMovementId);
		_columnOriginalValues.put("correspondenceType", _correspondenceType);
		_columnOriginalValues.put("remarks", _remarks);
		_columnOriginalValues.put("fileMovementId", _fileMovementId);
		_columnOriginalValues.put("detachRemark", _detachRemark);
		_columnOriginalValues.put("detachBy", _detachBy);
		_columnOriginalValues.put("detachOn", _detachOn);
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

		columnBitmasks.put("fileCorrReceiptId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("docFileId", 128L);

		columnBitmasks.put("receiptId", 256L);

		columnBitmasks.put("userPostId", 512L);

		columnBitmasks.put("receiptMovementId", 1024L);

		columnBitmasks.put("correspondenceType", 2048L);

		columnBitmasks.put("remarks", 4096L);

		columnBitmasks.put("fileMovementId", 8192L);

		columnBitmasks.put("detachRemark", 16384L);

		columnBitmasks.put("detachBy", 32768L);

		columnBitmasks.put("detachOn", 65536L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FileCorrReceipt _escapedModel;

}