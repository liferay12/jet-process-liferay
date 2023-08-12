create index IX_361685E6 on JET_PROCESS_DocFile (groupId);
create index IX_55E4699F on JET_PROCESS_DocFile (nature[$COLUMN_LENGTH:75$]);
create index IX_1C31438 on JET_PROCESS_DocFile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2AF348BA on JET_PROCESS_DocFile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B1835E53 on JET_PROCESS_DocumentNoteMap (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EE55D95 on JET_PROCESS_DocumentNoteMap (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_72C2F631 on JET_PROCESS_FileCloseDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A84554F3 on JET_PROCESS_FileCloseDetail (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_AFFC7998 on JET_PROCESS_FileCorr (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1106861A on JET_PROCESS_FileCorr (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_412A91BF on JET_PROCESS_FileCorrReceipt (docFileId);
create index IX_DA6865FA on JET_PROCESS_FileCorrReceipt (fileMovementId);
create index IX_97E903AF on JET_PROCESS_FileCorrReceipt (receiptId, receiptMovementId);
create index IX_936BAF34 on JET_PROCESS_FileCorrReceipt (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_82BE72B6 on JET_PROCESS_FileCorrReceipt (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4C325652 on JET_PROCESS_FileMovement (fileId);
create index IX_9111021B on JET_PROCESS_FileMovement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4B99535D on JET_PROCESS_FileMovement (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F80E82B6 on JET_PROCESS_FileNote (fileId, noteId);
create index IX_8E0C3424 on JET_PROCESS_FileNote (fileMovementId);
create index IX_782C064B on JET_PROCESS_FileNote (noteId);
create index IX_ED549ADE on JET_PROCESS_FileNote (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_366240E0 on JET_PROCESS_FileNote (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B57C66C1 on JET_PROCESS_Note (createdBy);
create index IX_7258B042 on JET_PROCESS_Note (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B7745F44 on JET_PROCESS_Note (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_52EB1B99 on JET_PROCESS_NoteDocMovement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4F87B45B on JET_PROCESS_NoteDocMovement (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FDF771FD on JET_PROCESS_NoteDocument (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_ADBE53BF on JET_PROCESS_NoteDocument (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_46204F21 on JET_PROCESS_Receipt (groupId, receiptId);
create index IX_6CF2599C on JET_PROCESS_Receipt (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_833C971E on JET_PROCESS_Receipt (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9D6C4761 on JET_PROCESS_ReceiptCloseDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AE713223 on JET_PROCESS_ReceiptCloseDetail (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B7A377F6 on JET_PROCESS_ReceiptMovement (fileInMovementId);
create index IX_72143F4C on JET_PROCESS_ReceiptMovement (receiptId);
create index IX_F45CBEEB on JET_PROCESS_ReceiptMovement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_494E042D on JET_PROCESS_ReceiptMovement (uuid_[$COLUMN_LENGTH:75$], groupId);