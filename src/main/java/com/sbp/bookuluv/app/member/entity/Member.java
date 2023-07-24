package com.sbp.bookuluv.app.member.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sbp.bookuluv.app.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private boolean emailVerified;
    private long restCash;
    private String nickname;

    public String getName() {
        if (nickname != null) {
            return nickname;
        }

        return username;
    }

    public Member(long id) {
        super(id);
    }

    public String getJdenticon() {
        return "member__" + getId();
    }

    public List<GrantedAuthority> genAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("MEMBER"));

        // 닉네임을 가지고 있다면 작가의 권한을 가진다.
        if (StringUtils.hasText(nickname)) {
            authorities.add(new SimpleGrantedAuthority("AUTHOR"));
        }

        return authorities;
    }
}
