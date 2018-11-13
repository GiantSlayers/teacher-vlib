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
	private Integer id;
	
	@Column(nullable=false)
	private Integer ImageId;
	
	@Column(nullable=false)
	private Integer TeacherId;
	
	@Column(nullable=false)
	private String AuthorFirstName;
	
	@Column(nullable=false)
	private String AuthorLastName;
	
	@Column(nullable=false)
	private String Title;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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