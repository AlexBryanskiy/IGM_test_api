package com.example.contactBook.service;

import com.example.contactBook.model.Contact;
import java.util.List;

public interface ContactService {

    Contact getContact(int id);

    List<Contact> getContacts();

    void createContact(Contact contact);

    Contact updateContact(int id, Contact contact);

    void deleteContact(int id);
}
