package com.backend.service;

import com.backend.jewelcraft.entity.CustomOrderRequest;
import com.backend.jewelcraft.enums.CustomOrderStatus;
import java.util.List;

public interface CustomOrderRequestService {

    CustomOrderRequest create(CustomOrderRequest customOrderRequest);

    CustomOrderRequest update(Long id, CustomOrderRequest customOrderRequest);

    CustomOrderRequest getById(Long id);

    List<CustomOrderRequest> getAll();

    void delete(Long id);

    List<CustomOrderRequest> getByUserId(Long userId);

    List<CustomOrderRequest> getByStatus(CustomOrderStatus status);

    List<CustomOrderRequest> getByConvertedOrderId(Long convertedOrderId);
}
