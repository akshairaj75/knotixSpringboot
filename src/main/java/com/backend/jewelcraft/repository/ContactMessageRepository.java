package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.ContactMessage;
import com.backend.jewelcraft.enums.MessageStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

    List<ContactMessage> findByStatus(MessageStatus status);

    List<ContactMessage> findByEmail(String email);
}
