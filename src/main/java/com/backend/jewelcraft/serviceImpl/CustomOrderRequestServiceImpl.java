package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.CustomOrderRequest;
import com.backend.jewelcraft.enums.CustomOrderStatus;
import com.backend.jewelcraft.repository.CustomOrderRequestRepository;
import com.backend.jewelcraft.service.CustomOrderRequestService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomOrderRequestServiceImpl implements CustomOrderRequestService {

    private final CustomOrderRequestRepository customOrderRequestRepository;

    public CustomOrderRequestServiceImpl(CustomOrderRequestRepository customOrderRequestRepository) {
        this.customOrderRequestRepository = customOrderRequestRepository;
    }

    @Override
    public CustomOrderRequest create(CustomOrderRequest customOrderRequest) {
        return customOrderRequestRepository.save(customOrderRequest);
    }

    @Override
    public CustomOrderRequest update(Long id, CustomOrderRequest customOrderRequest) {
        getById(id);
        customOrderRequest.setId(id);
        return customOrderRequestRepository.save(customOrderRequest);
    }

    @Override
    public CustomOrderRequest getById(Long id) {
        return customOrderRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CustomOrderRequest not found with id: " + id));
    }

    @Override
    public List<CustomOrderRequest> getAll() {
        return customOrderRequestRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        customOrderRequestRepository.deleteById(id);
    }

    @Override
    public List<CustomOrderRequest> getByUserId(Long userId) {
        return customOrderRequestRepository.findByUserId(userId);
    }

    @Override
    public List<CustomOrderRequest> getByStatus(CustomOrderStatus status) {
        return customOrderRequestRepository.findByStatus(status);
    }

    @Override
    public List<CustomOrderRequest> getByConvertedOrderId(Long convertedOrderId) {
        return customOrderRequestRepository.findByConvertedOrderId(convertedOrderId);
    }
}
