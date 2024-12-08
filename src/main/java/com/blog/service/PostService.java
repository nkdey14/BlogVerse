package com.blog.service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;

public interface PostService {

	public PostDto savePost(PostDto postDto);

	public void deletePost(long id) throws ResourceNotFoundException;

}
