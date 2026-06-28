package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.AdminAuditLog;
import java.util.List;

public interface AdminAuditLogService {

    AdminAuditLog create(AdminAuditLog adminAuditLog);

    AdminAuditLog update(Long id, AdminAuditLog adminAuditLog);

    AdminAuditLog getById(Long id);

    List<AdminAuditLog> getAll();

    void delete(Long id);

    List<AdminAuditLog> getByAdminId(Long adminId);

    List<AdminAuditLog> getByEntityType(String entityType);

    List<AdminAuditLog> getByEntityTypeAndEntityId(String entityType, Long entityId);
}
