package com.example.contactBook.repository;

import com.example.contactBook.model.Contact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    private Map<UUID, Contact> collection;

    public ContactRepositoryImpl() {
        this.collection = new ConcurrentHashMap<>();
    }

    @Override
    public Contact getById(UUID id) {
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
    public Contact update(UUID id, Contact contact) {
        if (this.collection.containsKey(id)) {
            this.collection.replace(id, contact);

            return contact;
        }

        return null;
    }

    @Override
    public void delete(UUID id) {
        if (!this.collection.containsKey(id)) {
            throw new EntityNotFoundException();
        }

        this.collection.remove(id);
    }
}
