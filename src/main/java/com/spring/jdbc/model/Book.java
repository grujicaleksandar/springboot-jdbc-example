package com.spring.jdbc.model;

public class Book {

	private int bookId;
	
	private String title;
	
	private String category;

	public Book() {
		super();
	}

	public Book(int bookId, String title, String category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.category = category;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", category=" + category + "]";
	}
	
	
	
}
