package com.sbp.bookuluv.app.postkeyword.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostKeyword is a Querydsl query type for PostKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostKeyword extends EntityPathBase<PostKeyword> {

    private static final long serialVersionUID = -1101906941L;

    public static final QPostKeyword postKeyword = new QPostKeyword("postKeyword");

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

    public QPostKeyword(String variable) {
        super(PostKeyword.class, forVariable(variable));
    }

    public QPostKeyword(Path<? extends PostKeyword> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostKeyword(PathMetadata metadata) {
        super(PostKeyword.class, metadata);
    }

}

