package com.example.service;

import com.example.model.EmailBox;
import com.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxService implements IMailBoxService{


    @Autowired
    IEmailRepository iEmailRepository;

    @Override
    public String[] showLanguage() {
        return iEmailRepository.showLanguage();
    }

    @Override
    public int[] showSize() {
        return iEmailRepository.showSize();
    }

    @Override
    public EmailBox showEmail() {
        return iEmailRepository.showEmail();
    }

    @Override
    public void update(EmailBox emailBox) {
        iEmailRepository.update(emailBox);
    }
}
