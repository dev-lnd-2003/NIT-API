package com.website.nit.rest;

import com.website.nit.model.Users;
import com.website.nit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/login")
    public Users login(@RequestBody Users users){
        Users existUser = userService.findByUsername(users.getUsername());
        return  users;
    }
    @PostMapping(value = "/user/register")
    public Users register(@RequestBody Users users) {
        userService.register(users);
        return users;
    }

    @PostMapping(value = "/user/reset-password/{email}")
    public Users resetPassword(@PathVariable("email") String email) {
        Users updatedUser = userService.resetPassword(email);
        return updatedUser;
    }

    @PutMapping(value = "/user/change-password/{username}")
    public Users changePassword(@PathVariable("username") String username,
                                @RequestBody Map<String, String> passwords){
        String oldPassword = passwords.get("oldPassword");
        String newPassword = passwords.get("newPassword");
        return Optional.ofNullable(userService.changePassword(username, oldPassword, newPassword))
                .orElse(null);
    }
}
