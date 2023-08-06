package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	//void addBook(Book book);
	List<Book> getAll();
	List<Book> getByAuthorContains(String author) throws BookNotFoundException;
	List<Book> getByCategory(String category) throws BookNotFoundException;
	List<Book> getByPriceLessThan(double price) throws BookNotFoundException;
	List<Book> getByAuthorContainsandCategory(String author,String category) throws BookNotFoundException;
    List<Book> getbyid(int bookId) throws BookNotFoundException;
}
