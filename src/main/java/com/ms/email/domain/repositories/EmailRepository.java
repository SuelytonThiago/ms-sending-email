package com.ms.email.domain.repositories;

import com.ms.email.domain.entities.Emails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Emails, Long> {
}
