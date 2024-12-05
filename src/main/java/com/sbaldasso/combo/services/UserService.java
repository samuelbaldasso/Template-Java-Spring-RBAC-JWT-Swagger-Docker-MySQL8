package com.sbaldasso.combo.services;

import com.sbaldasso.combo.config.BCryptPasswordEncoder;
import com.sbaldasso.combo.domains.User;
import com.sbaldasso.combo.dto.UserDTO;
import com.sbaldasso.combo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createUser(UserDTO user){
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setRole(user.isAdmin() ? "OWNER" : "MOTOBOY");
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user1);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(UserDTO user, Long id){
        User user1 = findById(id);
        user1.setEmail(user.getEmail());
        user1.setRole(user.isAdmin() ? "OWNER" : "MOTOBOY");
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user1);
    }

}
