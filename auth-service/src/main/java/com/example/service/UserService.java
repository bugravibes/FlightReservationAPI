package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().forEach(role -> {
            Role existingRole = roleRepository.findByName(role.getName());
            if (existingRole == null) {
                roleRepository.save(role);
            } else {
                role.setId(existingRole.getId());
            }
        });
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
