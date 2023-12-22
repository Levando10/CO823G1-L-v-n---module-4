package com.example.service;

import com.example.model.EmailBox;

public interface IMailBoxService {
    String[] showLanguage();

    int[] showSize();

    EmailBox showEmail();

    void update(EmailBox emailBox);
}
