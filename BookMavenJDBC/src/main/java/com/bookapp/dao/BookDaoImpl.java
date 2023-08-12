package com.bookapp.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookapp.model.Book;
//import com.bookapp.util.DbConnection;
import com.bookapp.util.Queries;

public class BookDaoImpl implements IBookDao {

	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYALL);) {
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setInt(1, book.getBookId());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getCategory());
			statement.setDouble(5, book.getPrice());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int bookId, double price) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEPRICEQUERY);) {
			statement.setDouble(1, price);
			statement.setInt(2, bookId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int bookId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
			statement.setDouble(1, bookId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getByAuthorContains(String author) {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAUTHOR);) {
			statement.setString(1, "%" + author + "%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getByCategory(String category) {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYGENRE);) {
			statement.setString(1, category);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYPRICELESSTHAN);) {
			statement.setDouble(1, price);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) {
		List<Book> books = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAUTHORANDGENRE);) {
			statement.setString(1, author);
			statement.setString(2, category);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getById(int bookId) {
		Book book = null;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYBOOKID);) {
			statement.setInt(1, bookId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				book = new Book();
				book.setBookId(result.getInt(1));
				book.setTitle(result.getString(2));
				book.setAuthor(result.getString(3));
				book.setCategory(result.getString(4));
				book.setPrice(result.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}