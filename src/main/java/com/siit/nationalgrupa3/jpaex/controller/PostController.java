package com.siit.nationalgrupa3.jpaex.controller;

import com.siit.nationalgrupa3.jpaex.model.PostCreationRequest;
import com.siit.nationalgrupa3.jpaex.model.PostDto;
import com.siit.nationalgrupa3.jpaex.service.PostService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }


    /*
exemplu de request pentru a creea un post cu 2 taguri

     {
    "title": "post",
    "tagsInfos": [
        {
            "tagId": 1,
            "quantity": 7
        },
        {
            "tagId": 2,
            "quantity": 8
        }
    ]
}

     */

    @PostMapping
    public PostDto createPost(@RequestBody PostCreationRequest postCreationRequest){
        return postService.createPost(postCreationRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable(name = "postId") Long postId){
        postService.deletePost(postId);
    }
}
