package com.sbp.bookuluv.app.email.repository;

import com.sbp.bookuluv.app.email.entity.SendEmailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendEmailLogRepository extends JpaRepository<SendEmailLog, Long> {
}
