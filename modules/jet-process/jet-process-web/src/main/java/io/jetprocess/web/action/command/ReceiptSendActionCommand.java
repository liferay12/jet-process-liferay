package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SEND_ACTION_COMMAND }, service = MVCActionCommand.class)
public class ReceiptSendActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String urlvalue = ParamUtil.getString(actionRequest, "pageURL");
		long receiptMovementId = ParamUtil.get(actionRequest, "receiptMovementId", 0);
		
		long receiverId = ParamUtil.get(actionRequest, "receiverId", 0);
		long senderId = ParamUtil.get(actionRequest, "senderId", 0);
		long receiptId = ParamUtil.get(actionRequest, "receiptId", 0);
		String remark = ParamUtil.getString(actionRequest, "remark");
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", simpleformat);
		String priority = ParamUtil.getString(actionRequest, "priorty");
		try {
			receiptMovementLocalService.saveSendReceipt(receiverId, senderId, receiptId, priority, dueDate, remark,receiptMovementId);
			actionResponse.sendRedirect(urlvalue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Reference
	private ReceiptMovementLocalService receiptMovementLocalService;
}
