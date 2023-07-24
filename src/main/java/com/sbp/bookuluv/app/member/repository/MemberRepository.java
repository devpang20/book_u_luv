package com.sbp.bookuluv.app.member.repository;

import com.sbp.bookuluv.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByUsernameAndEmail(String username, String email);

    Optional<Member> findByNickname(String nickname);
}
