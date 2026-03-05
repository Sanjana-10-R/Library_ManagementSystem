Library Management System 

This project is a console-based Library Management System developed in Java using Object-Oriented Programming (OOP) concepts.
The system performs basic library operations such as adding books, registering members, borrowing and returning books, searching books, and generating reports.

The application runs entirely in memory and does not use any database or file system.

Features

Add Book

Add a new book to the library.

Each book has:

Book ID

Title

Author

Number of Copies

Register Member

Register a new library member.

Each member has:

Member ID

Member Name

Borrow Book

A member can borrow maximum 3 books at a time.

Book can be borrowed only if copies are available.

Borrow date is recorded.

Return Book

Book can be returned by the member.

Fine is calculated if the book is overdue.

Due period: 14 days

Fine: Rs.2 per day

Search Book

Search books using:

Title

Author

Supports partial keyword matching.

Member Report

Displays all books currently borrowed by a member.

Shows:

Borrow Date

Due Date

Book Report

Displays availability of a book.

Shows which members currently borrowed it.

Technologies Used

Java

Eclipse IDE

OOP Concepts

Collections (ArrayList, HashMap)

Exception Handling

LocalDate (Java Time API)

<img width="743" height="808" alt="Screenshot 2026-03-05 221410" src="https://github.com/user-attachments/assets/87372c01-8be0-42ef-a0b3-6b75f714ca6b" />

Top Borrowers

Displays members sorted by total number of books borrowed (descending).

<img width="743" height="808" alt="Screenshot 2026-03-05 221410" src="https://github.com/user-attachments/assets/87372c01-8be0-42ef-a0b3-6b75f714ca6b" />

