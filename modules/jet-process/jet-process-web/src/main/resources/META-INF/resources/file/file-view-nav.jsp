<%@ include file="../init.jsp"%>

<style>
.border a {
	border-right: 1px solid #a19c9c;
	font-weight: 700;
}

@media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu {
		display: none;
	}
	.navbar .nav-item:hover .nav-link {
		
	}
	.navbar .nav-item:hover .dropdown-menu {
		display: block;
	}
	.navbar .nav-item .dropdown-menu {
		margin-top: 0;
	}
}
</style>

<%
	String docFileId = renderRequest.getParameter("docFileId");
	long fileMovementId = (long) renderRequest.getAttribute("fileMovementId");
	String viewMode = renderRequest.getParameter("viewMode");
	HttpSession userPostId = themeDisplay.getRequest().getSession();
	String userPostsValue = (String) userPostId.getAttribute("userPostId");
	String backPageURL = (String) renderRequest.getAttribute("backPageURL");
%>
<portlet:renderURL var="fileMovement">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.FILE_MOVEMENT_RENDER_COMMAND%>" />
	<portlet:param name="docFileId" value="<%=docFileId%>" />
 	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
 	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
	<portlet:param name="viewMode" value="<%=viewMode%>" />
</portlet:renderURL>

<portlet:renderURL var="fileDetails">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.FILE_DETAILS_RENDER_COMMAND%>" />
	<portlet:param name="docFileId" value="<%=docFileId%>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
 	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
	<portlet:param name="viewMode" value="<%=viewMode%>" />
</portlet:renderURL>

<portlet:renderURL var="editFile">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.EDIT_FILE_RENDER_COMMAND%>" />
	<portlet:param name="docFileId" value="<%=docFileId%>" />
	 	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	
	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
</portlet:renderURL>

<portlet:renderURL var="fileSend">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND%>" />
	<portlet:param name="docFileId" value="<%=docFileId%>" />
 	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	<portlet:param name="userPostId" value="<%= userPostsValue %>" />
	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
</portlet:renderURL>

<portlet:renderURL var="putinfile">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.FILEINNERVIEW_RENDER_COMMAND%>" />
	<portlet:param name="docFileId" value="<%=docFileId%>" />
	 	<portlet:param name="backPageURL" value="<%=backPageURL%>" />
	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
 	<portlet:param name="viewMode" value="<%=viewMode%>" />
</portlet:renderURL>
<portlet:renderURL var="sendback">
	<portlet:param name="mvcPath" value="/file/sendback.jsp" />
</portlet:renderURL>


<portlet:renderURL var = "closeFileURL" 
windowState = "<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name = "mvcRenderCommandName" 
	value = "<%=MVCCommandNames.FILE_CLOSE_RENDER_COMMAND %>" />
	<portlet:param name="backPageURL" value="<%=backPageURL%>" /> 
</portlet:renderURL>
 
<%-- <portlet:renderURL var="dispatch">
    <portlet:param name="mvcPath" value="/file/dispatch.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="convert">
    <portlet:param name="mvcPath" value="/file/convert.jsp"/>
</portlet:renderURL> --%>
<portlet:renderURL var="option1">
	<portlet:param name="mvcPath" value="/file/option1.jsp" />
</portlet:renderURL>




<nav class="navbar navbar-expand-lg navbar-light  mt-1 "
	style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav">
			<li class="nav-item border"><a id="putinfile" class="nav-link"
				href="<%=putinfile%>"><i class="fa fa-home"></i></a></li>
			<li class="nav-item border "><a id="details" class="nav-link"
				href="<%=fileDetails%>">Details</a></li>
			<li class="nav-item border "><a id="movement" class="nav-link"
				href="<%=fileMovement%>">Movement</a></li>

			<li class="nav-item dropdown border "><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Draft <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu ">
					<a id="option1" class="dropdown-item" href="#">Option1</a>
					<a class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li>
			<li class="nav-item border"><a id="edit" class="nav-link"
				href="<%=editFile%>">Edit</a></li>
			<li class="nav-item border"><a id="send" class="nav-link"
				href="<%=fileSend%>">Send</a></li>
			<li class="nav-item border"><a id="sendback" class="nav-link"
				href="#">Send Back</a></li>
			<li class="nav-item dropdown border"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Link <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Option1</a> <a
						class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li>
			<li class="nav-item dropdown border"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Attach <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Option1</a> <a
						class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li>
			<%-- <li class="nav-item dropdown border"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Park <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<%=option1%>">Option1</a> <a
						class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li> --%>
			<%-- <li class="nav-item dropdown border"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> Close <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<%=option1%>">Option1</a> <a
						class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li> --%>
			<%-- <li class="nav-item border">
			     <a class="nav-link" href="<%= dispatch %>">Dispatch</a>
			 </li>
			 <li class="nav-item border">
			     <a class="nav-link" href="<%= convert %>">Convert</a>
			  </li> --%>
			<li class="nav-item dropdown border"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-expanded="false"> More <i
					class="fa fa-caret-down"></i>
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Option1</a> <a
						class="dropdown-item" href="#">Option2</a> <a
						class="dropdown-item" href="#">Option3</a>
				</div></li>
				
			<c:if test="${userPostSectionId==fileSectionId}">
				 <li class="nav-item border"><a id="closeFile"  href="#" 
	       onClick="OpenCloseFilePopUp(<%=docFileId %>,<%=String.valueOf(fileMovementId)%>)" 
	       class="nav-link">Close</a></li>
	       </c:if>
				
		</ul>
		<div class="nav-item d-flex ">
			<a class="nav-link  align-end bg-primary" Style="border-radius: 5px;"
				href="#"><i class="fa fa-print" style="color: white;"
				aria-hidden="true"></i></a>
		</div>

	</div>
</nav>




<script>
	var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId);
	nav.style.color = 'blue';

	var viewMode = "${param.viewMode}";
	if (viewMode == 'ViewModeFromSentFile') {
		$('#edit').addClass('disabled');
		$('#send').addClass('disabled');
		$('#sendback').addClass('disabled');
	}
	
	function OpenCloseFilePopUp(docFileId, fileMovementId){
		var fileCloseURL = '<%= closeFileURL%>&<portlet:namespace/>docFileId='+docFileId+'&<portlet:namespace/>fileMovementId='+fileMovementId;
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 265,
				destroyOnClose: true,														 
				destroyOnHide: true, 
				modal: true,
				width: 500
			},
			id: '<portlet:namespace/>dialog',
			title: 'Closing Remarks',
			uri: fileCloseURL
			
		});
	}
</script>
