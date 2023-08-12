package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.FileCorrReceiptLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=AttachFileCorrespondence" }, service = MVCActionCommand.class)
public class AttachReceiptActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("Attaching receipt...");
		long receiptId = ParamUtil.getLong(actionRequest, "receiptId");
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long userPostId = ParamUtil.getLong(actionRequest, "userPostId");
		long receiptMovementId = ParamUtil.getLong(actionRequest, "receiptMovementId");
		String remarks = ParamUtil.getString(actionRequest, "remarks");
		long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");
		ReceiptMovement receiptMovement = receiptMovementLocalService.getReceiptMovement(receiptMovementId);
		long movementType = receiptMovement.getMovementType();
		boolean status = false;

		if (movementType == 1) {
			logger.info("Checked Receipt Movement Type : "+movementType);
			status = receiptMovementLocalService.isInboxReceiptAttachable(receiptId, receiptMovementId);
		} else {
			logger.info("Checked Receipt Movement Type : "+movementType);
			status = receiptMovementLocalService.isCreatedReceiptAttachable(receiptId, receiptMovementId);
		}

		if (status == true) {
			fileCorrReceiptLocalService.addReceiptInFile(receiptId, docFileId, userPostId, remarks, receiptMovementId,
					fileMovementId);
			logger.info("Rceipt successfully Attached..");

		} else {
			SessionErrors.add(actionRequest, "receipt-is-not-attachable");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			logger.error("Rceipt is not attachable..");
		}
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		actionResponse.sendRedirect(redirectURL);

	}

	@Reference
	private FileCorrReceiptLocalService fileCorrReceiptLocalService;
	
	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());

}
