package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.PostDto;
import com.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	// http://localhost:8083/api/posts
	
	@PostMapping
	public ResponseEntity<PostDto> savePostDetails(@RequestBody PostDto postDto) {
		
		postService.savePost(postDto);
		
		return new ResponseEntity<>(postDto, HttpStatus.CREATED);
	}
}
