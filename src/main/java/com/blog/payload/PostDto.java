package com.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class PostDto {

	private long id;
	
	@NotEmpty
	@Size(min = 2, message = "Title should be atleast of 2 characters")
	private String title;
	
	@NotEmpty
	@Size(min = 4, message = "Description should be atleast of 4 characters")
	private String description;
	
	@NotEmpty
	@Size(min = 4, message = "Content should be atleast of 4 characters")
	private String content;
	
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
