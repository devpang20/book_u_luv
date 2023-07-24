package com.sbp.bookuluv.app.productTag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductTag is a Querydsl query type for ProductTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductTag extends EntityPathBase<ProductTag> {

    private static final long serialVersionUID = 913318899L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductTag productTag = new QProductTag("productTag");

    public final com.sbp.bookuluv.app.base.entity.QBaseEntity _super = new com.sbp.bookuluv.app.base.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final com.sbp.bookuluv.app.member.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final com.sbp.bookuluv.app.product.entity.QProduct product;

    public final com.sbp.bookuluv.app.productKeyword.entity.QProductKeyword productKeyword;

    public QProductTag(String variable) {
        this(ProductTag.class, forVariable(variable), INITS);
    }

    public QProductTag(Path<? extends ProductTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductTag(PathMetadata metadata, PathInits inits) {
        this(ProductTag.class, metadata, inits);
    }

    public QProductTag(Class<? extends ProductTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.sbp.bookuluv.app.member.entity.QMember(forProperty("member")) : null;
        this.product = inits.isInitialized("product") ? new com.sbp.bookuluv.app.product.entity.QProduct(forProperty("product"), inits.get("product")) : null;
        this.productKeyword = inits.isInitialized("productKeyword") ? new com.sbp.bookuluv.app.productKeyword.entity.QProductKeyword(forProperty("productKeyword")) : null;
    }

}

