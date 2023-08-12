package io.jetprocess.list.model;

import java.util.Date;

public class ReceiptListViewDto {

	private long receiptId;
	private String receiptNumber;
	private String subject;
	private String category;
	private Date createDate;
	private String remark;
	private String viewPdfUrl;
	private String nature;
	private boolean isRead;
	private long receiptMovementId;

	public ReceiptListViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiptListViewDto(long receiptId, String receiptNumber, String subject, String category, Date createDate,
			String remark, String viewPdfUrl, String nature, boolean isRead, long receiptMovementId) {
		super();
		this.receiptId = receiptId;
		this.receiptNumber = receiptNumber;
		this.subject = subject;
		this.category = category;
		this.createDate = createDate;
		this.remark = remark;
		this.viewPdfUrl = viewPdfUrl;
		this.nature = nature;
		this.isRead = isRead;
		this.receiptMovementId = receiptMovementId;
	}

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getViewPdfUrl() {
		return viewPdfUrl;
	}

	public void setViewPdfUrl(String viewPdfUrl) {
		this.viewPdfUrl = viewPdfUrl;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public long getReceiptMovementId() {
		return receiptMovementId;
	}

	public void setReceiptMovementId(long receiptMovementId) {
		this.receiptMovementId = receiptMovementId;
	}

	@Override
	public String toString() {
		return "ReceiptListViewDto [receiptId=" + receiptId + ", receiptNumber=" + receiptNumber + ", subject="
				+ subject + ", category=" + category + ", createDate=" + createDate + ", remark=" + remark
				+ ", viewPdfUrl=" + viewPdfUrl + ", nature=" + nature + ", isRead=" + isRead + ", receiptMovementId="
				+ receiptMovementId + "]";
	}

}
