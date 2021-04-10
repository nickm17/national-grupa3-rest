package com.siit.nationalgrupa3.jpaex.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Entity
@Getter
@Setter
@Table(name = "post_tag")
public class PostTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tagId")
    private TagEntity tag;

    private int quantity;

    private PostTagEntity() {}

    // prin acest constructor realizam si relatia dintre post si tag cu tabelul de legatura
    public PostTagEntity(PostEntity postEntity, TagEntity tagEntity, int quantity) {
        this.post = postEntity;
        this.tag = tagEntity;
        this.quantity = quantity;
    }
}
