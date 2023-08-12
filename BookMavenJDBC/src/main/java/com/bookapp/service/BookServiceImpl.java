package com.bookapp.service;

import java.util.List;
import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	IBookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getAll()  {
		return bookDao.findAll();
	}

	@Override
	public void addBook(Book book)  {
		bookDao.addBook(book);
	}

	@Override
	public void updateBookPrice(int bookId, double price)  {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId)  {
		bookDao.deleteBook(bookId);
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> books = bookDao.getByAuthorContains(author);
		if (books.isEmpty())
			throw new BookNotFoundException("Books not found by author");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = bookDao.getByCategory(category);
		if (books.isEmpty())
			throw new BookNotFoundException("Books not found by category");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = bookDao.getByPriceLessThan(price);
		if (books.isEmpty())
			throw new BookNotFoundException("Books not found below the given price");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category)
			throws BookNotFoundException{
		List<Book> books = bookDao.getByAuthorContainsAndCategory(author, category);
		if (books.isEmpty())
			throw new BookNotFoundException("Books not found by author and category");
		return books.stream().sorted((o1, o2) -> o1.compareTo(o2)).toList();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		Book book = bookDao.getById(bookId);
		if (book == null)
			throw new BookNotFoundException("Book not found by ID");
		return book;
	}

}