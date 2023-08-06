package com.bookapp.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookMain {
	public static void main(String[] args) {
		IBookService bookservice = new BookServiceImpl();
		List<Book> books = new ArrayList<>();

		books = bookservice.getAll();
		
		for(Book book : books) {
			System.out.println(book);
			System.out.println();
		}

		try {
			books = bookservice.getByAuthorContains("John David");
			System.out.println("Books by a particular author:");
			System.out.println(books);

			books = bookservice.getByAuthorContainsandCategory("John David", "Tech");
			System.out.println("Books by particular author and category:");
			System.out.println(books);

			books = bookservice.getByCategory("Tech");
			System.out.println("Books by a category:");
			System.out.println(books);

			books = bookservice.getByPriceLessThan(500);
			System.out.println("Prices less:");
			System.out.println(books);

			List<Book> book = bookservice.getbyid(2);
			System.out.println("Books by a Id:");
			System.out.println(book);
			
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
