package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Book;

public interface BookDao {

	List<Book> getAllBooks();
	Book getBookById(int id);
	void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
	
}
