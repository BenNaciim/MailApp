package com.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${contact.mail.from}")
    private String contactFrom;
    @Value("${contact.mail.to}")
    private String contactTo;
    @Value("${contact.mail.Cc}")
    private String contactCc;
    @Value("${contact.mail.Bcc}")
    private String contactBcc;
    @Value("${contact.mail.subject}")
    private String subject;





    public void sendEmail() throws MessagingException {
        String body = "";
        MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom(contactFrom);
            messageHelper.setTo(contactTo);
            messageHelper.setSubject(subject);
            messageHelper.setText(body);
            messageHelper.setPriority(1);
            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Naciim\\Desktop\\Nouveau dossier (2)\\CNI Conjoint.pdf"));
            messageHelper.addAttachment(file.getFilename(),file);
        mailSender.send(mimeMessage);
    }
}
