package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;
import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	IBookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getAll() {
		try {
			return bookDao.findAll();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void addBook(Book book) {
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateBookPrice(int bookId, double price) {
		try {
			bookDao.updateBook(bookId, price);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteBook(int bookId) {
		try {
			bookDao.deleteBook(bookId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Book> getByAuthorContains(String author) {
		try {
			return bookDao.getByAuthorContains(author);
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Book> getByCategory(String category) {
		try {
			return bookDao.getByCategory(category);
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) {
		try {
			return bookDao.getByPriceLessThan(price);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) {
		try {
			return bookDao.getByAuthorContainsAndCategory(author, category);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Book getById(int bookId) {
		try {
			return bookDao.getById(bookId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}