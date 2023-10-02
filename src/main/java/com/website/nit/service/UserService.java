package com.website.nit.service;

import com.website.nit.model.Users;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public Users findByEmail(String email);

    public Users findByUsername(String username);


    public Users register(Users user);

    Users resetPassword(String email);

    Users changePassword(String username,String oldPassword,String newPassword);

}
