package com.siit.nationalgrupa3.jpaex.service;

import com.siit.nationalgrupa3.jpaex.entity.PostEntity;
import com.siit.nationalgrupa3.jpaex.entity.PostTagEntity;
import com.siit.nationalgrupa3.jpaex.mapper.PostMapper;
import com.siit.nationalgrupa3.jpaex.model.PostCreationRequest;
import com.siit.nationalgrupa3.jpaex.model.PostDto;
import com.siit.nationalgrupa3.jpaex.repository.PostRepository;
import com.siit.nationalgrupa3.jpaex.repository.TagRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final PostMapper postMapper;

    public List<PostDto> getAllPosts(){
        return postMapper.mapListEntityToListDto(postRepository.findAll());
    }

    public PostDto createPost(PostCreationRequest postCreationRequest){

        List<PostTagEntity> tags = new ArrayList<>();

        PostEntity postEntity = new PostEntity();

        // setam doar campurile care nu sunt alimentate automat, nu si id-ul si campurile de audit
        postEntity.setTitle(postCreationRequest.getTitle());

        // in request avem id-ul tag-ului si cantitatea de taguri de acel fel
        // pentru fiecare va trebui sa adaugam o intrare in post_tag, adica cate o lini in tabelul de legatura
        postCreationRequest.getTagsInfos()
                           .forEach(tagInfo -> tags.add(new PostTagEntity(postEntity, tagRepository.findById(tagInfo.getTagId()).get(), tagInfo.getQuantity())));

        postEntity.getTags().addAll(tags);

        return postMapper.mapEntityToDto(postRepository.save(postEntity));
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
}
