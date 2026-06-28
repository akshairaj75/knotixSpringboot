package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.ContactMessage;
import com.backend.jewelcraft.enums.MessageStatus;
import com.backend.jewelcraft.repository.ContactMessageRepository;
import com.backend.service.ContactMessageService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @Override
    public ContactMessage create(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }

    @Override
    public ContactMessage update(Long id, ContactMessage contactMessage) {
        getById(id);
        contactMessage.setId(id);
        return contactMessageRepository.save(contactMessage);
    }

    @Override
    public ContactMessage getById(Long id) {
        return contactMessageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ContactMessage not found with id: " + id));
    }

    @Override
    public List<ContactMessage> getAll() {
        return contactMessageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        contactMessageRepository.deleteById(id);
    }

    @Override
    public List<ContactMessage> getByStatus(MessageStatus status) {
        return contactMessageRepository.findByStatus(status);
    }

    @Override
    public List<ContactMessage> getByEmail(String email) {
        return contactMessageRepository.findByEmail(email);
    }
}
