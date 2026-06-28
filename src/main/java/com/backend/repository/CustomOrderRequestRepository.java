package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.CustomOrderRequest;
import com.backend.jewelcraft.enums.CustomOrderStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomOrderRequestRepository extends JpaRepository<CustomOrderRequest, Long> {

    List<CustomOrderRequest> findByUserId(Long userId);

    List<CustomOrderRequest> findByStatus(CustomOrderStatus status);

    List<CustomOrderRequest> findByConvertedOrderId(Long convertedOrderId);
}
