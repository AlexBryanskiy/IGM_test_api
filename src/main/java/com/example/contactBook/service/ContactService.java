package com.example.contactBook.service;

import com.example.contactBook.model.Contact;
import java.util.List;
import java.util.UUID;

public interface ContactService {

    Contact getContact(UUID id);

    List<Contact> getContacts();

    void createContact(Contact contact);

    Contact updateContact(UUID id, Contact contact);

    void deleteContact(UUID id);
}
