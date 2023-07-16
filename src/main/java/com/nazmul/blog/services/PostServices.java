package com.nazmul.blog.services;

import com.nazmul.blog.dtos.PostDto;
import com.nazmul.blog.entities.Post;

import java.util.List;

public interface PostServices {
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    PostDto updatePost(PostDto postDto,Integer postId);

    void deletePost(Integer postId);

    List<PostDto> geAllPost();

    PostDto getPostById(Integer postId);

//    get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

//    get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);
}
