package com.sbp.bookuluv.app.product.entity;

import com.sbp.bookuluv.app.base.entity.BaseEntity;
import com.sbp.bookuluv.app.member.entity.Member;
import com.sbp.bookuluv.app.postkeyword.entity.PostKeyword;
import com.sbp.bookuluv.app.productTag.entity.ProductTag;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Product extends BaseEntity {
    @ManyToOne(fetch = LAZY)
    private Member author;
    @ManyToOne(fetch = LAZY)
    private PostKeyword postKeyword;
    private String subject;
    private int price;

    public Product(long id) {
        super(id);
    }

    public int getSalePrice() {
        return getPrice();
    }

    public int getWholesalePrice() {
        return (int) Math.ceil(getPrice() * 0.4);
    }

    public boolean isOrderable() {
        return true;
    }

    public String getJdenticon() {
        return "product__" + getId();
    }

    public String getExtra_inputValue_hashTagContents() {
        Map<String, Object> extra = getExtra();

        if (extra.containsKey("productTags") == false) {
            return "";
        }

        List<ProductTag> productTags = (List<ProductTag>) extra.get("productTags");

        if (productTags.isEmpty()) {
            return "";
        }

        return productTags
                .stream()
                .map(productTag -> "#" + productTag.getProductKeyword().getContent())
                .sorted()
                .collect(Collectors.joining(" "));
    }

    public String getExtra_productTagLinks() {
        Map<String, Object> extra = getExtra();

        if (extra.containsKey("productTags") == false) {
            return "";
        }

        List<ProductTag> productTags = (List<ProductTag>) extra.get("productTags");

        if (productTags.isEmpty()) {
            return "";
        }

        return productTags
                .stream()
                .map(productTag -> {
                    String text = "#" + productTag.getProductKeyword().getContent();

                    return """
                            <a href="%s" class="text-link">%s</a>
                            """
                            .stripIndent()
                            .formatted(productTag.getProductKeyword().getListUrl(), text);
                })
                .sorted()
                .collect(Collectors.joining(" "));
    }
}
