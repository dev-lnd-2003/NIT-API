package com.website.nit.service.impl;


import com.website.nit.constant.EmailType;
import com.website.nit.model.Users;
import com.website.nit.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private static final String EMAIL_WELCOME_SUBJECT = "WELCOME ";

    private static final String EMAIL_SEND_NEW_PASSWORD = "NIT - YOUR A NEW PASSWORD";


    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(Users recipient, String to, String newPassword, EmailType emailType) {
        SimpleMailMessage message = new SimpleMailMessage();
        String content = null;
        String subject = null;
        switch (emailType) {
            case WELCOME:
                subject = EMAIL_WELCOME_SUBJECT;
                content = "Love You!!!";
                break;
            case RESET_PASSWORD:
                subject = EMAIL_SEND_NEW_PASSWORD;
                content = "Dear " + recipient.getFullName() + ", Your New Password Here : " + newPassword;
                break;
            default:
                subject = "NIT Online";
                content = "Email Wrong";
        }
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }
}