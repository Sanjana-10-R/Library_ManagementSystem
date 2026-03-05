package com.zoho.library.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import com.zoho.library.bean.Book;
import com.zoho.library.bean.Member;
import com.zoho.library.bean.BorrowRecord;
import com.zoho.library.util.LibraryException;

public class LibraryService {

	ArrayList<Book> books = new ArrayList<>();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<BorrowRecord> records = new ArrayList<>();

	public void addBook(int id,String title,String author,int copies) throws LibraryException{

		for(Book b:books)
			if(b.getBookId()==id)
				throw new LibraryException("Book ID already exists");

		books.add(new Book(id,title,author,copies));
		System.out.println("Book added");
	}

	
	public void registerMember(int id,String name) throws LibraryException{

		for(Member m:members)
			if(m.getMemberId()==id)
				throw new LibraryException("Member ID already exists");

		members.add(new Member(id,name));
		System.out.println("Member registered");
	}

	
	private Book findBook(int id){
		for(Book b:books)
			if(b.getBookId()==id)
				return b;
		return null;
	}

	private Member findMember(int id){
		for(Member m:members)
			if(m.getMemberId()==id)
				return m;
		return null;
	}

	
	public void borrowBook(int bookId,int memberId) throws LibraryException{

		Book book=findBook(bookId);
		Member mem=findMember(memberId);

		if(book==null) throw new LibraryException("Book not found");
		if(mem==null) throw new LibraryException("Member not found");

		if(mem.getBorrowedBooks().size()>=3)
			throw new LibraryException("Max 3 books allowed");

		if(mem.getBorrowedBooks().contains(bookId))
			throw new LibraryException("Book already borrowed");

		if(book.getAvailableCopies()==0)
			throw new LibraryException("No copies available");

		book.decreaseCopy();
		book.getBorrowedMembers().add(memberId);

		mem.getBorrowedBooks().add(bookId);
		mem.increaseBorrowCount();

		records.add(new BorrowRecord(bookId,memberId));

		System.out.println("Book borrowed");
	}

	// return book
	public void returnBook(int bookId,int memberId) throws LibraryException{

		Book book=findBook(bookId);
		Member mem=findMember(memberId);

		if(book==null || mem==null)
			throw new LibraryException("Book or Member not found");

		BorrowRecord rec=null;

		for(BorrowRecord r:records)
			if(r.getBookId()==bookId && r.getMemberId()==memberId)
				rec=r;

		if(rec==null)
			throw new LibraryException("Record not found");

		long days=ChronoUnit.DAYS.between(rec.getBorrowDate(),LocalDate.now());

		if(days>14){
			long fine=(days-14)*2;
			System.out.println("Fine Rs."+fine);
		}

		book.increaseCopy();
		mem.getBorrowedBooks().remove(Integer.valueOf(bookId));
		book.getBorrowedMembers().remove(Integer.valueOf(memberId));

		records.remove(rec);

		System.out.println("Book returned");
	}

	
	public void searchBook(String key){

		for(Book b:books){

			if(b.getTitle().toLowerCase().contains(key.toLowerCase()) ||
			   b.getAuthor().toLowerCase().contains(key.toLowerCase()))

				System.out.println(b.getBookId()+" "+b.getTitle()+" "+b.getAuthor());
		}
	}

	
	public void memberReport(int id) throws LibraryException{

		Member m=findMember(id);

		if(m==null) throw new LibraryException("Member not found");

		for(BorrowRecord r:records)
			if(r.getMemberId()==id){
				System.out.println("Book ID: "+r.getBookId());
				System.out.println("Borrow Date: "+r.getBorrowDate());
				System.out.println("Due Date: "+r.getBorrowDate().plusDays(14));
				System.out.println();
			}
	}

	
	public void bookReport(int id) throws LibraryException{

		Book b=findBook(id);

		if(b==null) throw new LibraryException("Book not found");

		System.out.println("Available: "+b.getAvailableCopies());
		System.out.println("Borrowed by:");

		for(Integer m:b.getBorrowedMembers())
			System.out.println(m);
	}

	
	public void topBorrowers(){

		Collections.sort(members,(a,b)->b.getTotalBorrowed()-a.getTotalBorrowed());

		for(Member m:members)
			System.out.println(m.getMemberId()+" "+m.getName()+" "+m.getTotalBorrowed());
	}
}