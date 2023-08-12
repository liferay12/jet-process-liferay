<%@ include file="../init.jsp"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<%
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			String portalURL = serviceContext.getPortalURL();
		%>
		<portlet:renderURL var="FileList">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_FILE_LIST_RENDER_COMMAND%>" />
		</portlet:renderURL>

		<div class="container">
			<div class="card">
				<aui:form name="formId">
					<div class="card-body">

						<!-- <div class="row">
							<div class="col-md-12 col-sm-12"> -->
						<div class="card">
							<div class="row card-body">

								<!-- <div class="row mt-2"> -->
								<div class="col-md-12 col-sm-12">
									<div class="text-center">
										<h1>
											<liferay-ui:message key="label-file-hin-bharat-sarkar" />
										</h1>
										<h4>
											<liferay-ui:message key="label-file-govt-of-india" />
										</h4>
										<h4>
											<liferay-ui:message key="label-file-mha" />
										</h4>
									</div>
									<div class="container">
										<div class="row">
											<div class="col-md-12 d-flex justify-content-between">
												<div class="row">
													<div class="col-auto">
														<aui:select label="label-file-nature"
															cssClass="form-select form-control" id="nature"
															name="nature">
															<option value="Electronic"><liferay-ui:message
																	key="label-file-nature-option1" /></option>
															<option value="Physical"><liferay-ui:message
																	key="label-file-nature-option2" /></option>
														</aui:select>
													</div>
												</div>
												<div class="row">
													<div class="col-auto">
														<aui:select class="form-select form-control" id="type"
															label="label-file-nature-type" name="type">
															<option value="NON-SFS"><liferay-ui:message
																	key="label-file-nature-type-option1-nonsfs" /></option>
															<option value="SFS"><liferay-ui:message
																	key="label-file-nature-type-option2-sfs" /></option>
														</aui:select>
													</div>
												</div>
											</div>
										</div>
									</div>
									<%-- <aui:container> --%>
									<aui:row>
										<aui:col md="12">
											<div class="row mt-3 " id="non-sfs">
												<%--  <aui:input name="userPostId" label="" value = "1" id= "userPostId" />  --%>
												<legend class="child-scheduler-border"
													style="margin-left: 30px;">
													<liferay-ui:message key="label-file-fileno" />
													<span class='text-danger'>*</span>
												</legend>
												<aui:fieldset cssClass=" p-0 child-scheduler-border">
													<aui:row>
														<div class="col-md-2 col-sm-6 ">
															<aui:select cssClass="form-select form-control"
																name="basicHeadId" id="basicHeadId"
																label="label-file-basic-head-id">
																<option value=""><liferay-ui:message
																		key="file-default-option" /></option>
																<aui:validator name="required" />
															</aui:select>
														</div>
														<div class="col-md-2 col-sm-6 ">
															<aui:select cssClass="form-select form-control"
																name="primaryHeadId" id="primaryHeadId"
																label="label-file-primary-head-id">
																<option value=""><liferay-ui:message
																		key="file-default-option" /></option>
																<aui:validator name="required" />
															</aui:select>

														</div>
														<div class="col-md-2 col-sm-6 ">
															<aui:select cssClass="form-select form-control"
																name="secondaryHeadId" id="secondaryHeadId"
																label="label-file-secondary-head-id">
																<option value=""><liferay-ui:message
																		key="file-default-option" /></option>
																<aui:validator name="required" />
															</aui:select>
														</div>
														<div class="col-md-2 col-sm-6 ">
															<aui:select cssClass="form-select form-control"
																name="tertiaryHeadId" id="tertiaryHeadId"
																label="label-file-tertiary-head-id">
																<option value=""><liferay-ui:message
																		key="file-default-option" /></option>
																<aui:validator name="required" />
															</aui:select>
														</div>
														<div class="col-md-2 col-sm-6 ">
															<aui:input type="text" cssClass="form-control" id="year"
																name="year" value="" label="label-file-year"
																readonly="true">
															</aui:input>
														</div>
														<div class="col-md-2 col-sm-6 ">
															<aui:select cssClass="form-select form-control"
																name="fileCodeId" id="fileCodeId"
																label="label-file-filecode-id">
																<option value=""><liferay-ui:message
																		key="file-default-option" /></option>
																<aui:validator name="required" />
															</aui:select>
														</div>

													</aui:row>
												</aui:fieldset>

											</div>

											<div class="row " id="sfs"
												style="display: none; padding-left: 10px !important;">
												<aui:fieldset cssClass="col-md-12 child-scheduler-border">
													<legend cssClass="child-scheduler-border">
														<liferay-ui:message key="label-file-fileno" />
														<span class='text-danger'>*</span>
													</legend>
													<aui:input class="form-control" type="text"
														name="fileNumber" id="fileNumber" value="" label="">
														<aui:validator name="maxLength">
															<liferay-ui:message key="file-filenumber-maxlength" />
														</aui:validator>
														<aui:validator name="required" />
													</aui:input>
												</aui:fieldset>
											</div>


										</aui:col>

									</aui:row>
									<%-- </aui:container> --%>
								</div>
								<!-- </div> -->
							</div>
						</div>
						<!--</div>
						</div> -->


						<div class="row">
							<div class="container">
								<aui:fieldset cssClass="scheduler-border col-md-12">
									<div class="row">
										<aui:fieldset cssClass="scheduler-border col-md-12">
											<!-- <legend class="child-scheduler-border">
											Subject<span class='text-danger'>*</span>
										</legend> -->

											<label> <liferay-ui:message key="label-file-subject" />
												<span class='text-danger'>*</span>
											</label>
											<aui:input cssClass="form-control" type="text" name="subject"
												value="" id="subject" label="">
												<aui:validator name="maxLength">
													<liferay-ui:message key="file-subject-maxlength" />
												</aui:validator>
												<aui:validator name="required" />
											</aui:input>
										</aui:fieldset>
									</div>
									<div class="row" style="margin-left: -15px !important">
										<aui:fieldset cssClass="child-scheduler-border col-md-6">
											<!-- 	<legend class="child-scheduler-border">Category</legend> -->
											<div cssClass="input-group">
												<aui:select cssClass="form-select form-control"
													id="categoryId" name="categoryId"
													label="label-file-categoryid">

													<option value=''><liferay-ui:message
															key="file-default-option" /></option>
													<aui:validator name="required" />
												</aui:select>
											</div>
										</aui:fieldset>
										<aui:fieldset cssClass="child-scheduler-border col-md-6"
											style="margin-top: 3px !important">
											<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
											<div cssClass="input-group">
												<aui:select cssClass="form-select form-control"
													id="subCategoryId" name="subCategoryId"
													label="label-file-sub-categoryid">
													<option value='0'><liferay-ui:message
															key="file-default-option" /></option>


												</aui:select>
											</div>
										</aui:fieldset>
									</div>
								</aui:fieldset>
							</div>
							<div class="container">
								<aui:fieldset cssClass="scheduler-border col-md-12">
									<div class="row">
										<aui:fieldset cssClass="col-md-12 child-scheduler-border">
											<!-- <legend class="child-scheduler-border">
											Remark<span class='text-danger'>*</span>
										</legend>-->
											<aui:input cssClass="form-control col-md-12" rows="3"
												type="textarea" name="remarks" id="remarks" value=""
												label="label-file-remark"
												style="padding: 6px 12px !important;">

												<aui:validator name="maxLength">
													<liferay-ui:message key="file-remark-maxlength" />
												</aui:validator>
											</aui:input>

										</aui:fieldset>
									</div>
									<div class="row">
										<aui:fieldset cssClass="child-scheduler-border col-md-12">
											<!-- <legend class="child-scheduler-border">
											Reference<span class='text-danger'>*</span>
										</legend> -->
											<aui:input cssClass="form-control col-md-12 " type="text"
												name="reference" id="reference" value=""
												style="padding: 6px 12px !important;"
												label="label-file-reference">

												<aui:validator name="maxLength">
													<liferay-ui:message key="file-reference-maxlength" />
												</aui:validator>
											</aui:input>


										</aui:fieldset>
									</div>
								</aui:fieldset>
							</div>
						</div>
						<div class="text-center">
							<aui:button type="button" cssClass="btn btn-primary"
								value="file-submit-button" id="add-docfile"></aui:button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<aui:script>
$('#<portlet:namespace />type').change(function(){
  	let value =  $('#<portlet:namespace />type').val();
	if(value === "NON-SFS"){
		$('#non-sfs').show();
		$('#sfs').hide();
	}else{
		$('#non-sfs').hide();
		$('#sfs').show();
	}
});
</aui:script>
<%@ include file="/js/file.js"%>