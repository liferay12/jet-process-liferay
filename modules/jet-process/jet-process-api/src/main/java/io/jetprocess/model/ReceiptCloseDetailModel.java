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

package io.jetprocess.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ReceiptCloseDetail service. Represents a row in the &quot;JET_PROCESS_ReceiptCloseDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>io.jetprocess.model.impl.ReceiptCloseDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>io.jetprocess.model.impl.ReceiptCloseDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReceiptCloseDetail
 * @generated
 */
@ProviderType
public interface ReceiptCloseDetailModel
	extends BaseModel<ReceiptCloseDetail>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a receipt close detail model instance should use the {@link ReceiptCloseDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this receipt close detail.
	 *
	 * @return the primary key of this receipt close detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this receipt close detail.
	 *
	 * @param primaryKey the primary key of this receipt close detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this receipt close detail.
	 *
	 * @return the uuid of this receipt close detail
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this receipt close detail.
	 *
	 * @param uuid the uuid of this receipt close detail
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the receipt closed ID of this receipt close detail.
	 *
	 * @return the receipt closed ID of this receipt close detail
	 */
	public long getReceiptClosedId();

	/**
	 * Sets the receipt closed ID of this receipt close detail.
	 *
	 * @param ReceiptClosedId the receipt closed ID of this receipt close detail
	 */
	public void setReceiptClosedId(long ReceiptClosedId);

	/**
	 * Returns the group ID of this receipt close detail.
	 *
	 * @return the group ID of this receipt close detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this receipt close detail.
	 *
	 * @param groupId the group ID of this receipt close detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this receipt close detail.
	 *
	 * @return the company ID of this receipt close detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this receipt close detail.
	 *
	 * @param companyId the company ID of this receipt close detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this receipt close detail.
	 *
	 * @return the user ID of this receipt close detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this receipt close detail.
	 *
	 * @param userId the user ID of this receipt close detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this receipt close detail.
	 *
	 * @return the user uuid of this receipt close detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this receipt close detail.
	 *
	 * @param userUuid the user uuid of this receipt close detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this receipt close detail.
	 *
	 * @return the user name of this receipt close detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this receipt close detail.
	 *
	 * @param userName the user name of this receipt close detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this receipt close detail.
	 *
	 * @return the create date of this receipt close detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this receipt close detail.
	 *
	 * @param createDate the create date of this receipt close detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this receipt close detail.
	 *
	 * @return the modified date of this receipt close detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this receipt close detail.
	 *
	 * @param modifiedDate the modified date of this receipt close detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the receipt ID of this receipt close detail.
	 *
	 * @return the receipt ID of this receipt close detail
	 */
	public long getReceiptId();

	/**
	 * Sets the receipt ID of this receipt close detail.
	 *
	 * @param receiptId the receipt ID of this receipt close detail
	 */
	public void setReceiptId(long receiptId);

	/**
	 * Returns the closed by of this receipt close detail.
	 *
	 * @return the closed by of this receipt close detail
	 */
	public long getClosedBy();

	/**
	 * Sets the closed by of this receipt close detail.
	 *
	 * @param closedBy the closed by of this receipt close detail
	 */
	public void setClosedBy(long closedBy);

	/**
	 * Returns the closing remarks of this receipt close detail.
	 *
	 * @return the closing remarks of this receipt close detail
	 */
	@AutoEscape
	public String getClosingRemarks();

	/**
	 * Sets the closing remarks of this receipt close detail.
	 *
	 * @param closingRemarks the closing remarks of this receipt close detail
	 */
	public void setClosingRemarks(String closingRemarks);

	/**
	 * Returns the reopen date of this receipt close detail.
	 *
	 * @return the reopen date of this receipt close detail
	 */
	public Date getReopenDate();

	/**
	 * Sets the reopen date of this receipt close detail.
	 *
	 * @param reopenDate the reopen date of this receipt close detail
	 */
	public void setReopenDate(Date reopenDate);

	/**
	 * Returns the reopen remarks of this receipt close detail.
	 *
	 * @return the reopen remarks of this receipt close detail
	 */
	@AutoEscape
	public String getReopenRemarks();

	/**
	 * Sets the reopen remarks of this receipt close detail.
	 *
	 * @param reopenRemarks the reopen remarks of this receipt close detail
	 */
	public void setReopenRemarks(String reopenRemarks);

	/**
	 * Returns the closed movement ID of this receipt close detail.
	 *
	 * @return the closed movement ID of this receipt close detail
	 */
	public long getClosedMovementId();

	/**
	 * Sets the closed movement ID of this receipt close detail.
	 *
	 * @param closedMovementId the closed movement ID of this receipt close detail
	 */
	public void setClosedMovementId(long closedMovementId);

	/**
	 * Returns the reopen movement ID of this receipt close detail.
	 *
	 * @return the reopen movement ID of this receipt close detail
	 */
	public long getReopenMovementId();

	/**
	 * Sets the reopen movement ID of this receipt close detail.
	 *
	 * @param reopenMovementId the reopen movement ID of this receipt close detail
	 */
	public void setReopenMovementId(long reopenMovementId);

	/**
	 * Returns the reopen by of this receipt close detail.
	 *
	 * @return the reopen by of this receipt close detail
	 */
	public long getReopenBy();

	/**
	 * Sets the reopen by of this receipt close detail.
	 *
	 * @param reopenBy the reopen by of this receipt close detail
	 */
	public void setReopenBy(long reopenBy);

	@Override
	public ReceiptCloseDetail cloneWithOriginalValues();

}