package com.sbp.bookuluv.app.post.entity;

import com.sbp.bookuluv.app.base.entity.BaseEntity;
import com.sbp.bookuluv.app.member.entity.Member;
import com.sbp.bookuluv.app.postTag.entity.PostTag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
public class Post extends BaseEntity {

    private String subject;

    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "LONGTEXT")
    private String contentHtml;

    @ManyToOne(fetch = LAZY)
    private Member author;

    public String getForPrintContentHtml() {
        return contentHtml.replaceAll("toastui-editor-ww-code-block-highlighting", "");
    }

    public String getExtra_inputValue_hashTagContents() {
        Map<String, Object> extra = getExtra();

        if (extra.containsKey("postTags") == false) {
            return "";
        }

        List<PostTag> postTags = (List<PostTag>) extra.get("postTags");

        if (postTags.isEmpty()) {
            return "";
        }

        return postTags
                .stream()
                .map(postTag -> "#" + postTag.getPostKeyword().getContent())
                .sorted()
                .collect(Collectors.joining(" "));
    }

    public String getExtra_postTagLinks() {
        Map<String, Object> extra = getExtra();

        if (extra.containsKey("postTags") == false) {
            return "";
        }

        List<PostTag> postTags = (List<PostTag>) extra.get("postTags");

        if (postTags.isEmpty()) {
            return "";
        }

        return postTags
                .stream()
                .map(postTag -> {
                    String text = "#" + postTag.getPostKeyword().getContent();

                    return """
                            <a href="%s" class="text-link">%s</a>
                            """
                            .stripIndent()
                            .formatted(postTag.getPostKeyword().getListUrl(), text);
                })
                .sorted()
                .collect(Collectors.joining(" "));
    }

    public String getJdenticon() {
        return "post__" + getId();
    }
}
