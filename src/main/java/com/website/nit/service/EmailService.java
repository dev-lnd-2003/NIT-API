package com.website.nit.service;

import com.website.nit.constant.EmailType;
import com.website.nit.model.Users;

public interface EmailService {
    void sendEmail(Users recipient, String to, String newPassword, EmailType emailType);


}
