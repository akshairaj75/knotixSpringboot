package com.backend.jewelcraft.dto.adminDto;

import com.backend.jewelcraft.entity.AdminAuditLog;
import java.time.LocalDateTime;

public class AdminAuditLogResponseDto {

    private Long id;
    private Long adminId;
    private String adminName;
    private String action;
    private String entityType;
    private Long entityId;
    private String payload;
    private String ipAddress;
    private LocalDateTime createdAt;

    public AdminAuditLogResponseDto() {
    }

    public static AdminAuditLogResponseDto fromEntity(AdminAuditLog entity) {
        if (entity == null) {
            return null;
        }
        AdminAuditLogResponseDto dto = new AdminAuditLogResponseDto();
        dto.setId(entity.getId());
        if (entity.getAdmin() != null) {
            dto.setAdminId(entity.getAdmin().getId());
            dto.setAdminName(entity.getAdmin().getFullName());
        }
        dto.setAction(entity.getAction());
        dto.setEntityType(entity.getEntityType());
        dto.setEntityId(entity.getEntityId());
        dto.setPayload(entity.getPayload());
        dto.setIpAddress(entity.getIpAddress());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAdminId() { return adminId; }
    public void setAdminId(Long adminId) { this.adminId = adminId; }
    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getEntityType() { return entityType; }
    public void setEntityType(String entityType) { this.entityType = entityType; }
    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }
    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
