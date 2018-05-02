package com.spring.jdbc.service;

import java.util.List;

import com.spring.jdbc.model.Book;

public interface BookService {

	List<Book> getAllBooks();
	Book getBookById(int id);
	void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
	
}
