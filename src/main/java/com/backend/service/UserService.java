package com.backend.service;

import com.backend.jewelcraft.entity.User;
import com.backend.jewelcraft.enums.UserRole;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    User update(Long id, User user);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);

    Optional<User> getByEmail(String email);

    boolean existsByEmail(String email);

    List<User> getByRole(UserRole role);

    List<User> getActiveUsers();
}
