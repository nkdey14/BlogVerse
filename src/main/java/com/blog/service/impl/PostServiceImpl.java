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
		
//		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post savedPost = postRepo.save(post);
		
		PostDto dto = new PostDto();
		
		dto.setId(savedPost.getId());
		dto.setTitle(savedPost.getTitle());
		dto.setDescription(savedPost.getDescription());
		dto.setContent(savedPost.getContent());
		dto.setMessage("Post is Saved Successfully!!");
		
		return dto;
		
	}

}
