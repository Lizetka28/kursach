package com.example.kursach.servise;


import com.example.kursach.model.Role;
import com.example.kursach.model.User;
import com.example.kursach.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String userEmail = user.getEmail();
        if (userRepository.findByEmail(userEmail) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", userEmail);
        userRepository.save(user);
        return true;
    }
}
