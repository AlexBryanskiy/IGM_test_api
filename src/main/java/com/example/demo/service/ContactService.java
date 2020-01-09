package com.example.demo.service;

import com.example.demo.model.Contact;

public interface ContactService {

    Contact getContact(int id);

    Contact createContact(Contact contact);

    Contact updateContact(Contact contact);

    void deleteContact(int id);
}
