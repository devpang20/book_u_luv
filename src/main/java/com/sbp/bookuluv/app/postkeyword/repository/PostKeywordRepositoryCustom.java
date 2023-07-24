package com.sbp.bookuluv.app.postkeyword.repository;

import com.sbp.bookuluv.app.postkeyword.entity.PostKeyword;

import java.util.List;

public interface PostKeywordRepositoryCustom {
    List<PostKeyword> getQslAllByAuthorId(Long authorId);
}
