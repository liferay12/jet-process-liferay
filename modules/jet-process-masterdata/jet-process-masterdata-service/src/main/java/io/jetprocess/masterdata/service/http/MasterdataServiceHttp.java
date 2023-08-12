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

package io.jetprocess.masterdata.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import io.jetprocess.masterdata.service.MasterdataServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>MasterdataServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MasterdataServiceHttp {

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCategoryMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCategoryMasterdata",
				_getCategoryMasterdataParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubCategoryMasterdata(HttpPrincipal httpPrincipal, long categoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubCategoryMasterdata",
				_getSubCategoryMasterdataParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTypeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTypeMasterdata",
				_getTypeMasterdataParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getDeliveryModeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getDeliveryModeMasterdata",
				_getDeliveryModeMasterdataParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getFileCodeMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileCodeMasterdata",
				_getFileCodeMasterdataParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getBasicHeadMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getBasicHeadMasterdata",
				_getBasicHeadMasterdataParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getPrimaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long basicHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getPrimaryHeadMasterdata",
				_getPrimaryHeadMasterdataParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, basicHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSecondaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long primaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSecondaryHeadMasterdata",
				_getSecondaryHeadMasterdataParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getTeritaryHeadMasterdata(
			HttpPrincipal httpPrincipal, long secondaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTeritaryHeadMasterdata",
				_getTeritaryHeadMasterdataParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, secondaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getOrganizationMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getOrganizationMasterdata",
				_getOrganizationMasterdataParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getSubOrganizationMasterdata(
			HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubOrganizationMasterdata",
				_getSubOrganizationMasterdataParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptCategoryMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptCategoryMasterdata",
				_getReceiptCategoryMasterdataParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getReceiptSubCategoryMasterdata(
			HttpPrincipal httpPrincipal, long receiptCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptSubCategoryMasterdata",
				_getReceiptSubCategoryMasterdataParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getCountriesMasterdata(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCountriesMasterdata",
				_getCountriesMasterdataParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.Masterdata>
		getStatesMasterdata(HttpPrincipal httpPrincipal, long countryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getStatesMasterdata",
				_getStatesMasterdataParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, countryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<io.jetprocess.masterdata.model.Masterdata>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getBasicHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long basicHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getBasicHeadByIdMasterdata",
				_getBasicHeadByIdMasterdataParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, basicHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getPrimaryHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long primaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getPrimaryHeadByIdMasterdata",
				_getPrimaryHeadByIdMasterdataParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, primaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSecondaryHeadByIdMasterdata(
			HttpPrincipal httpPrincipal, long secondaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSecondaryHeadByIdMasterdata",
				_getSecondaryHeadByIdMasterdataParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, secondaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getTertiaryByIdMasterdata(
			HttpPrincipal httpPrincipal, long tertiaryHeadId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTertiaryByIdMasterdata",
				_getTertiaryByIdMasterdataParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, tertiaryHeadId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getFileCodeValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long fileCodeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileCodeValueByIdMasterdata",
				_getFileCodeValueByIdMasterdataParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileCodeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getCategoryValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long categoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCategoryValueByIdMasterdata",
				_getCategoryValueByIdMasterdataParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSubCategoryValueByIdMasterdata(
			HttpPrincipal httpPrincipal, long subCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getSubCategoryValueByIdMasterdata",
				_getSubCategoryValueByIdMasterdataParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getTypeValueByIdMasterdata(HttpPrincipal httpPrincipal, long typeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getTypeValueByIdMasterdata",
				_getTypeValueByIdMasterdataParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(methodKey, typeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getDeliveryModeByIdMasterdata(
			HttpPrincipal httpPrincipal, long deliveryModeId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getDeliveryModeByIdMasterdata",
				_getDeliveryModeByIdMasterdataParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, deliveryModeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getOrganizationByIdMasterdata(
			HttpPrincipal httpPrincipal, long organizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getOrganizationByIdMasterdata",
				_getOrganizationByIdMasterdataParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, organizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getSubOrganizationByIdMasterdata(
			HttpPrincipal httpPrincipal, long subOrganizationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getSubOrganizationByIdMasterdata",
				_getSubOrganizationByIdMasterdataParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, subOrganizationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getCountryByIdMasterdata(HttpPrincipal httpPrincipal, long countryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getCountryByIdMasterdata",
				_getCountryByIdMasterdataParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, countryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getStateByIdMasterdata(HttpPrincipal httpPrincipal, long stateId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getStateByIdMasterdata",
				_getStateByIdMasterdataParameterTypes27);

			MethodHandler methodHandler = new MethodHandler(methodKey, stateId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getReceiptCategoryByIdMasterdata(
			HttpPrincipal httpPrincipal, long receiptCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptCategoryByIdMasterdata",
				_getReceiptCategoryByIdMasterdataParameterTypes28);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static io.jetprocess.masterdata.model.Masterdata
		getReceiptSubCategoryByIdMasterdata(
			HttpPrincipal httpPrincipal, long receiptSubCategoryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getReceiptSubCategoryByIdMasterdata",
				_getReceiptSubCategoryByIdMasterdataParameterTypes29);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptSubCategoryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (io.jetprocess.masterdata.model.Masterdata)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<io.jetprocess.masterdata.model.ReceiptMovementDTO>
			getReceiptMovementListByReceiptId(
				HttpPrincipal httpPrincipal, long receiptId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class,
				"getReceiptMovementListByReceiptId",
				_getReceiptMovementListByReceiptIdParameterTypes30);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, receiptId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.ReceiptMovementDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<io.jetprocess.masterdata.model.FileMovementDTO>
		getFileMovementListByFileId(HttpPrincipal httpPrincipal, long fileId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getFileMovementListByFileId",
				_getFileMovementListByFileIdParameterTypes31);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.FileMovementDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<io.jetprocess.masterdata.model.ReceiptMovementDTO> getReceiptSentList(
			HttpPrincipal httpPrincipal, long userPostId) {

		try {
			MethodKey methodKey = new MethodKey(
				MasterdataServiceUtil.class, "getReceiptSentList",
				_getReceiptSentListParameterTypes32);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userPostId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<io.jetprocess.masterdata.model.ReceiptMovementDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MasterdataServiceHttp.class);

	private static final Class<?>[] _getCategoryMasterdataParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getSubCategoryMasterdataParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getTypeMasterdataParameterTypes2 =
		new Class[] {};
	private static final Class<?>[] _getDeliveryModeMasterdataParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _getFileCodeMasterdataParameterTypes4 =
		new Class[] {};
	private static final Class<?>[] _getBasicHeadMasterdataParameterTypes5 =
		new Class[] {};
	private static final Class<?>[] _getPrimaryHeadMasterdataParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getSecondaryHeadMasterdataParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _getTeritaryHeadMasterdataParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _getOrganizationMasterdataParameterTypes9 =
		new Class[] {};
	private static final Class<?>[]
		_getSubOrganizationMasterdataParameterTypes10 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptCategoryMasterdataParameterTypes11 = new Class[] {};
	private static final Class<?>[]
		_getReceiptSubCategoryMasterdataParameterTypes12 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCountriesMasterdataParameterTypes13 =
		new Class[] {};
	private static final Class<?>[] _getStatesMasterdataParameterTypes14 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getBasicHeadByIdMasterdataParameterTypes15 = new Class[] {long.class};
	private static final Class<?>[]
		_getPrimaryHeadByIdMasterdataParameterTypes16 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSecondaryHeadByIdMasterdataParameterTypes17 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTertiaryByIdMasterdataParameterTypes18 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getFileCodeValueByIdMasterdataParameterTypes19 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getCategoryValueByIdMasterdataParameterTypes20 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSubCategoryValueByIdMasterdataParameterTypes21 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getTypeValueByIdMasterdataParameterTypes22 = new Class[] {long.class};
	private static final Class<?>[]
		_getDeliveryModeByIdMasterdataParameterTypes23 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getOrganizationByIdMasterdataParameterTypes24 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getSubOrganizationByIdMasterdataParameterTypes25 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getCountryByIdMasterdataParameterTypes26 =
		new Class[] {long.class};
	private static final Class<?>[] _getStateByIdMasterdataParameterTypes27 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getReceiptCategoryByIdMasterdataParameterTypes28 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptSubCategoryByIdMasterdataParameterTypes29 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getReceiptMovementListByReceiptIdParameterTypes30 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getFileMovementListByFileIdParameterTypes31 = new Class[] {long.class};
	private static final Class<?>[] _getReceiptSentListParameterTypes32 =
		new Class[] {long.class};

}