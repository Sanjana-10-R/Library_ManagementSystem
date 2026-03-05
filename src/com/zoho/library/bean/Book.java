package com.zoho.library.bean;

import java.util.ArrayList;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    private ArrayList<Integer> borrowedMembers = new ArrayList<>();

    public Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseCopy() {
        availableCopies--;
    }

    public void increaseCopy() {
        availableCopies++;
    }

    public ArrayList<Integer> getBorrowedMembers() {
        return borrowedMembers;
    }
}