package com.bookapp.service;

 

import java.util.List;
import java.util.Optional;

 

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

 

public interface IBookService {
    List<Book> getAll();
    void addBook(Book book);
    void updateBookPrice(int bookId, double price);
    void deleteBook(int bookId);
    List<Book> getByAuthorContains(String author);
    List<Book> getByCategory(String category);
    List<Book> getByPriceLessThan(double price);
    List<Book> getByAuthorContainsAndCategory(String author, String category);
    Book getById(int bookId);
}