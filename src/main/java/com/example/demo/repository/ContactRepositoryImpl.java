package com.example.demo.repository;

import com.example.demo.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        return new ArrayList<>(this.collection.values());
    }

    @Override
    public void insert(Contact contact) {
        this.collection.put(contact.getId(), contact);
    }

    @Override
    public Contact update(int id, Contact contact) {
        if (this.collection.containsKey(id)) {
            this.collection.replace(id, contact);

            return contact;
        }

        return null;
    }
}
