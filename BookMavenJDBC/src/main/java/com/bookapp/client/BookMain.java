package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import javax.swing.border.TitledBorder;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookMain {

	public static void main(String[] args) {

		IBookService bookService = new BookServiceImpl();

		String author;
		String title;
		String category;
		int bookId;
		double price;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Library");
		try {
			while (true) {
				System.out.println("1.Search books by author\n2.Search books by category\n"
						+ "3.Search books by author and category\n4.Search books by bookId\n"
						+ "5.Search books by price\n6.Show all books\n7.Add book\n8.Delete book\n"
						+ "9.Update price\n10.Exit");
				System.out.println("Enter choice:");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter author name: ");
					author = scanner.nextLine();
					try {
						bookService.getByAuthorContains(author).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Enter category: ");
					category = scanner.nextLine();
					try {
						bookService.getByCategory(category).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 3:
					System.out.println("Enter author name: ");
					author = scanner.nextLine();
					System.out.println("Enter category: ");
					category = scanner.nextLine();
					try {
						bookService.getByAuthorContainsAndCategory(author, category).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Enter bookId: ");
					bookId = scanner.nextInt();
					try {
						System.out.println(bookService.getById(bookId));
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 5:
					System.out.println("Enter book price: ");
					price = scanner.nextDouble();
					try {
						bookService.getByPriceLessThan(price).forEach(System.out::println);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 6:
					List<Book> books = bookService.getAll();
					System.out.println("\nBooks available in Library");
					for (Book book : books) {
						System.out.println(book);
					}
					System.out.println();
					break;
				case 7:
					System.out.println("Enter book details");
					System.out.print("Title: ");
					title = scanner.nextLine();
					System.out.print("Author: ");
					author = scanner.nextLine();
					System.out.print("Category: ");
					category = scanner.nextLine();
					System.out.print("BookID: ");
					bookId = scanner.nextInt();
					System.out.print("Price: ");
					price = scanner.nextDouble();
					bookService.addBook(new Book(bookId, title, author, category, price));
					System.out.println();
					break;
				case 8:
					System.out.print("Enter BookID: ");
					bookId = scanner.nextInt();
					bookService.deleteBook(bookId);
					System.out.println();
					break;
				case 9:
					System.out.print("Enter BookID: ");
					bookId = scanner.nextInt();
					System.out.print("Enter new price: ");
					price = scanner.nextDouble();
					bookService.updateBookPrice(bookId, price);
					System.out.println();
					break;
				case 10:
					System.out.println("Exited");
					System.exit(0);
				default:
					System.out.println("Invalid choice");
					System.out.println();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}
