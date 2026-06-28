package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.MessageStatus;

public class ContactMessageStatusUpdateRequestDto {

    private MessageStatus status;

    public ContactMessageStatusUpdateRequestDto() {
    }

    public MessageStatus getStatus() { return status; }
    public void setStatus(MessageStatus status) { this.status = status; }
}
