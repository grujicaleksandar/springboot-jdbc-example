package com.spring.jdbc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.dao.BookDao;
import com.spring.jdbc.model.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(int id) {
		
		return bookDao.getBookById(id);
	}

	@Override
	public void addBook(Book book) {
		
		bookDao.addBook(book);
		
	}

	@Override
	public void updateBook(Book book) {
		
		bookDao.updateBook(book);
		
	}

	@Override
	public void deleteBook(int id) {
		
		bookDao.deleteBook(id);
		
	}

}
