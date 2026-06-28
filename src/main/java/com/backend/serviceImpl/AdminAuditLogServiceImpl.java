package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.AdminAuditLog;
import com.backend.jewelcraft.repository.AdminAuditLogRepository;
import com.backend.service.AdminAuditLogService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminAuditLogServiceImpl implements AdminAuditLogService {

    private final AdminAuditLogRepository adminAuditLogRepository;

    public AdminAuditLogServiceImpl(AdminAuditLogRepository adminAuditLogRepository) {
        this.adminAuditLogRepository = adminAuditLogRepository;
    }

    @Override
    public AdminAuditLog create(AdminAuditLog adminAuditLog) {
        return adminAuditLogRepository.save(adminAuditLog);
    }

    @Override
    public AdminAuditLog update(Long id, AdminAuditLog adminAuditLog) {
        getById(id);
        adminAuditLog.setId(id);
        return adminAuditLogRepository.save(adminAuditLog);
    }

    @Override
    public AdminAuditLog getById(Long id) {
        return adminAuditLogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AdminAuditLog not found with id: " + id));
    }

    @Override
    public List<AdminAuditLog> getAll() {
        return adminAuditLogRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        adminAuditLogRepository.deleteById(id);
    }

    @Override
    public List<AdminAuditLog> getByAdminId(Long adminId) {
        return adminAuditLogRepository.findByAdminId(adminId);
    }

    @Override
    public List<AdminAuditLog> getByEntityType(String entityType) {
        return adminAuditLogRepository.findByEntityType(entityType);
    }

    @Override
    public List<AdminAuditLog> getByEntityTypeAndEntityId(String entityType, Long entityId) {
        return adminAuditLogRepository.findByEntityTypeAndEntityId(entityType, entityId);
    }
}
