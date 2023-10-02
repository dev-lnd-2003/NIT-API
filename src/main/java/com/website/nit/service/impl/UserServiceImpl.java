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
    public Users register(Users user) {
        user.setPassword(user.getPassword());
        return usersRepository.save(user);
    }

    @Override
    public Users resetPassword(String email) {
        return Optional.ofNullable(findByEmail(email))
                .map(users -> {
                    String newPassword = String.valueOf((int) (Math.random() * ((999 - 100) + 1)) + 1000);
                    users.setPassword(newPassword);
                    emailService.sendEmail(users, email, newPassword, EmailType.RESET_PASSWORD);
                    return usersRepository.save(users);
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


}
