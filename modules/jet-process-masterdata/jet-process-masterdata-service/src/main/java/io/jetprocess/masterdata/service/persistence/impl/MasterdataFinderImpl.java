package io.jetprocess.masterdata.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.GenericModelMapper;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.model.impl.MasterdataImpl;
import io.jetprocess.masterdata.service.persistence.MasterdataFinder;

@Component(service = MasterdataFinder.class)
public class MasterdataFinderImpl extends MasterdataFinderBaseImpl implements MasterdataFinder {

	@Reference
	private CustomSQL customSQL;



	public List<Masterdata> getCategories() {
		List<Masterdata> masterdataList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCategories");
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			masterdataList = (List<Masterdata>) sqlQuery.list();
			return masterdataList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return masterdataList;

	}

	public List<Masterdata> getSubCategories(long categoryId) {

		List<Masterdata> subCategoryList = Collections.EMPTY_LIST;
		Session session = null;

		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubCategories");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(categoryId);
			subCategoryList = (List<Masterdata>) sqlQuery.list();
			return subCategoryList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return subCategoryList;

	}

	public List<Masterdata> getType() {

		List<Masterdata> typeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getType");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			typeList = (List<Masterdata>) sqlQuery.list();
			return typeList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return typeList;

	}

	public List<Masterdata> getDeliveryMode() {

		List<Masterdata> deliveryModeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getDeliveryMode");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			deliveryModeList = (List<Masterdata>) sqlQuery.list();
			return deliveryModeList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return deliveryModeList;
	}

	public List<Masterdata> getFileCode() {

		List<Masterdata> fileCodeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCode");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			fileCodeList = (List<Masterdata>) sqlQuery.list();
			return fileCodeList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return fileCodeList;

	}

	public List<Masterdata> getBasicHeads() {
		List<Masterdata> basicHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getBasicHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			basicHeadList = (List<Masterdata>) sqlQuery.list();
			return basicHeadList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return basicHeadList;
	}

	public List<Masterdata> getPrimaryHeads(long basicHeadId) {

		List<Masterdata> primaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getPrimaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(basicHeadId);

			primaryHeadList = (List<Masterdata>) sqlQuery.list();
			return primaryHeadList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return primaryHeadList;
	}

	public List<Masterdata> getSecondaryHeads(long primaryHeadId) {

		List<Masterdata> secondaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSecondaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(primaryHeadId);
			secondaryHeadList = (List<Masterdata>) sqlQuery.list();
			return secondaryHeadList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return secondaryHeadList;
	}

	public List<Masterdata> getTeritaryHeads(long secondaryHeadsId) {

		List<Masterdata> teritaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTeritaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(secondaryHeadsId);
			teritaryHeadList = (List<Masterdata>) sqlQuery.list();
			return teritaryHeadList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return teritaryHeadList;
	}

	public List<Masterdata> getOrganization() {

		List<Masterdata> organizationList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getOrganizations");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			organizationList = (List<Masterdata>) sqlQuery.list();
			return organizationList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return organizationList;
	}

	public List<Masterdata> getSubOrganization(long organizationId) {

		List<Masterdata> subOrganizationList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubOrganizations");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(organizationId);
			subOrganizationList = (List<Masterdata>) sqlQuery.list();
			return subOrganizationList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return subOrganizationList;
	}

	public List<Masterdata> getReceiptCategory() {

		List<Masterdata> receiptCategoryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptCategory");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			receiptCategoryList = (List<Masterdata>) sqlQuery.list();
			return receiptCategoryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return receiptCategoryList;
	}

	public List<Masterdata> getReceiptSubCategory(long receiptCategoryId) {

		List<Masterdata> receiptSubCategoryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSubCategory");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptCategoryId);
			receiptSubCategoryList = (List<Masterdata>) sqlQuery.list();
			return receiptSubCategoryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return receiptSubCategoryList;
	}

	public List<Masterdata> getCountries() {

		List<Masterdata> countryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCountries");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			countryList = (List<Masterdata>) sqlQuery.list();
			return countryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return countryList;
	}

	public List<Masterdata> getStates(long countryId) {

		List<Masterdata> stateList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getStates");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(countryId);
			stateList = (List<Masterdata>) sqlQuery.list();
			return stateList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return stateList;
	}

	public Masterdata getBasicHeadById(long basicHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getBasicHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(basicHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getPrimaryHeadById(long primaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getPrimaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(primaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getSecondaryHeadById(long secondaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSecondaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(secondaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getTertiaryHeadById(long tertiaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTertiaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(tertiaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}



	


	public Masterdata getFileCodeValueById(long fileCodeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCodeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileCodeId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getCategoryValueById(long categoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(categoryId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getSubCategoryValueById(long subCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(subCategoryId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getTypeValueById(long typeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTypeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(typeId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getDeliveryModeValueById(long deliveryModeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getDeliveryModeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(deliveryModeId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getOrganizationValueById(long organizationId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getOrganizationValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(organizationId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getSubOrganizationValueById(long subOrganizationId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubOrganizationValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(subOrganizationId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getCountryValueById(long countryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCountryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(countryId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getStateValueById(long stateId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getStateValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(stateId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getReceiptCategoryValueById(long receiptCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptCategoryId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getReceiptSubCategoryValueById(long receiptSubCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSubCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptSubCategoryId);
			object = sqlQuery.uniqueResult();

			return (Masterdata) object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ReceiptMovementDTO> getReceiptSentListByFinder(long userPostId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSentList");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(long receiptId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptMovementList");
			logger.info("Final Receipt Movement List Query : " + sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptId);
			return GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}



	public List<FileMovementDTO> getFileMovementListByFileId(long fileId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileMovementList");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileId);
			return GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}



	public List<FileCorrespondenceReceiptDTO> getFileCorrespondenceReceiptDetails(long fileId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCorrespondenceReceiptList");
			logger.info("Final File Movement List Query : " + sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileId);
			return GenericModelMapper.map(FileCorrespondenceReceiptDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public long getMaximumFmIdByFileId(long fileId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getMaximumFmIdByFileId");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileId);
			List count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
			}
			int i1 = b1.intValue();
			return i1;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Long) null;
	}

	public long getMaximumRmIdByReceiptId(long receiptId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getMaximumRmIdByReceiptId");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptId);
			List count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
			}
			int i1 = b1.intValue();
			return i1;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Long) null;
	}
	
	
	public long getLastActiveRmIdByReceiptId(long receiptId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getLastActiveRmIdByReceiptId");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptId);
			List count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
			}
			int i1 = b1.intValue();
			return i1;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Long) null;
	}
	
	
	public long getMaxCloseReceiptId(long receiptId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "maxReceiptClosedId");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptId);
			logger.info("sql "+sql+receiptId);
			List count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
				logger.info("sql "+b1);
			}
			long i1 = b1.longValue();
			return i1;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Long) null;
	}

	public List<Masterdata> getSubjectCategory() {

		List<Masterdata> subjectCategoryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubjectCategory");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			subjectCategoryList = (List<Masterdata>) sqlQuery.list();
			return subjectCategoryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return subjectCategoryList;
	}
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
