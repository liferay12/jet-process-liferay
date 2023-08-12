package io.jetprocess.web.render.receipt;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.render.ReceiptViewHelper;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(renderRequest, "rmId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		renderRequest.setAttribute("backPageURL", backPageURL);
		renderRequest.setAttribute("receiptMovementId", receiptMovementId);
		System.out.println("data--->"+receiptMovementId);
		
		receiptViewHelper.setRecieptDetails(receiptId, renderRequest, renderResponse);
		return "/receipt/receipt_view.jsp";
	}
	

	@Reference
	private ReceiptViewHelper receiptViewHelper;

}
