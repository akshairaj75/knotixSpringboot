package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.ContactMessage;
import com.backend.jewelcraft.enums.MessageStatus;
import java.util.List;

public interface ContactMessageService {

    ContactMessage create(ContactMessage contactMessage);

    ContactMessage update(Long id, ContactMessage contactMessage);

    ContactMessage getById(Long id);

    List<ContactMessage> getAll();

    void delete(Long id);

    List<ContactMessage> getByStatus(MessageStatus status);

    List<ContactMessage> getByEmail(String email);
}
