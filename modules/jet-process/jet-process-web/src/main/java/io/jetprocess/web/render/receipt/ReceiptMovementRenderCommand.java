package io.jetprocess.web.render.receipt;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.ReceiptListService;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.ReceiptMovementDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptMovementRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("ReceiptMovementRenderCommand---->");
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId");
		long receiptMovementId = ParamUtil.getLong(renderRequest, "receiptMovementId");
		String backPageURL = ParamUtil.getString(renderRequest, "backPageURL");
		Receipt receipt;
		try {
			receipt = receiptLocalService.getReceipt(receiptId);
			renderRequest.setAttribute("backPageURL", backPageURL);
			renderRequest.setAttribute("receiptMovementId", receiptMovementId);
			renderRequest.setAttribute("receipt", receipt);
			setReceiptMovementList(renderRequest);
			setManagementToolbarAttributes(renderRequest, renderResponse);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/receipt/movement.jsp";
	}

	private void setManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
		ReceiptMovementDisplayContext receiptMovementDisplayContext = new ReceiptMovementDisplayContext(
				liferayPortletRequest, liferayPortletResponse, portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("receiptMovementDisplayContext", receiptMovementDisplayContext);
	}

	private void setReceiptMovementList(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		long receiptId = ParamUtil.getLong(renderRequest, "receiptId", 0);
		long receiptMovementId = ParamUtil.getLong(renderRequest, "receiptMovementId", 0);

		List<ReceiptMovementDTO> receiptMovementList = new ArrayList();

		int count = receiptList.getReceiptMovementListCount(receiptMovementId, receiptId, "");
		
		Map<String, Integer> paginationConfig = Pagination.getOffset(delta, currentPage, count);
		start = paginationConfig.get("start");
		currentPage = paginationConfig.get("currentPage");

		if (receiptId != 0) {
			receiptMovementList = receiptList.getReceiptMovementList(receiptMovementId, receiptId, "", start, end, "",
					"");
		}

		if (receiptMovementList != null) {
			renderRequest.setAttribute("receiptMovementList", receiptMovementList);
		}
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("receiptMovementCount", +count);

	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal portal;
	@Reference
	private ReceiptListService receiptList;
	@Reference
	private ReceiptLocalService receiptLocalService;

}
