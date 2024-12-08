package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	// http://localhost:8083/api/posts
	
	@PostMapping
	public ResponseEntity<?> savePostDetails(@Valid @RequestBody PostDto postDto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		PostDto dto = postService.savePost(postDto);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePostDetails(@PathVariable long id) throws ResourceNotFoundException {
		
		postService.deletePost(id);
		
		return new ResponseEntity<>("Post is Deleted!!", HttpStatus.OK);
	}
}
