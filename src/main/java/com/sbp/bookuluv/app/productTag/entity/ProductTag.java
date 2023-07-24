package com.sbp.bookuluv.app.productTag.entity;

import com.sbp.bookuluv.app.base.entity.BaseEntity;
import com.sbp.bookuluv.app.member.entity.Member;
import com.sbp.bookuluv.app.product.entity.Product;
import com.sbp.bookuluv.app.productKeyword.entity.ProductKeyword;
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
public class ProductTag extends BaseEntity {
    @ManyToOne
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne
    @ToString.Exclude
    private Member member;

    @ManyToOne
    @ToString.Exclude
    private ProductKeyword productKeyword;
}
