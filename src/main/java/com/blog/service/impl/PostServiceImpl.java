package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Post;
import com.blog.payload.PostDto;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public PostDto savePost(PostDto postDto) {
		
		Post post = new Post();
		
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post savedPost = postRepo.save(post);
		
		postDto.setId(savedPost.getId());
		postDto.setTitle(savedPost.getTitle());
		postDto.setDescription(savedPost.getDescription());
		postDto.setContent(savedPost.getContent());
		postDto.setMessage("Post is Saved Successfully!!");
		
		return postDto;
		
	}

}
