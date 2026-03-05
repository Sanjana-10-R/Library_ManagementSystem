package com.zoho.library.bean;

import java.time.LocalDate;

public class BorrowRecord {

    private int bookId;
    private int memberId;
    private LocalDate borrowDate;

    public BorrowRecord(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = LocalDate.now();
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}