package com.sbp.bookuluv.app.email.service;

import com.sbp.bookuluv.app.AppConfig;
import com.sbp.bookuluv.app.base.dto.RsData;
import com.sbp.bookuluv.app.email.entity.SendEmailLog;
import com.sbp.bookuluv.app.email.repository.SendEmailLogRepository;
import com.sbp.bookuluv.app.emailSender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmailService {
    private final SendEmailLogRepository emailLogRepository;
    private final EmailSenderService emailSenderService;

    @Transactional
    public RsData sendEmail(String email, String subject, String body) { // RsData<Long>타입의 send메서드에서 세팅한 이메일 발송정보대로 이메일을 발송하는 메서드
        SendEmailLog sendEmailLog = SendEmailLog
                .builder() // 이메일 발송을 위한 빌드시작
                .email(email) // 발송할 이메일 정보
                .subject(subject) // 발송할 이메일 제목
                .body(body) // 발송할 이메일 내용
                .build(); // 이메일 발송을 위한 빌드 완료

        emailLogRepository.save(sendEmailLog); // 이메일을 발송한 내용(기록)을 데이터베이스에 저장

        RsData trySendRs = trySend(email, subject, body); // 이메일 발송자 정보와 제목, 내용을 담은 정보를 trySendRs에 초기화

        setCompleted(sendEmailLog, trySendRs.getResultCode(), trySendRs.getMsg());
        // 이메일 발송정보기록(sendEmailLog)과 trySendRs에 저장된 ResultCode와 Msg를 가져와서 Completed에 세팅

        return RsData.of("S-1", "메일이 발송되었습니다.", sendEmailLog.getId()); // 세팅된 결과를 RsData로 넘겨주고 Email 발송 완료처리.
    }

    private RsData trySend(String email, String title, String body) {
        if (AppConfig.isNotProd() && email.equals("insung5189@email@gmail.com") == false) {
            return RsData.of("S-0", "메일이 발송되었습니다.");
        }

        try {
            emailSenderService.send(email, "insung5189@email@gmail.com", title, body);

            return RsData.of("S-1", "메일이 발송되었습니다.");
        } catch (MailException e) {
            return RsData.of("F-1", e.getMessage());
        }
    }

    @Transactional
    public void setCompleted(SendEmailLog sendEmailLog, String resultCode, String message) {
        if (resultCode.startsWith("S-")) {
            sendEmailLog.setSendEndDate(LocalDateTime.now());
        } else {
            sendEmailLog.setFailDate(LocalDateTime.now());
        }

        sendEmailLog.setResultCode(resultCode);
        sendEmailLog.setMessage(message);

        emailLogRepository.save(sendEmailLog);
    }
}
