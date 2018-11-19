package com.lukeRich.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Period {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	private Date checkoutDate;

	private Date dueBack;
	
	@OneToOne
	@JoinColumn(name="studentId")
	private Student student;
	
	@OneToOne
	@JoinColumn(name="bookId")
	private Book book;
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueBack() {
		return dueBack;
	}

	public void setDueBack(Date dueBack) {
		this.dueBack = dueBack;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	
	
}
