<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<!-- <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 -->
<!-- <link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"> -->
<style>
#sideNav {
	padding: 5px;
	position: sticky;
	top: 0;
	/* width: 15%;
          position: fixed;
          z-index: 1;
          padding-top: 10%;
          left: 0; */
	background-color: #345686;
	/* overflow-x: hidden; */
	color: white;
}

.side-nav a {
	text-align: center;
	margin: 5px;
	text-decoration: none;
	font-size: 18px;
	color: white;
	display: block;
	line-height: 35px;
	border: 2px solid #819394;
	border-radius: 30px;
	background: #2f466e;
}

.side-nav a:hover {
	color: #f1f1f1;
}

.side-nav .dropdown-container {
	padding-left: 30px;
}

.side-nav .dropdown-container a {
	background: #1d4f3d;
}

/*         .main {
          margin-left: 160px; /* Same as the width of the sidenav */
/* padding: 0px 10px;
        }*/

/*@media screen and (max-height: 450px) {
          .sidebar {padding-top: 15px;}
          .sidebar a {font-size: 18px;}
        }
 */
/*  @media all and (max-height: 450px) {
	.side-nav a .dropdown-btn {
		display: none;
	}
	.side-nav a:hover .nav-link {
		
	}
	.side-nav a:hover .dropdown-container  {
		display: block;
	}
	.side-nav .a .dropdown-container  {
		margin-top: 0;
	}
}  */
</style>
<!-- </head>
<body id="side-nav"> -->
<div id="sideNav">
	<portlet:renderURL var="view">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_FILE_LIST_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="home" />
	</portlet:renderURL>
	<portlet:renderURL var="createFile">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.CREATE_FILE_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="createFile" />
	</portlet:renderURL>
	<portlet:renderURL var="createdFileList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_FILE_LIST_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="fileList" />
	</portlet:renderURL>
	<portlet:renderURL var="createReceipt">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.CREATE_RECEIPT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="createReceipt" />
	</portlet:renderURL>
	<portlet:renderURL var="createdListReceipt">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_RECEIPT_LIST_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptList" />
	</portlet:renderURL>
<portlet:renderURL var="fileClosedList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.FILE_CLOSE_LIST_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="fileClosedList" />
	</portlet:renderURL>
	<portlet:renderURL var="fileInbox">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.FILE_INBOX_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="fileInbox" />
	</portlet:renderURL>
	<portlet:renderURL var="receiptInbox">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.RECEIPT_INBOX_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptInbox" />
	</portlet:renderURL>
	<portlet:renderURL var="fileSent">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.FILE_SENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="fileSent" />
	</portlet:renderURL>
	<portlet:renderURL var="receiptSent">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.RECEIPT_SENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptSent" />
	</portlet:renderURL>
	<portlet:renderURL var="receiptClosedList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.RECEIPT_CLOSE_LIST_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptClosedList" />
	</portlet:renderURL>
	<portlet:renderURL var="createNoteDocument">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.CREATE_NOTE_DOCUMENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptClosedList" />
	</portlet:renderURL>
	<portlet:renderURL var="createdDocumentList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.CREATED_LIST_NOTE_DOCUMENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="documentList" />
	</portlet:renderURL>
	<portlet:renderURL var="inboxDocumentList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.INBOX_LIST_NOTE_DOCUMENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptClosedList" />
	</portlet:renderURL>
	<portlet:renderURL var="sendDocumentList">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.SEND_LIST_NOTE_DOCUMENT_RENDER_COMMAND%>" />
		<portlet:param name="selectedNav" value="receiptClosedList" />
	</portlet:renderURL>


	<!-- <nav class="navbar navbar-expand-lg"> -->
	<!-- <button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#sideNav"
			aria-controls="sideNav" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button> -->

	<div class="side-nav ">
		<a id="home" href="<%=view%>"><i class="fa fa-fw fa-home"></i>
			Home</a> <a class="dropdown-btn"><i class="fa fa-file"
			aria-hidden="true"></i> File <i class="fa fa-caret-down"></i> </a>
		<div class="dropdown-container ">
			<a id="createFile" href="<%=createFile%>">Create File</a> <a
				id="fileList" href="<%=createdFileList%>">Created List</a> <a
				id="fileInbox" href="<%=fileInbox%>">Inbox</a> <a id="fileSent"
				href="<%=fileSent%>">Sent</a>
				<a id="fileClosedList"
				href="<%=fileClosedList%>">Closed List</a>

		</div>
		<a class="dropdown-btn"><i class='fas fa-receipt'
			style='font-size: 24px'></i> Receipt <i class="fa fa-caret-down"></i>
		</a>
		<div class="dropdown-container ">
			<a id="createReceipt" href="<%=createReceipt%>">Create Receipt</a> <a
				id="receiptList" href="<%=createdListReceipt%>">Created List</a> <a
				id="receiptInbox" href="<%=receiptInbox%>">Inbox</a> <a
				id="receiptSent" href="<%=receiptSent%>">Sent</a>
			<a id="receiptCloseList" href="<%=receiptClosedList %>">Closed List</a>
		</div>
		<a class="dropdown-btn"><i class='fa fa-file-text-o'
			style='font-size: 24px'></i> Note Document <i class="fa fa-caret-down"></i>
		</a>
		<div class="dropdown-container ">
			<a id="createReceipt" href="<%=createNoteDocument%>">Create Note Document</a> <a
				id="documentList" href="<%=createdDocumentList%>">Created List</a> <a
				id="receiptInbox" href="<%=inboxDocumentList%>">Inbox</a> <a
				id="receiptSent" href="<%=sendDocumentList%>">Sent</a>
			
		</div>

	</div>

	<!-- </nav> -->
</div>

<script>
	/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
	var dropdown = document.getElementsByClassName("dropdown-btn");
	var i;

	for (i = 0; i < dropdown.length; i++) {
		dropdown[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var dropdownContent = this.nextElementSibling;
			if (dropdownContent.style.display == "block") {
				dropdownContent.style.display = "none";
			} else {
				dropdownContent.style.display = "block";

			}
		});
	}

	/* var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId);

	nav.style.color = 'blue'; */
</script>

<!-- </body>
</html> -->