package com.zoho.library.bean;

import java.util.ArrayList;

public class Member {

    private int memberId;
    private String name;

    private ArrayList<Integer> borrowedBooks = new ArrayList<>();
    private int totalBorrowed = 0;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getTotalBorrowed() {
        return totalBorrowed;
    }

    public void increaseBorrowCount() {
        totalBorrowed++;
    }
}