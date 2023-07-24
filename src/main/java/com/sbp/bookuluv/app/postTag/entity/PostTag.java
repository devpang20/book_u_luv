package com.sbp.bookuluv.app.postTag.entity;

import com.sbp.bookuluv.app.base.entity.BaseEntity;
import com.sbp.bookuluv.app.member.entity.Member;
import com.sbp.bookuluv.app.post.entity.Post;
import com.sbp.bookuluv.app.postkeyword.entity.PostKeyword;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class PostTag extends BaseEntity {
    @ManyToOne
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @ManyToOne
    @ToString.Exclude
    private Member member;

    @ManyToOne
    @ToString.Exclude
    private PostKeyword postKeyword;
}
