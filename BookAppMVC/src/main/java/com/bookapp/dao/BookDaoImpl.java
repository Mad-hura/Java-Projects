package com.bookapp.dao;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

 

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.Queries;

 

public class BookDaoImpl implements IBookDao {

 

    @Override
    public List<Book> findAll() throws SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYALL);) {
            ResultSet result = statement.executeQuery();
            List<Book> books = new ArrayList<Book>();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
                books.add(book);
            }
            return books;
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public void addBook(Book book) throws SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
            statement.setInt(1, book.getBookId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getCategory());
            statement.setDouble(5, book.getPrice());
            statement.execute();
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public void updateBook(int bookId, double price) throws SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.UPDATEPRICEQUERY);) {
            statement.setDouble(1, price);
            statement.setInt(2, bookId);
            statement.execute();
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public void deleteBook(int bookId) throws SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
            statement.setDouble(1, bookId);
            statement.execute();
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public List<Book> getByAuthorContains(String author) throws BookNotFoundException, SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAUTHOR);) {
            statement.setString(1, author);
            ResultSet result = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
                books.add(book);
            }
            if (!books.isEmpty())
                return books;
            throw new BookNotFoundException("Authors doesn't contain: " + author);
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException, SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYGENRE);) {
            statement.setString(1, category);
            ResultSet result = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
                books.add(book);
            }
            if (!books.isEmpty())
                return books;
            throw new BookNotFoundException("No " + category + " books");
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public List<Book> getByPriceLessThan(double price) throws BookNotFoundException, SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYPRICELESSTHAN);) {
            statement.setDouble(1, price);
            ResultSet result = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
                books.add(book);
            }
            if (!books.isEmpty())
                return books;
            throw new BookNotFoundException("No books under " + price + " rupees");
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public List<Book> getByAuthorContainsAndCategory(String author, String category)
            throws BookNotFoundException, SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAUTHORANDGENRE);) {
            statement.setString(1, author);
            statement.setString(2, category);
            ResultSet result = statement.executeQuery();
            List<Book> books = new LinkedList<>();
            while (result.next()) {
                Book book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
                books.add(book);
            }
            if (!books.isEmpty())
                return books;
            throw new BookNotFoundException(
                    "No books written by author with " + author + " in name and genre of " + category);
        } finally {
            DbConnection.closeConnection();
        }
    }

 

    @Override
    public Book getById(int bookId) throws BookNotFoundException, SQLException {
        try (Connection connection = DbConnection.openConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYBOOKID);) {
            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();
            Book book = null;
            while (result.next()) {
                book = new Book();
                book.setBookId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setCategory(result.getString(4));
                book.setPrice(result.getDouble(5));
            }
            if (book != null)
                return book;
            throw new BookNotFoundException("No book with id: " + bookId);
        } finally {
            DbConnection.closeConnection();
        }
    }

 

}
