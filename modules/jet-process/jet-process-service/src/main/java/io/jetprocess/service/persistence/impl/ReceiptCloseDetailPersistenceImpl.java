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

package io.jetprocess.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import io.jetprocess.exception.NoSuchReceiptCloseDetailException;
import io.jetprocess.model.ReceiptCloseDetail;
import io.jetprocess.model.ReceiptCloseDetailTable;
import io.jetprocess.model.impl.ReceiptCloseDetailImpl;
import io.jetprocess.model.impl.ReceiptCloseDetailModelImpl;
import io.jetprocess.service.persistence.ReceiptCloseDetailPersistence;
import io.jetprocess.service.persistence.ReceiptCloseDetailUtil;
import io.jetprocess.service.persistence.impl.constants.JET_PROCESSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the receipt close detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ReceiptCloseDetailPersistence.class, BasePersistence.class}
)
public class ReceiptCloseDetailPersistenceImpl
	extends BasePersistenceImpl<ReceiptCloseDetail>
	implements ReceiptCloseDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ReceiptCloseDetailUtil</code> to access the receipt close detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ReceiptCloseDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ReceiptCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<ReceiptCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ReceiptCloseDetail receiptCloseDetail : list) {
					if (!uuid.equals(receiptCloseDetail.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReceiptCloseDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ReceiptCloseDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail findByUuid_First(
			String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByUuid_First(
			uuid, orderByComparator);

		if (receiptCloseDetail != null) {
			return receiptCloseDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchReceiptCloseDetailException(sb.toString());
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUuid_First(
		String uuid, OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		List<ReceiptCloseDetail> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail findByUuid_Last(
			String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByUuid_Last(
			uuid, orderByComparator);

		if (receiptCloseDetail != null) {
			return receiptCloseDetail;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchReceiptCloseDetailException(sb.toString());
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUuid_Last(
		String uuid, OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ReceiptCloseDetail> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the receipt close details before and after the current receipt close detail in the ordered set where uuid = &#63;.
	 *
	 * @param ReceiptClosedId the primary key of the current receipt close detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail[] findByUuid_PrevAndNext(
			long ReceiptClosedId, String uuid,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		uuid = Objects.toString(uuid, "");

		ReceiptCloseDetail receiptCloseDetail = findByPrimaryKey(
			ReceiptClosedId);

		Session session = null;

		try {
			session = openSession();

			ReceiptCloseDetail[] array = new ReceiptCloseDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, receiptCloseDetail, uuid, orderByComparator, true);

			array[1] = receiptCloseDetail;

			array[2] = getByUuid_PrevAndNext(
				session, receiptCloseDetail, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReceiptCloseDetail getByUuid_PrevAndNext(
		Session session, ReceiptCloseDetail receiptCloseDetail, String uuid,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ReceiptCloseDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						receiptCloseDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReceiptCloseDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receipt close details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ReceiptCloseDetail receiptCloseDetail :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(receiptCloseDetail);
		}
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching receipt close details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"receiptCloseDetail.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(receiptCloseDetail.uuid IS NULL OR receiptCloseDetail.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByUUID_G(uuid, groupId);

		if (receiptCloseDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchReceiptCloseDetailException(sb.toString());
		}

		return receiptCloseDetail;
	}

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the receipt close detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof ReceiptCloseDetail) {
			ReceiptCloseDetail receiptCloseDetail = (ReceiptCloseDetail)result;

			if (!Objects.equals(uuid, receiptCloseDetail.getUuid()) ||
				(groupId != receiptCloseDetail.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ReceiptCloseDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ReceiptCloseDetail receiptCloseDetail = list.get(0);

					result = receiptCloseDetail;

					cacheResult(receiptCloseDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ReceiptCloseDetail)result;
		}
	}

	/**
	 * Removes the receipt close detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the receipt close detail that was removed
	 */
	@Override
	public ReceiptCloseDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = findByUUID_G(uuid, groupId);

		return remove(receiptCloseDetail);
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching receipt close details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"receiptCloseDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(receiptCloseDetail.uuid IS NULL OR receiptCloseDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"receiptCloseDetail.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ReceiptCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<ReceiptCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ReceiptCloseDetail receiptCloseDetail : list) {
					if (!uuid.equals(receiptCloseDetail.getUuid()) ||
						(companyId != receiptCloseDetail.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ReceiptCloseDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ReceiptCloseDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (receiptCloseDetail != null) {
			return receiptCloseDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchReceiptCloseDetailException(sb.toString());
	}

	/**
	 * Returns the first receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		List<ReceiptCloseDetail> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (receiptCloseDetail != null) {
			return receiptCloseDetail;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchReceiptCloseDetailException(sb.toString());
	}

	/**
	 * Returns the last receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching receipt close detail, or <code>null</code> if a matching receipt close detail could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ReceiptCloseDetail> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the receipt close details before and after the current receipt close detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ReceiptClosedId the primary key of the current receipt close detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail[] findByUuid_C_PrevAndNext(
			long ReceiptClosedId, String uuid, long companyId,
			OrderByComparator<ReceiptCloseDetail> orderByComparator)
		throws NoSuchReceiptCloseDetailException {

		uuid = Objects.toString(uuid, "");

		ReceiptCloseDetail receiptCloseDetail = findByPrimaryKey(
			ReceiptClosedId);

		Session session = null;

		try {
			session = openSession();

			ReceiptCloseDetail[] array = new ReceiptCloseDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, receiptCloseDetail, uuid, companyId, orderByComparator,
				true);

			array[1] = receiptCloseDetail;

			array[2] = getByUuid_C_PrevAndNext(
				session, receiptCloseDetail, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReceiptCloseDetail getByUuid_C_PrevAndNext(
		Session session, ReceiptCloseDetail receiptCloseDetail, String uuid,
		long companyId, OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ReceiptCloseDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						receiptCloseDetail)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ReceiptCloseDetail> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the receipt close details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ReceiptCloseDetail receiptCloseDetail :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(receiptCloseDetail);
		}
	}

	/**
	 * Returns the number of receipt close details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching receipt close details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECEIPTCLOSEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"receiptCloseDetail.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(receiptCloseDetail.uuid IS NULL OR receiptCloseDetail.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"receiptCloseDetail.companyId = ?";

	public ReceiptCloseDetailPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ReceiptCloseDetail.class);

		setModelImplClass(ReceiptCloseDetailImpl.class);
		setModelPKClass(long.class);

		setTable(ReceiptCloseDetailTable.INSTANCE);
	}

	/**
	 * Caches the receipt close detail in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetail the receipt close detail
	 */
	@Override
	public void cacheResult(ReceiptCloseDetail receiptCloseDetail) {
		entityCache.putResult(
			ReceiptCloseDetailImpl.class, receiptCloseDetail.getPrimaryKey(),
			receiptCloseDetail);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				receiptCloseDetail.getUuid(), receiptCloseDetail.getGroupId()
			},
			receiptCloseDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the receipt close details in the entity cache if it is enabled.
	 *
	 * @param receiptCloseDetails the receipt close details
	 */
	@Override
	public void cacheResult(List<ReceiptCloseDetail> receiptCloseDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (receiptCloseDetails.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ReceiptCloseDetail receiptCloseDetail : receiptCloseDetails) {
			if (entityCache.getResult(
					ReceiptCloseDetailImpl.class,
					receiptCloseDetail.getPrimaryKey()) == null) {

				cacheResult(receiptCloseDetail);
			}
		}
	}

	/**
	 * Clears the cache for all receipt close details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ReceiptCloseDetailImpl.class);

		finderCache.clearCache(ReceiptCloseDetailImpl.class);
	}

	/**
	 * Clears the cache for the receipt close detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReceiptCloseDetail receiptCloseDetail) {
		entityCache.removeResult(
			ReceiptCloseDetailImpl.class, receiptCloseDetail);
	}

	@Override
	public void clearCache(List<ReceiptCloseDetail> receiptCloseDetails) {
		for (ReceiptCloseDetail receiptCloseDetail : receiptCloseDetails) {
			entityCache.removeResult(
				ReceiptCloseDetailImpl.class, receiptCloseDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ReceiptCloseDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ReceiptCloseDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ReceiptCloseDetailModelImpl receiptCloseDetailModelImpl) {

		Object[] args = new Object[] {
			receiptCloseDetailModelImpl.getUuid(),
			receiptCloseDetailModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, receiptCloseDetailModelImpl);
	}

	/**
	 * Creates a new receipt close detail with the primary key. Does not add the receipt close detail to the database.
	 *
	 * @param ReceiptClosedId the primary key for the new receipt close detail
	 * @return the new receipt close detail
	 */
	@Override
	public ReceiptCloseDetail create(long ReceiptClosedId) {
		ReceiptCloseDetail receiptCloseDetail = new ReceiptCloseDetailImpl();

		receiptCloseDetail.setNew(true);
		receiptCloseDetail.setPrimaryKey(ReceiptClosedId);

		String uuid = _portalUUID.generate();

		receiptCloseDetail.setUuid(uuid);

		receiptCloseDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return receiptCloseDetail;
	}

	/**
	 * Removes the receipt close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail that was removed
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail remove(long ReceiptClosedId)
		throws NoSuchReceiptCloseDetailException {

		return remove((Serializable)ReceiptClosedId);
	}

	/**
	 * Removes the receipt close detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the receipt close detail
	 * @return the receipt close detail that was removed
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail remove(Serializable primaryKey)
		throws NoSuchReceiptCloseDetailException {

		Session session = null;

		try {
			session = openSession();

			ReceiptCloseDetail receiptCloseDetail =
				(ReceiptCloseDetail)session.get(
					ReceiptCloseDetailImpl.class, primaryKey);

			if (receiptCloseDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReceiptCloseDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(receiptCloseDetail);
		}
		catch (NoSuchReceiptCloseDetailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ReceiptCloseDetail removeImpl(
		ReceiptCloseDetail receiptCloseDetail) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(receiptCloseDetail)) {
				receiptCloseDetail = (ReceiptCloseDetail)session.get(
					ReceiptCloseDetailImpl.class,
					receiptCloseDetail.getPrimaryKeyObj());
			}

			if (receiptCloseDetail != null) {
				session.delete(receiptCloseDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (receiptCloseDetail != null) {
			clearCache(receiptCloseDetail);
		}

		return receiptCloseDetail;
	}

	@Override
	public ReceiptCloseDetail updateImpl(
		ReceiptCloseDetail receiptCloseDetail) {

		boolean isNew = receiptCloseDetail.isNew();

		if (!(receiptCloseDetail instanceof ReceiptCloseDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(receiptCloseDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					receiptCloseDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in receiptCloseDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ReceiptCloseDetail implementation " +
					receiptCloseDetail.getClass());
		}

		ReceiptCloseDetailModelImpl receiptCloseDetailModelImpl =
			(ReceiptCloseDetailModelImpl)receiptCloseDetail;

		if (Validator.isNull(receiptCloseDetail.getUuid())) {
			String uuid = _portalUUID.generate();

			receiptCloseDetail.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (receiptCloseDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				receiptCloseDetail.setCreateDate(date);
			}
			else {
				receiptCloseDetail.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!receiptCloseDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				receiptCloseDetail.setModifiedDate(date);
			}
			else {
				receiptCloseDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(receiptCloseDetail);
			}
			else {
				receiptCloseDetail = (ReceiptCloseDetail)session.merge(
					receiptCloseDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ReceiptCloseDetailImpl.class, receiptCloseDetailModelImpl, false,
			true);

		cacheUniqueFindersCache(receiptCloseDetailModelImpl);

		if (isNew) {
			receiptCloseDetail.setNew(false);
		}

		receiptCloseDetail.resetOriginalValues();

		return receiptCloseDetail;
	}

	/**
	 * Returns the receipt close detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReceiptCloseDetailException {

		ReceiptCloseDetail receiptCloseDetail = fetchByPrimaryKey(primaryKey);

		if (receiptCloseDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReceiptCloseDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return receiptCloseDetail;
	}

	/**
	 * Returns the receipt close detail with the primary key or throws a <code>NoSuchReceiptCloseDetailException</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail
	 * @throws NoSuchReceiptCloseDetailException if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail findByPrimaryKey(long ReceiptClosedId)
		throws NoSuchReceiptCloseDetailException {

		return findByPrimaryKey((Serializable)ReceiptClosedId);
	}

	/**
	 * Returns the receipt close detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ReceiptClosedId the primary key of the receipt close detail
	 * @return the receipt close detail, or <code>null</code> if a receipt close detail with the primary key could not be found
	 */
	@Override
	public ReceiptCloseDetail fetchByPrimaryKey(long ReceiptClosedId) {
		return fetchByPrimaryKey((Serializable)ReceiptClosedId);
	}

	/**
	 * Returns all the receipt close details.
	 *
	 * @return the receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @return the range of receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findAll(
		int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the receipt close details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReceiptCloseDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of receipt close details
	 * @param end the upper bound of the range of receipt close details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of receipt close details
	 */
	@Override
	public List<ReceiptCloseDetail> findAll(
		int start, int end,
		OrderByComparator<ReceiptCloseDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ReceiptCloseDetail> list = null;

		if (useFinderCache) {
			list = (List<ReceiptCloseDetail>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RECEIPTCLOSEDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RECEIPTCLOSEDETAIL;

				sql = sql.concat(ReceiptCloseDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ReceiptCloseDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the receipt close details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ReceiptCloseDetail receiptCloseDetail : findAll()) {
			remove(receiptCloseDetail);
		}
	}

	/**
	 * Returns the number of receipt close details.
	 *
	 * @return the number of receipt close details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_RECEIPTCLOSEDETAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ReceiptClosedId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RECEIPTCLOSEDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ReceiptCloseDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the receipt close detail persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setReceiptCloseDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setReceiptCloseDetailUtilPersistence(null);

		entityCache.removeCache(ReceiptCloseDetailImpl.class.getName());
	}

	private void _setReceiptCloseDetailUtilPersistence(
		ReceiptCloseDetailPersistence receiptCloseDetailPersistence) {

		try {
			Field field = ReceiptCloseDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, receiptCloseDetailPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = JET_PROCESSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_RECEIPTCLOSEDETAIL =
		"SELECT receiptCloseDetail FROM ReceiptCloseDetail receiptCloseDetail";

	private static final String _SQL_SELECT_RECEIPTCLOSEDETAIL_WHERE =
		"SELECT receiptCloseDetail FROM ReceiptCloseDetail receiptCloseDetail WHERE ";

	private static final String _SQL_COUNT_RECEIPTCLOSEDETAIL =
		"SELECT COUNT(receiptCloseDetail) FROM ReceiptCloseDetail receiptCloseDetail";

	private static final String _SQL_COUNT_RECEIPTCLOSEDETAIL_WHERE =
		"SELECT COUNT(receiptCloseDetail) FROM ReceiptCloseDetail receiptCloseDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "receiptCloseDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ReceiptCloseDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ReceiptCloseDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ReceiptCloseDetailPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private ReceiptCloseDetailModelArgumentsResolver
		_receiptCloseDetailModelArgumentsResolver;

}