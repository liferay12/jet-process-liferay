<%@ include file="../init.jsp"%>

<portlet:renderURL var="receiptDetailsPopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_DETAIL_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="reopenReceiptURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_REOPEN_POP_UP%>" /> 
</portlet:renderURL>


<style>
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
    color: #000000;
}




</style>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-receipt-closed-heading" />
		</h1>
		<clay:management-toolbar searchContainerId="closedReceiptEntries"
			disabled="${closedReceiptCount eq 0 }"
			itemsTotal="${closedReceiptCount}"
			displayContext="${closedReceiptManagementToolbarDisplayContext}"
			selectable="false" />

		<liferay-ui:search-container id="closedReceiptEntries"
			emptyResultsMessage="message-record-not-found"
			total="${closedReceiptCount}" delta="${delta }"
			iteratorURL="${closedReceiptManagementToolbarDisplayContext._getCurrentURL() }">
			<liferay-ui:search-container-results results="${closedReceiptList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ClosedReceiptDTO"
				modelVar="closedReceiptDTO" keyProperty="closedReceiptId">

				<c:set var="firstLetterOfNature" value="${closedReceiptDTO.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-type">
					<span title="${closedReceiptDTO.nature }">${nature} </span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-receiptNumber" orderable="true"
					orderableProperty="receiptNumber" cssClass="hyperlink-css">
					<a onclick="receiptDetailPopup(${closedReceiptDTO.receiptId})"
						style="cursor: pointer">${closedReceiptDTO.receiptNumber }</a>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					value="${closedReceiptDTO.subject }"
					name="label-receipt-closed-subject" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-closedOn" orderable="true"
					orderableProperty="closedOn">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${closedReceiptDTO.closedOn}" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-closingRemarks" cssClass="hover-tips"
					property="closingRemarks" />
					
				
         <liferay-ui:search-container-column-text
					name="label-receipt-reopen-actions" cssClass="hover-tips" >
					<a href="#" onClick="getReceiptreopenPopup(${closedReceiptDTO.receiptId} , ${closedReceiptDTO.closedReceiptId} )" >
					<img   alt="reopen-receipt" title="Reopen" src = '<%=request.getContextPath() + "/image/reopen-image.png"%>' 
					width="35%" height="25" />
					 </a>
					</liferay-ui:search-container-column-text>
        
				

			</liferay-ui:search-container-row>

			<%-- Iterator / Paging --%>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>    
	</div>
</div>
<aui:script>
function receiptDetailPopup(receiptId){
	var title="<liferay-ui:message key='title-closed-receiptDetailPopup' />";
	Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 550,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 1200,
			on: {
	        	destroy: function() { 
	           		parent.location.reload();                   
	       	 	}
	      	}													 
		}, 														 
		id: '<portlet:namespace />dialog',														 
		title: title, 														 
		uri: '<%=receiptDetailsPopup%>&<portlet:namespace />receiptId='+receiptId,			
		});	  
	}
	
	
	/*  For open reopenCloseReceipt Pop up */
	function getReceiptreopenPopup(receiptId,closedReceiptId){
	 	var receiptReopenURL = '<%=reopenReceiptURL%>&<portlet:namespace/>receiptId='+receiptId+'&<portlet:namespace/>closedReceiptId='+closedReceiptId;
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
				title: 'Receipt ReopenRemarks',
				uri: receiptReopenURL
				
			});
		}

	
</aui:script>