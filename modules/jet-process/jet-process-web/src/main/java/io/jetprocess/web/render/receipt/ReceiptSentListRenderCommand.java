package io.jetprocess.web.render.receipt;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.Pagination;
import io.jetprocess.list.api.ReceiptListService;
import io.jetprocess.list.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.display.context.SendReceiptManagementToolbarDisplayContext;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.RECEIPT_SENT_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class ReceiptSentListRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("ReceiptSentListRenderCommand---->");
		setReceiptSentListAttributes(renderRequest);
		setReceiptSentToolbarAttributes(renderRequest, renderResponse);
		return "/receipt/sent_list.jsp";
	}

	private void setReceiptSentListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = delta;
		HttpSession session = themeDisplay.getRequest().getSession();
		long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "sentOn");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "desc");

		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int count = _receiptList.getReceiptSentListCount(userPostId, keywords);
			Map<String, Integer> paginationConfig=Pagination.getOffset(delta, currentPage, count);
			start=paginationConfig.get("start");
			currentPage=paginationConfig.get("currentPage");
			
		List<ReceiptMovementDTO> receiptList = _receiptList.getReceiptSentList(userPostId, keywords, start, end,
				orderByCol, orderByType);
		
		renderRequest.setAttribute("receiptList", receiptList);
		renderRequest.setAttribute("receiptCount", count);
		renderRequest.setAttribute("delta", delta);
	}

	/**
	 * Adds Clay management toolbar context object to the request.*
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void setReceiptSentToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		SendReceiptManagementToolbarDisplayContext sendReceiptManagementToolbarDisplayContext = new SendReceiptManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("sendReceiptManagementToolbarDisplayContext",
				sendReceiptManagementToolbarDisplayContext);
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	
	@Reference
	private MasterdataLocalService masterdataLocalService;
	@Reference
	private Portal _portal;
	@Reference
    private	ReceiptListService _receiptList;
}