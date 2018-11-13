package com.lukeRich.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
	
	private Integer studentId;
	
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
}
