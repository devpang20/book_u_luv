package com.sbp.bookuluv.app.productKeyword.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductKeyword is a Querydsl query type for ProductKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductKeyword extends EntityPathBase<ProductKeyword> {

    private static final long serialVersionUID = -215112111L;

    public static final QProductKeyword productKeyword = new QProductKeyword("productKeyword");

    public final com.sbp.bookuluv.app.base.entity.QBaseEntity _super = new com.sbp.bookuluv.app.base.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> extra_postTagsCount = createNumber("extra_postTagsCount", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SimplePath<Object> listUrl = createSimple("listUrl", Object.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public QProductKeyword(String variable) {
        super(ProductKeyword.class, forVariable(variable));
    }

    public QProductKeyword(Path<? extends ProductKeyword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductKeyword(PathMetadata metadata) {
        super(ProductKeyword.class, metadata);
    }

}

