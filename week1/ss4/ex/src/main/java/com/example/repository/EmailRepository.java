package com.example.repository;

import com.example.model.EmailBox;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository{
    private static EmailBox email;
    static {
        email = new EmailBox("Vietnamese",25,true,"hello");
    }

    @Override
    public String[] showLanguage() {
        return new String[]{"Email","Vietnamese","Japan"};
    }

    @Override
    public int[] showSize() {
        return new int[]{5, 10, 15, 25, 50, 100};
    }

    @Override
    public EmailBox showEmail() {

        return email;
    }

    @Override
    public void update(EmailBox emailBox) {
        email = emailBox;
    }
}
