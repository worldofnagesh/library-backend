package com.library.project.model;

public class BooksDTO {
	
	private long bookId;
	private String bookName;
	private String authorName;
	private String dueDate;
	
	public BooksDTO(long bookId, String bookName, String authorName, String dueDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.dueDate = dueDate;
	}
	
	public BooksDTO() {
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
