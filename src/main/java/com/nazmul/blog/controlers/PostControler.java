package com.nazmul.blog.controlers;

import com.nazmul.blog.dtos.PostDto;
import com.nazmul.blog.entities.Post;
import com.nazmul.blog.services.PostServices;
import com.nazmul.blog.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostControler {

    @Autowired
    private PostServices postServices;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> cratePost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        PostDto createPost = this.postServices.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
        List<PostDto> postDtos = this.postServices.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);

    }

    //    get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
        List<PostDto> postDtos = this.postServices.getPostsByUser(categoryId);
        return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
    }
    //get post by id

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable Integer postId){
        PostDto postDto = this.postServices.getPostById(postId);
        return  new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
    }

    //get all post
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> geAllPost(){
        List<PostDto> postDtos = this.postServices.geAllPost();
        return  new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
    }

    //delete a post by id
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postServices.deletePost(postId);
        return new ApiResponse("Category Deleted",true);
    }

    //update post
    @PutMapping("/posts/{postId}")
    public  ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPost = this.postServices.updatePost(postDto,postId);
        return  new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
    }




//    @GetMapping("/user/{userId)/posts")
//    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
//        PostDto getPost = this.postServices.getPostById(postId);
//        return ResponseEntity.ok(getPost);
//    }
}
