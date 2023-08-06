package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
        List<Book> books = BookDetails.showBooks();
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
         List<Book> books = BookDetails.showBooks();
         List<Book> booksByAuthor=books.stream()
 				.filter((book)->book.getAuthor().contains(author))
 				.collect(Collectors.toList());
 		if(booksByAuthor.size()==0)
 			throw new BookNotFoundException("No books found with given author");
		return booksByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
		List<Book> booksByCategory=books.stream()
				.filter((book)->book.getCategory().equals(category))
				.collect(Collectors.toList());
		if(booksByCategory.size()==0)
			throw new BookNotFoundException("No books found with given category");
        return booksByCategory;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
		List<Book>  booksbyPrice=books.stream()
				.filter((book)->book.getPrice()<price)
				.collect(Collectors.toList());
		if(booksbyPrice.size()==0)
			throw new BookNotFoundException("No books found with given price");
		return booksbyPrice;
	}
	@Override
	public List<Book> getByAuthorContainsandCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
		List<Book> booksByAythorandCategory=books.stream()
				.filter((book)->book.getCategory().equals(category))
				.filter((book)->book.getAuthor().contains(author))
				.collect(Collectors.toList());
		if(booksByAythorandCategory.size()==0)
			throw new BookNotFoundException("No books found with given author and category");
		return booksByAythorandCategory ;
	}

	@Override
	public
	List<Book> getbyid(int bookId) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
		List<Book> booksById=books.stream()
				.filter((book)->book.getBookId().equals(bookId))
				.collect(Collectors.toList());
		if(booksById.size()==0)
			throw new BookNotFoundException("No books found with given Id");
		return booksById;
		
		
	}

}
