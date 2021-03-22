package com.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("send")
public class MailController {

    @Autowired
    private MailService email;

    @GetMapping("/")
    public ResponseEntity launch() throws MessagingException {
        email.sendEmail();
        return ResponseEntity.ok().build();

    }
}
