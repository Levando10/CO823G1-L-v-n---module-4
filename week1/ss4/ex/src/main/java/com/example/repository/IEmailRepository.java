package com.example.repository;

import com.example.model.EmailBox;

public interface IEmailRepository {
    String[] showLanguage();

    int[] showSize();

    EmailBox showEmail();

    void update(EmailBox emailBox);
}
