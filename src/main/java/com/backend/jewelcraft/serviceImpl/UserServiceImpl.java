package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.User;
import com.backend.jewelcraft.enums.UserRole;
import com.backend.jewelcraft.repository.UserRepository;
import com.backend.jewelcraft.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> getByRole(UserRole role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> getActiveUsers() {
        return userRepository.findByActive(true);
    }
}
