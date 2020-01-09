package com.example.demo.repository;

import com.example.demo.model.Contact;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    private Map<Integer, Contact> collection;

    public ContactRepositoryImpl() {
        this.collection = new ConcurrentHashMap<>();
    }

    @Override
    public Contact getById(int id) {
        return this.collection.get(id);
    }

    @Override
    public List<Contact> getContacts() {
        return null;
    }

    @Override
    public Contact insert(Contact contact) {
        this.collection.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }
}
