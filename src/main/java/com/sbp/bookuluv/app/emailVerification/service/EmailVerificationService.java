package com.sbp.bookuluv.app.emailVerification.service;

import com.sbp.bookuluv.app.AppConfig;
import com.sbp.bookuluv.app.attr.service.AttrService;
import com.sbp.bookuluv.app.base.dto.RsData;
import com.sbp.bookuluv.app.email.service.EmailService;
import com.sbp.bookuluv.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailVerificationService {
    private final EmailService emailService;
    private final AttrService attrService;

    public RsData<Long> send(Member member) {
        String email = member.getEmail(); // member에서 Email 정보를 가져옴
        String title = "[%s 이메일인증] 안녕하세요 %s님. 링크를 클릭하여 회원가입을 완료해주세요.".formatted(AppConfig.getSiteName(), member.getName());
        // 인증용 이메일 발송내용(첫 번째 %s에는 사이트명(book_u_luv)을 기재하고, 두 번째 %s에는 닉네임이 존재할 경우 닉네임을 표시하지만 그렇지 않을경우 유저ID를 표시함.)
        String url = genEmailVerificationUrl(member);

        RsData<Long> sendEmailRs = emailService.sendEmail(email, title, url);
        // Email 발송내용(email, title, url)을 sendEmailRs 변수에 담음.

        return sendEmailRs; // Email 발송내용이 담긴 sendEmailRs을 메서드에서 리턴
    }

    public String genEmailVerificationUrl(Member member) {
        return genEmailVerificationUrl(member.getId());
    }

    public String genEmailVerificationUrl(long memberId) {
        String code = genEmailVerificationCode(memberId);

        return AppConfig.getSiteBaseUrl() + "/emailVerification/verify?memberId=%d&code=%s".formatted(memberId, code);
    }

    public String genEmailVerificationCode(long memberId) {
        String code = UUID.randomUUID().toString();
        attrService.set("member__%d__extra__emailVerificationCode".formatted(memberId), code, LocalDateTime.now().plusSeconds(60 * 60 * 1));

        return code;
    }

    public RsData verifyVerificationCode(long memberId, String code) {
        String foundCode = attrService.get("member__%d__extra__emailVerificationCode".formatted(memberId), "");

        if (foundCode.equals(code) == false) {
            return RsData.of("F-1", "만료되었거나 유효하지 않은 코드입니다.");
        }

        return RsData.of("S-1", "인증된 코드 입니다.");
    }

    public String findEmailVerificationCode(long memberId) {
        return attrService.get("member__%d__extra__emailVerificationCode".formatted(memberId), "");
    }
}
