package com.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.model.Book;

public class BookRowMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int intRow) throws SQLException {
		
		Book book = new Book();
		book.setBookId(rs.getInt("bookId"));
		book.setTitle(rs.getString("title"));
		book.setCategory(rs.getString("category"));
		
		return book;
	}

	
	
	
}
