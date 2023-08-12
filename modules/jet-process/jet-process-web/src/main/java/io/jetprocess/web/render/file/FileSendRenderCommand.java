package io.jetprocess.web.render.file;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.UserPost;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;
import io.jetprocess.web.util.UserPostUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.FILE_SEND_RENDER_COMMAND_POP_UP }, service = MVCRenderCommand.class)
public class FileSendRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		logger.info("FileSendRenderCommand--->");
		long fileId =  ParamUtil.getLong(renderRequest, "fileId");
	long fileMovementId  = ParamUtil.getLong(renderRequest,"fileMovementId");
	long userPostId = UserPostUtil.getUserIdUsingSession(renderRequest);
	
	try {
		List<UserPost> userPostList = userPostLocalService.getUserPostExceptGivenUserPostId(userPostId);
		renderRequest.setAttribute("userPostList", userPostList);

	} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	renderRequest.setAttribute("fileId", fileId);
	renderRequest.setAttribute("fileMovementId", fileMovementId);
		return "/file/send-file.jsp";	
	}

	@Reference
	private UserPostLocalService userPostLocalService; 
	
	private static Log logger = LogFactoryUtil.getLog(FileSendRenderCommand.class);

}
