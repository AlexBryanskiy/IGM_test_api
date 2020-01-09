package com.example.demo.service;

import com.example.demo.model.Contact;
import java.util.List;

public interface ContactService {

    Contact getContact(int id);

    List<Contact> getContacts();

    Contact createContact(Contact contact);

    Contact updateContact(Contact contact);

    void deleteContact(int id);
}
