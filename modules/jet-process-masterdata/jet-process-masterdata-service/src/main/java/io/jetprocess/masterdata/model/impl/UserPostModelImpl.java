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

package io.jetprocess.masterdata.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.model.UserPostModel;

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
 * The base model implementation for the UserPost service. Represents a row in the &quot;Masterdata_UserPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserPostModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserPostImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPostImpl
 * @generated
 */
@JSON(strict = true)
public class UserPostModelImpl
	extends BaseModelImpl<UserPost> implements UserPostModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user post model instance should use the <code>UserPost</code> interface instead.
	 */
	public static final String TABLE_NAME = "Masterdata_UserPost";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"userPostId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"postId", Types.BIGINT},
		{"sectionId", Types.BIGINT}, {"description", Types.VARCHAR},
		{"userName", Types.VARCHAR}, {"shortName", Types.VARCHAR},
		{"userId", Types.BIGINT}, {"postName", Types.VARCHAR},
		{"sectionName", Types.VARCHAR}, {"departmentName", Types.VARCHAR},
		{"departmentId", Types.BIGINT}, {"postMarking", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userPostId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("postId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("postName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sectionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("postMarking", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Masterdata_UserPost (uuid_ VARCHAR(75) null,userPostId LONG not null primary key,groupId LONG,postId LONG,sectionId LONG,description VARCHAR(75) null,userName VARCHAR(75) null,shortName VARCHAR(75) null,userId LONG,postName VARCHAR(75) null,sectionName VARCHAR(75) null,departmentName VARCHAR(75) null,departmentId LONG,postMarking VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Masterdata_UserPost";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userPost.userPostId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Masterdata_UserPost.userPostId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 2L;

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
	public static final long USERPOSTID_COLUMN_BITMASK = 8L;

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

	public UserPostModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userPostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserPostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userPostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserPost.class;
	}

	@Override
	public String getModelClassName() {
		return UserPost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserPost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserPost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPost, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((UserPost)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserPost, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserPost, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserPost)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserPost, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserPost, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<UserPost, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserPost, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserPost, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserPost, Object>>();
		Map<String, BiConsumer<UserPost, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserPost, ?>>();

		attributeGetterFunctions.put("uuid", UserPost::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<UserPost, String>)UserPost::setUuid);
		attributeGetterFunctions.put("userPostId", UserPost::getUserPostId);
		attributeSetterBiConsumers.put(
			"userPostId", (BiConsumer<UserPost, Long>)UserPost::setUserPostId);
		attributeGetterFunctions.put("groupId", UserPost::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<UserPost, Long>)UserPost::setGroupId);
		attributeGetterFunctions.put("postId", UserPost::getPostId);
		attributeSetterBiConsumers.put(
			"postId", (BiConsumer<UserPost, Long>)UserPost::setPostId);
		attributeGetterFunctions.put("sectionId", UserPost::getSectionId);
		attributeSetterBiConsumers.put(
			"sectionId", (BiConsumer<UserPost, Long>)UserPost::setSectionId);
		attributeGetterFunctions.put("description", UserPost::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<UserPost, String>)UserPost::setDescription);
		attributeGetterFunctions.put("userName", UserPost::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<UserPost, String>)UserPost::setUserName);
		attributeGetterFunctions.put("shortName", UserPost::getShortName);
		attributeSetterBiConsumers.put(
			"shortName", (BiConsumer<UserPost, String>)UserPost::setShortName);
		attributeGetterFunctions.put("userId", UserPost::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<UserPost, Long>)UserPost::setUserId);
		attributeGetterFunctions.put("postName", UserPost::getPostName);
		attributeSetterBiConsumers.put(
			"postName", (BiConsumer<UserPost, String>)UserPost::setPostName);
		attributeGetterFunctions.put("sectionName", UserPost::getSectionName);
		attributeSetterBiConsumers.put(
			"sectionName",
			(BiConsumer<UserPost, String>)UserPost::setSectionName);
		attributeGetterFunctions.put(
			"departmentName", UserPost::getDepartmentName);
		attributeSetterBiConsumers.put(
			"departmentName",
			(BiConsumer<UserPost, String>)UserPost::setDepartmentName);
		attributeGetterFunctions.put("departmentId", UserPost::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<UserPost, Long>)UserPost::setDepartmentId);
		attributeGetterFunctions.put("postMarking", UserPost::getPostMarking);
		attributeSetterBiConsumers.put(
			"postMarking",
			(BiConsumer<UserPost, String>)UserPost::setPostMarking);

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
	public long getPostId() {
		return _postId;
	}

	@Override
	public void setPostId(long postId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postId = postId;
	}

	@JSON
	@Override
	public long getSectionId() {
		return _sectionId;
	}

	@Override
	public void setSectionId(long sectionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sectionId = sectionId;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
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
	public String getShortName() {
		if (_shortName == null) {
			return "";
		}
		else {
			return _shortName;
		}
	}

	@Override
	public void setShortName(String shortName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_shortName = shortName;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getPostName() {
		if (_postName == null) {
			return "";
		}
		else {
			return _postName;
		}
	}

	@Override
	public void setPostName(String postName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postName = postName;
	}

	@JSON
	@Override
	public String getSectionName() {
		if (_sectionName == null) {
			return "";
		}
		else {
			return _sectionName;
		}
	}

	@Override
	public void setSectionName(String sectionName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sectionName = sectionName;
	}

	@JSON
	@Override
	public String getDepartmentName() {
		if (_departmentName == null) {
			return "";
		}
		else {
			return _departmentName;
		}
	}

	@Override
	public void setDepartmentName(String departmentName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentName = departmentName;
	}

	@JSON
	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	@JSON
	@Override
	public String getPostMarking() {
		if (_postMarking == null) {
			return "";
		}
		else {
			return _postMarking;
		}
	}

	@Override
	public void setPostMarking(String postMarking) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_postMarking = postMarking;
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
			0, UserPost.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserPost toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserPost>
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
		UserPostImpl userPostImpl = new UserPostImpl();

		userPostImpl.setUuid(getUuid());
		userPostImpl.setUserPostId(getUserPostId());
		userPostImpl.setGroupId(getGroupId());
		userPostImpl.setPostId(getPostId());
		userPostImpl.setSectionId(getSectionId());
		userPostImpl.setDescription(getDescription());
		userPostImpl.setUserName(getUserName());
		userPostImpl.setShortName(getShortName());
		userPostImpl.setUserId(getUserId());
		userPostImpl.setPostName(getPostName());
		userPostImpl.setSectionName(getSectionName());
		userPostImpl.setDepartmentName(getDepartmentName());
		userPostImpl.setDepartmentId(getDepartmentId());
		userPostImpl.setPostMarking(getPostMarking());

		userPostImpl.resetOriginalValues();

		return userPostImpl;
	}

	@Override
	public UserPost cloneWithOriginalValues() {
		UserPostImpl userPostImpl = new UserPostImpl();

		userPostImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		userPostImpl.setUserPostId(
			this.<Long>getColumnOriginalValue("userPostId"));
		userPostImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		userPostImpl.setPostId(this.<Long>getColumnOriginalValue("postId"));
		userPostImpl.setSectionId(
			this.<Long>getColumnOriginalValue("sectionId"));
		userPostImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		userPostImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		userPostImpl.setShortName(
			this.<String>getColumnOriginalValue("shortName"));
		userPostImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		userPostImpl.setPostName(
			this.<String>getColumnOriginalValue("postName"));
		userPostImpl.setSectionName(
			this.<String>getColumnOriginalValue("sectionName"));
		userPostImpl.setDepartmentName(
			this.<String>getColumnOriginalValue("departmentName"));
		userPostImpl.setDepartmentId(
			this.<Long>getColumnOriginalValue("departmentId"));
		userPostImpl.setPostMarking(
			this.<String>getColumnOriginalValue("postMarking"));

		return userPostImpl;
	}

	@Override
	public int compareTo(UserPost userPost) {
		long primaryKey = userPost.getPrimaryKey();

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

		if (!(object instanceof UserPost)) {
			return false;
		}

		UserPost userPost = (UserPost)object;

		long primaryKey = userPost.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<UserPost> toCacheModel() {
		UserPostCacheModel userPostCacheModel = new UserPostCacheModel();

		userPostCacheModel.uuid = getUuid();

		String uuid = userPostCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userPostCacheModel.uuid = null;
		}

		userPostCacheModel.userPostId = getUserPostId();

		userPostCacheModel.groupId = getGroupId();

		userPostCacheModel.postId = getPostId();

		userPostCacheModel.sectionId = getSectionId();

		userPostCacheModel.description = getDescription();

		String description = userPostCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			userPostCacheModel.description = null;
		}

		userPostCacheModel.userName = getUserName();

		String userName = userPostCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			userPostCacheModel.userName = null;
		}

		userPostCacheModel.shortName = getShortName();

		String shortName = userPostCacheModel.shortName;

		if ((shortName != null) && (shortName.length() == 0)) {
			userPostCacheModel.shortName = null;
		}

		userPostCacheModel.userId = getUserId();

		userPostCacheModel.postName = getPostName();

		String postName = userPostCacheModel.postName;

		if ((postName != null) && (postName.length() == 0)) {
			userPostCacheModel.postName = null;
		}

		userPostCacheModel.sectionName = getSectionName();

		String sectionName = userPostCacheModel.sectionName;

		if ((sectionName != null) && (sectionName.length() == 0)) {
			userPostCacheModel.sectionName = null;
		}

		userPostCacheModel.departmentName = getDepartmentName();

		String departmentName = userPostCacheModel.departmentName;

		if ((departmentName != null) && (departmentName.length() == 0)) {
			userPostCacheModel.departmentName = null;
		}

		userPostCacheModel.departmentId = getDepartmentId();

		userPostCacheModel.postMarking = getPostMarking();

		String postMarking = userPostCacheModel.postMarking;

		if ((postMarking != null) && (postMarking.length() == 0)) {
			userPostCacheModel.postMarking = null;
		}

		return userPostCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserPost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserPost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPost, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((UserPost)this);

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
		Map<String, Function<UserPost, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserPost, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserPost, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UserPost)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserPost>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					UserPost.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _userPostId;
	private long _groupId;
	private long _postId;
	private long _sectionId;
	private String _description;
	private String _userName;
	private String _shortName;
	private long _userId;
	private String _postName;
	private String _sectionName;
	private String _departmentName;
	private long _departmentId;
	private String _postMarking;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<UserPost, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UserPost)this);
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
		_columnOriginalValues.put("userPostId", _userPostId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("postId", _postId);
		_columnOriginalValues.put("sectionId", _sectionId);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("shortName", _shortName);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("postName", _postName);
		_columnOriginalValues.put("sectionName", _sectionName);
		_columnOriginalValues.put("departmentName", _departmentName);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("postMarking", _postMarking);
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

		columnBitmasks.put("userPostId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("postId", 8L);

		columnBitmasks.put("sectionId", 16L);

		columnBitmasks.put("description", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("shortName", 128L);

		columnBitmasks.put("userId", 256L);

		columnBitmasks.put("postName", 512L);

		columnBitmasks.put("sectionName", 1024L);

		columnBitmasks.put("departmentName", 2048L);

		columnBitmasks.put("departmentId", 4096L);

		columnBitmasks.put("postMarking", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UserPost _escapedModel;

}