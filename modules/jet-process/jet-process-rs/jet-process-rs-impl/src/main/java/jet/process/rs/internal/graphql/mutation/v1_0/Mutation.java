package jet.process.rs.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import jet.process.rs.dto.v1_0.FileRsModel;
import jet.process.rs.dto.v1_0.NoteDocumentRsModel;
import jet.process.rs.dto.v1_0.NoteRsModel;
import jet.process.rs.dto.v1_0.ReceiptRsModel;
import jet.process.rs.resource.v1_0.FileRsModelResource;
import jet.process.rs.resource.v1_0.NoteDocumentRsModelResource;
import jet.process.rs.resource.v1_0.NoteRsModelResource;
import jet.process.rs.resource.v1_0.ReceiptRsModelResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFileRsModelResourceComponentServiceObjects(
		ComponentServiceObjects<FileRsModelResource>
			fileRsModelResourceComponentServiceObjects) {

		_fileRsModelResourceComponentServiceObjects =
			fileRsModelResourceComponentServiceObjects;
	}

	public static void setNoteDocumentRsModelResourceComponentServiceObjects(
		ComponentServiceObjects<NoteDocumentRsModelResource>
			noteDocumentRsModelResourceComponentServiceObjects) {

		_noteDocumentRsModelResourceComponentServiceObjects =
			noteDocumentRsModelResourceComponentServiceObjects;
	}

	public static void setNoteRsModelResourceComponentServiceObjects(
		ComponentServiceObjects<NoteRsModelResource>
			noteRsModelResourceComponentServiceObjects) {

		_noteRsModelResourceComponentServiceObjects =
			noteRsModelResourceComponentServiceObjects;
	}

	public static void setReceiptRsModelResourceComponentServiceObjects(
		ComponentServiceObjects<ReceiptRsModelResource>
			receiptRsModelResourceComponentServiceObjects) {

		_receiptRsModelResourceComponentServiceObjects =
			receiptRsModelResourceComponentServiceObjects;
	}

	@GraphQLField
	public FileRsModel createFile(
			@GraphQLName("fileRsModel") FileRsModel fileRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileRsModelResource -> fileRsModelResource.createFile(fileRsModel));
	}

	@GraphQLField
	public FileRsModel updateDocFile(
			@GraphQLName("fileRsModel") FileRsModel fileRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_fileRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			fileRsModelResource -> fileRsModelResource.updateDocFile(
				fileRsModel));
	}

	@GraphQLField
	public NoteDocumentRsModel updateNoteDocument(
			@GraphQLName("noteDocumentRsModel") NoteDocumentRsModel
				noteDocumentRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_noteDocumentRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			noteDocumentRsModelResource ->
				noteDocumentRsModelResource.updateNoteDocument(
					noteDocumentRsModel));
	}

	@GraphQLField
	public NoteDocumentRsModel createNoteDocument(
			@GraphQLName("noteDocumentRsModel") NoteDocumentRsModel
				noteDocumentRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_noteDocumentRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			noteDocumentRsModelResource ->
				noteDocumentRsModelResource.createNoteDocument(
					noteDocumentRsModel));
	}

	@GraphQLField
	public NoteRsModel createNote(
			@GraphQLName("noteRsModel") NoteRsModel noteRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_noteRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			noteRsModelResource -> noteRsModelResource.createNote(noteRsModel));
	}

	@GraphQLField
	public NoteRsModel editNote(
			@GraphQLName("noteRsModel") NoteRsModel noteRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_noteRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			noteRsModelResource -> noteRsModelResource.editNote(noteRsModel));
	}

	@GraphQLField
	public Response deleteNote(@GraphQLName("noteId") Long noteId)
		throws Exception {

		return _applyComponentServiceObjects(
			_noteRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			noteRsModelResource -> noteRsModelResource.deleteNote(noteId));
	}

	@GraphQLField
	public ReceiptRsModel createReceipt(
			@GraphQLName("receiptRsModel") ReceiptRsModel receiptRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_receiptRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			receiptRsModelResource -> receiptRsModelResource.createReceipt(
				receiptRsModel));
	}

	@GraphQLField
	public ReceiptRsModel updateReceipt(
			@GraphQLName("receiptRsModel") ReceiptRsModel receiptRsModel)
		throws Exception {

		return _applyComponentServiceObjects(
			_receiptRsModelResourceComponentServiceObjects,
			this::_populateResourceContext,
			receiptRsModelResource -> receiptRsModelResource.updateReceipt(
				receiptRsModel));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			FileRsModelResource fileRsModelResource)
		throws Exception {

		fileRsModelResource.setContextAcceptLanguage(_acceptLanguage);
		fileRsModelResource.setContextCompany(_company);
		fileRsModelResource.setContextHttpServletRequest(_httpServletRequest);
		fileRsModelResource.setContextHttpServletResponse(_httpServletResponse);
		fileRsModelResource.setContextUriInfo(_uriInfo);
		fileRsModelResource.setContextUser(_user);
		fileRsModelResource.setGroupLocalService(_groupLocalService);
		fileRsModelResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			NoteDocumentRsModelResource noteDocumentRsModelResource)
		throws Exception {

		noteDocumentRsModelResource.setContextAcceptLanguage(_acceptLanguage);
		noteDocumentRsModelResource.setContextCompany(_company);
		noteDocumentRsModelResource.setContextHttpServletRequest(
			_httpServletRequest);
		noteDocumentRsModelResource.setContextHttpServletResponse(
			_httpServletResponse);
		noteDocumentRsModelResource.setContextUriInfo(_uriInfo);
		noteDocumentRsModelResource.setContextUser(_user);
		noteDocumentRsModelResource.setGroupLocalService(_groupLocalService);
		noteDocumentRsModelResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			NoteRsModelResource noteRsModelResource)
		throws Exception {

		noteRsModelResource.setContextAcceptLanguage(_acceptLanguage);
		noteRsModelResource.setContextCompany(_company);
		noteRsModelResource.setContextHttpServletRequest(_httpServletRequest);
		noteRsModelResource.setContextHttpServletResponse(_httpServletResponse);
		noteRsModelResource.setContextUriInfo(_uriInfo);
		noteRsModelResource.setContextUser(_user);
		noteRsModelResource.setGroupLocalService(_groupLocalService);
		noteRsModelResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			ReceiptRsModelResource receiptRsModelResource)
		throws Exception {

		receiptRsModelResource.setContextAcceptLanguage(_acceptLanguage);
		receiptRsModelResource.setContextCompany(_company);
		receiptRsModelResource.setContextHttpServletRequest(
			_httpServletRequest);
		receiptRsModelResource.setContextHttpServletResponse(
			_httpServletResponse);
		receiptRsModelResource.setContextUriInfo(_uriInfo);
		receiptRsModelResource.setContextUser(_user);
		receiptRsModelResource.setGroupLocalService(_groupLocalService);
		receiptRsModelResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FileRsModelResource>
		_fileRsModelResourceComponentServiceObjects;
	private static ComponentServiceObjects<NoteDocumentRsModelResource>
		_noteDocumentRsModelResourceComponentServiceObjects;
	private static ComponentServiceObjects<NoteRsModelResource>
		_noteRsModelResourceComponentServiceObjects;
	private static ComponentServiceObjects<ReceiptRsModelResource>
		_receiptRsModelResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}