package com.library.project.model;



public class DueBooksDTO {

	private long id;

	private long bookId;

	private String bookName;

	private String dueDate;

	

	public long getId() {

		return id;

	}

	public void setId(long id) {

		this.id = id;

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

	public String getDueDate() {

		return dueDate;

	}

	public void setDueDate(String dueDate) {

		this.dueDate = dueDate;

	}



}