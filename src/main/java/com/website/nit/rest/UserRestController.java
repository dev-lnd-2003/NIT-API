package com.website.nit.rest;

import com.website.nit.model.Users;
import com.website.nit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/login")
    public ResponseEntity<Users> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Users user = userService.login(username, password);

        if (user != null) {
            return ResponseEntity.ok(user); // Trả về HTTP status 200 OK và body chứa user
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Trả về HTTP status 401 Unauthorized
        }
    }

    @PostMapping(value = "/user/register")
    public Users register(@RequestBody Users users) {
        userService.register(users);
        return users;
    }


    @PostMapping(value = "/user/request-reset/{email}")
    public Users requestPasswordReset(@PathVariable("email") String email) {
        Users updatedUser = userService.requestPasswordReset(email);
        return updatedUser;
    }
    @PostMapping(value = "/user/reset-password/{email}")
    public ResponseEntity<String> resetPasswordWithCode(@PathVariable("email") String email,
                                                        @RequestBody Map<String, String> requestBody) {
        String resetCode = requestBody.get("resetCode");
        String newPassword = requestBody.get("newPassword");

        if (userService.validateResetCode(email, resetCode)) {
            Users updatedUser = userService.resetPasswordWithCode(email, resetCode, newPassword);
            if (updatedUser != null) {
                return ResponseEntity.ok("Password reset successfully");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid reset code");
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
