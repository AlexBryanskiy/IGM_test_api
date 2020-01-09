package com.example.demo.repository;

import com.example.demo.model.Contact;
import java.util.List;

public interface ContactRepository {

    Contact getById(int id);

    List<Contact> getContacts();

    Contact insert(Contact contact);

    Contact update(Contact contact);
}
