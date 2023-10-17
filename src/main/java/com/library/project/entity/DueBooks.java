package com.library.project.entity;



import jakarta.persistence.*;



@Entity

@Table(name="DUEBOOKS")

public class DueBooks {

	public DueBooks() {
        super();
  }

  public DueBooks(long bookId, long id, String bookName, String dueDate) {
        super();
        this.bookId = bookId;
        this.id = id;
        this.bookName = bookName;
        this.dueDate = dueDate;
  }
  
  
public long getBookId() {
	return bookId;
}

public void setBookId(long bookId) {
	this.bookId = bookId;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
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




@Column(name="bookId")
  @Id
  private long bookId;
  
  @Column(name = "id")
private long id;

  @Column(name="bookName")
  private String bookName;

  @Column(name="dueDate")
  private String dueDate;

  public Cart orElseThrow(Object object) {
        return null;
  }
		

}
