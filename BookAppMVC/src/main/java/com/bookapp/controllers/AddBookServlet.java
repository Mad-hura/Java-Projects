package com.bookapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		//get data from the form field
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setBookId(bookId);
		book.setPrice(price);
		//create a reference of IbookService
		bookService.addBook(book);
		request.setAttribute("message","book added successfully");
		
		//request.setAttribute("book", book);
		//request.setAttribute("message","have a great day");
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
