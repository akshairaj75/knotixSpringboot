package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Address;
import com.backend.jewelcraft.repository.AddressRepository;
import com.backend.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        getById(id);
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Optional<Address> getDefaultAddressByUserId(Long userId) {
        return addressRepository.findByUserIdAndDefaultAddressTrue(userId);
    }
}
