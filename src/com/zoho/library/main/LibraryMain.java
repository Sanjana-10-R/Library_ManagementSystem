package com.zoho.library.main;

import java.util.Scanner;

import com.zoho.library.service.LibraryService;
import com.zoho.library.util.LibraryException;

public class LibraryMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LibraryService service = new LibraryService();

		int choice;

		do {

			System.out.println("\n------ Library Menu ------");
			System.out.println("1. Add Book");
			System.out.println("2. Register Member");
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book");
			System.out.println("5. Search Book");
			System.out.println("6. Member Report");
			System.out.println("7. Book Report");
			System.out.println("8. Top Borrowers");
			System.out.println("9. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			try {

				switch (choice) {

				case 1:
					System.out.print("Enter Book ID: ");
					int id = sc.nextInt();

					System.out.print("Enter Title: ");
					String title = sc.next();

					System.out.print("Enter Author: ");
					String author = sc.next();

					System.out.print("Enter Copies: ");
					int copies = sc.nextInt();

					service.addBook(id, title, author, copies);
					break;

				case 2:
					System.out.print("Enter Member ID: ");
					int mid = sc.nextInt();

					System.out.print("Enter Member Name: ");
					String name = sc.next();

					service.registerMember(mid, name);
					break;

				case 3:
					System.out.print("Enter Book ID: ");
					int bId = sc.nextInt();

					System.out.print("Enter Member ID: ");
					int mId = sc.nextInt();

					service.borrowBook(bId, mId);
					break;

				case 4:
					System.out.print("Enter Book ID: ");
					int rbId = sc.nextInt();

					System.out.print("Enter Member ID: ");
					int rmId = sc.nextInt();

					service.returnBook(rbId, rmId);
					break;

				case 5:
					System.out.print("Enter title/author keyword: ");
					String key = sc.next();

					service.searchBook(key);
					break;

				case 6:
					System.out.print("Enter Member ID: ");
					int memId = sc.nextInt();

					service.memberReport(memId);
					break;

				case 7:
					System.out.print("Enter Book ID: ");
					int bookId = sc.nextInt();

					service.bookReport(bookId);
					break;

				case 8:
					service.topBorrowers();
					break;

				case 9:
					System.out.println("Exiting Library System...");
					break;

				default:
					System.out.println("Invalid choice");

				}

			} catch (LibraryException e) {
				System.out.println(e.getMessage());
			}

		} while (choice != 9);

		sc.close();
	}
}