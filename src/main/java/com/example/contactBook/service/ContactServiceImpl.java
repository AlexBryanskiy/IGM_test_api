package com.example.contactBook.service;

import com.example.contactBook.model.Contact;
import com.example.contactBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getContact(UUID id) {
        return this.contactRepository.getById(id);
    }

    @Override
    public List<Contact> getContacts() {
        return this.contactRepository.getContacts();
    }

    @Override
    public void createContact(Contact contact) {
        this.contactRepository.insert(contact);
    }

    @Override
    public Contact updateContact(UUID id, Contact contact) {
        return this.contactRepository.update(id, contact);
    }

    @Override
    public void deleteContact(UUID id) {
        this.contactRepository.delete(id);
    }
}
