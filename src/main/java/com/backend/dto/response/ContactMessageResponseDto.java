package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.ContactMessage;
import com.backend.jewelcraft.enums.MessageStatus;
import java.time.LocalDateTime;

public class ContactMessageResponseDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private MessageStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ContactMessageResponseDto() {
    }

    public static ContactMessageResponseDto fromEntity(ContactMessage entity) {
        if (entity == null) {
            return null;
        }
        ContactMessageResponseDto dto = new ContactMessageResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setSubject(entity.getSubject());
        dto.setMessage(entity.getMessage());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public MessageStatus getStatus() { return status; }
    public void setStatus(MessageStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
