package com.backend.service;

import com.backend.jewelcraft.entity.Address;
import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address create(Address address);

    Address update(Long id, Address address);

    Address getById(Long id);

    List<Address> getAll();

    void delete(Long id);

    List<Address> getByUserId(Long userId);

    Optional<Address> getDefaultAddressByUserId(Long userId);
}
