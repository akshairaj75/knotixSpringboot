package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.AdminAuditLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAuditLogRepository extends JpaRepository<AdminAuditLog, Long> {

    List<AdminAuditLog> findByAdminId(Long adminId);

    List<AdminAuditLog> findByEntityType(String entityType);

    List<AdminAuditLog> findByEntityTypeAndEntityId(String entityType, Long entityId);
}
