package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.mapper.BookRowMapper;
import com.spring.jdbc.model.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> getAllBooks() {
		
		String sql = "SELECT bookId,title,category FROM books";
		RowMapper<Book> rowMapper = new BookRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Book getBookById(int id) {
		
		String sql = "SELECT bookId,title,category FROM books WHERE bookId=?";
		RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
		Book book = jdbcTemplate.queryForObject(sql, rowMapper, id);
		
		return book;
	}

	@Override
	public void addBook(Book book) {
		
		String sql = "INSERT INTO books(bookId,title,category) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql,book.getBookId(),book.getTitle(),book.getCategory());
	}

	@Override
	public void updateBook(Book book) {
		
		String sql = "UPDATE books SET title=?, category=? WHERE bookId=?";
		jdbcTemplate.update(sql, book.getTitle(), book.getCategory(), book.getBookId());
		
	}

	@Override
	public void deleteBook(int id) {
		
		String sql = "DELETE FROM books WHERE bookId=?";
		jdbcTemplate.update(sql, id);
		
	}

	
	
}
