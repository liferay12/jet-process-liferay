package io.jetprocess.list.api;

import java.util.List;

import io.jetprocess.list.model.ClosedReceiptDTO;
import io.jetprocess.list.model.ReceiptListViewDto;
import io.jetprocess.list.model.ReceiptMovementDTO;

public interface ReceiptListService {

	public int getReceiptListCount(long userpostId, String keyword);

	public List<ReceiptListViewDto> getReceiptList(long userPostId, String keyword, int start, int end, String orderBy,
			String order);

	public int getReceiptInboxListCount(long userpostId, String keyword);

	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);

	public int getReceiptSentListCount(long userpostId, String keyword);

	public List<ReceiptMovementDTO> getReceiptSentList(long userPostId, String keyword, int start, int end,
			String orderBy, String order);

	public List<ReceiptMovementDTO> getReceiptMovementList(long receiptMovementId, long receiptId, String keyword,
			int start, int end, String orderBy, String order);

	public List<ReceiptMovementDTO> getAttachReceiptMovementList(long receiptId, String keyword, int start, int end,
			String orderBy, String order);

	public int getReceiptMovementListCount(long receiptMovementId, long userpostId, String keyword);

	public int getAttachReceiptMovementListCount(long receiptId, String keyword);

	public List<ReceiptListViewDto> getPutInFileList(String type,long userPostId, String keyword, int start, int end,
			String orderBy, String order);

	public int getPutInFileListCount(String type,long postId, String keyword);

	public List<ClosedReceiptDTO> getClosedReceiptList(long closedBy, String keyword, int start, int end,
			String orderBy, String order);

	public int getClosedReceiptListCount(long closedBy, String keyword);

}
