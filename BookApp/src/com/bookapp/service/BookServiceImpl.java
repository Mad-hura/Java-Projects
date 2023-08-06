package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
         ArrayList<Book> booksByAuthor= new ArrayList<>();
         for (Book book : books) {
        	 if(book.getAuthor().equals(author)) {
        		 booksByAuthor.add(book);
        	 }
			
		}
		
		return booksByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
        ArrayList<Book> booksByCategory = new ArrayList<>();
        for (Book book : books) {
       	 if(book.getCategory().equals(category)) {
       		 booksByCategory.add(book);
         	 }
	        
        }
        return booksByCategory;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
        ArrayList<Book> getbyPrice = new ArrayList<>();
		for (Book book : books) {
       	 if(book.getPrice() < price){
       		 getbyPrice.add(book);	
	}
	}
		return getbyPrice;
	}
	@Override
	public List<Book> getByAuthorContainsandCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
        ArrayList<Book> booksByAythorandCategory = new ArrayList<>();
		for (Book book : books) {
			if((book.getAuthor().equals(author))&&(book.getCategory().equals(category))){
				
				booksByAythorandCategory.add(book);
				}
			}
	
		
		return booksByAythorandCategory ;
	}

	@Override
	public
	List<Book> getbyid(int bookId) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks();
        List<Book> getbyidbooks = new ArrayList<>();
		for (Book book : books) {
			if(book.getBookId().equals(bookId)) {
				getbyidbooks.add(book);
//				return Optional.of(book);
			}
		}
		return getbyidbooks;
	}

}
