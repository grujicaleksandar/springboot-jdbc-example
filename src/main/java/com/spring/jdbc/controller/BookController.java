package com.spring.jdbc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.jdbc.model.Book;
import com.spring.jdbc.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/rest/books")
	public ResponseEntity<Book> getAllBooks(){
		
		List<Book> books = bookService.getAllBooks();
		
		return new ResponseEntity(books,HttpStatus.OK);
		
	}
	
	@GetMapping("/rest/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
		
		Book book  = bookService.getBookById(id);
		
		return new ResponseEntity(book,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/rest/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book,UriComponentsBuilder builder){
		
		bookService.addBook(book);
		
		 HttpHeaders headers = new HttpHeaders();
		 headers.setLocation(builder.path("/books/{id}").buildAndExpand(book.getBookId()).toUri());
		 
		 return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/rest/books/{id}")
	public ResponseEntity<Void> updateBookById(@PathVariable("id") Integer id,@RequestBody Book book){
		
		bookService.updateBook(book);
		
		return new ResponseEntity(book,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/rest/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") Integer id){
		
		bookService.deleteBook(id);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
