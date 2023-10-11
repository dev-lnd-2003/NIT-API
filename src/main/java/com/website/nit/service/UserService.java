package com.website.nit.service;

import com.website.nit.model.Users;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public Users findByEmail(String email);

    public Users findByUsername(String username);

    public Users login(String username, String password);



    public Users register(Users user);

    public Users requestPasswordReset(String email);
    boolean validateResetCode(String email, String resetCode);
    Users resetPasswordWithCode(String email, String resetCode, String newPassword);


    Users changePassword(String username,String oldPassword,String newPassword);

}
