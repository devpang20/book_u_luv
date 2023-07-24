package com.sbp.bookuluv.app.product.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1996324963L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.sbp.bookuluv.app.base.entity.QBaseEntity _super = new com.sbp.bookuluv.app.base.entity.QBaseEntity(this);

    public final com.sbp.bookuluv.app.member.entity.QMember author;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final com.sbp.bookuluv.app.postkeyword.entity.QPostKeyword postKeyword;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath subject = createString("subject");

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new com.sbp.bookuluv.app.member.entity.QMember(forProperty("author")) : null;
        this.postKeyword = inits.isInitialized("postKeyword") ? new com.sbp.bookuluv.app.postkeyword.entity.QPostKeyword(forProperty("postKeyword")) : null;
    }

}

