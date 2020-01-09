package com.example.contactBook.repository;

import com.example.contactBook.model.Contact;
import java.util.List;

public interface ContactRepository {

    Contact getById(int id);

    List<Contact> getContacts();

    void insert(Contact contact);

    Contact update(int id, Contact contact);
}
