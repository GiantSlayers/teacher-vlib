package com.lukeRich.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BookID")
	private Integer BookId;
	
	public Integer getBookId() {
		return BookId;
	}

	public void setBookId(Integer bookId) {
		BookId = bookId;
	}

	@Column(nullable=false,name="ImageID")
	private Integer ImageId;
	
	@Column(nullable=false,name="TeacherID")
	private Integer TeacherId;
	
	@Column(nullable=false,name="AuthorFirstName")
	private String AuthorFirstName;
	
	@Column(nullable=false,name="AuthorLastName")
	private String AuthorLastName;
	
	@Column(nullable=false,name="Title")
	private String Title;


	/**
	 * @return the imageId
	 */
	public Integer getImageId() {
		return ImageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(Integer imageId) {
		ImageId = imageId;
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

	/**
	 * @return the authorFirstName
	 */
	public String getAuthorFirstName() {
		return AuthorFirstName;
	}

	/**
	 * @param authorFirstName the authorFirstName to set
	 */
	public void setAuthorFirstName(String authorFirstName) {
		AuthorFirstName = authorFirstName;
	}

	/**
	 * @return the authorLastName
	 */
	public String getAuthorLastName() {
		return AuthorLastName;
	}

	/**
	 * @param authorLastName the authorLastName to set
	 */
	public void setAuthorLastName(String authorLastName) {
		AuthorLastName = authorLastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

}