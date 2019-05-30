package com.adobe.prj.entity;

import com.adobe.prj.util.Column;
import com.adobe.prj.util.Table;

@Table(name="books")
public class Book {
    private int bookId;
    private String bookTitle;

    @Column(name="book_id", type="NUMERIC(10)")
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    @Column(name="title")
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

}
