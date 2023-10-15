package com.library.project.entity;

import jakarta.persistence.*;


@Entity
@Table(name="BOOKS")
public class Books {
	
	@Column(name="bookId")
	@Id
	private long bookId;

	@Column(name="bookName")
	private String bookName;

	@Column(name="authorName")
	private String authorName;

	@Column(name="dueDate")
	private String dueDate;

	public Books(long bookId, String bookName, String authorName, String dueDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.dueDate = dueDate;
	}
	
	public Books() {
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
