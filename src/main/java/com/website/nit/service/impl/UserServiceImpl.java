package com.website.nit.service.impl;

import com.website.nit.constant.EmailType;
import com.website.nit.model.Users;
import com.website.nit.repository.UserRepository;
import com.website.nit.service.EmailService;
import com.website.nit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository usersRepository;

    @Autowired
    EmailService emailService;


    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Users login(String username, String password) {
        Users user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    @Override
    public Users register(Users user) {
        user.setPassword(user.getPassword());
        return usersRepository.save(user);
    }

    @Override
    public Users requestPasswordReset(String email) {
        return Optional.ofNullable(findByEmail(email)).map(user -> {
            String resetCode = generateResetCode();
            user.setResetCode(resetCode);
            emailService.sendResetCode(user, email, resetCode);
            return usersRepository.save(user);
        }).orElse(null);
    }

    @Override
    public boolean validateResetCode(String email, String resetCode) {
        Users user = findByEmail(email);
        return user != null && user.getResetCode().equals(resetCode);
    }

    @Override
    public Users resetPasswordWithCode(String email, String resetCode, String newPassword) {
        return Optional.ofNullable(findByEmail(email)).filter(user -> user.getResetCode().equals(resetCode)).map(user -> {
            user.setPassword(newPassword);
            user.setResetCode(null); // Reset the reset code after successful reset
            return usersRepository.save(user);
        }).orElse(null);
    }


    @Override
    public Users changePassword(String username, String oldPassword, String newPassword) {

        return Optional.ofNullable(findByUsername(username))
                .filter(user -> user.getPassword().equals(oldPassword))
                .map(user -> {
                    user.setPassword(newPassword);
                    return usersRepository.save(user);
                }).orElse(null);
    }

    // In UserServiceImpl.java

    private String generateResetCode() {
        return String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
    }
}
