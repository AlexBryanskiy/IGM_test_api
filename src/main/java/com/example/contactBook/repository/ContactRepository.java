package com.example.contactBook.repository;

import com.example.contactBook.model.Contact;
import java.util.List;
import java.util.UUID;

public interface ContactRepository {

    Contact getById(UUID id);

    List<Contact> getContacts();

    void insert(Contact contact);

    Contact update(UUID id, Contact contact);

    void delete(UUID id);
}
