package com.lukeRich.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {
	
	@Id
	@Column(name="StudentID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer StudentId;
	
	@Column(nullable=false,name="FirstName")
	private String FirstName;
	
	@Column(nullable=false,name="LastName")
	private String LastName;
	
	@Column(nullable=false,name="TeacherID")
	private Integer TeacherId;

	/**
	 * @return the id
	 */
	public Integer getStudentId() {
		return StudentId;
	}

	/**
	 * @param id the id to set
	 */
	public void setStudentId(Integer id) {
		this.StudentId = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the teacherId
	 */
	public Integer getTeacherId() {
		return TeacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(Integer teacherId) {
		TeacherId = teacherId;
	}

}

