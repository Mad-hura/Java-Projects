package com.bookapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookDao {
	List<Book> findAll() ;

	void addBook(Book book) ;

	void updateBook(int bookId, double price) ;

	void deleteBook(int bookId) ;

	List<Book> getByAuthorContains(String author) throws BookNotFoundException;

	List<Book> getByCategory(String category) throws BookNotFoundException;

	List<Book> getByPriceLessThan(double price) throws BookNotFoundException;

	List<Book> getByAuthorContainsAndCategory(String author, String category)
			throws BookNotFoundException;

	Book getById(int bookId) throws BookNotFoundException;
}