package com.example.contactBook.controller;

import com.example.contactBook.model.Contact;
import com.example.contactBook.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ContactController {

    private ContactService contactService;

    @Autowired
    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> getContactsList() {
        return new ResponseEntity<>(this.contactService.getContacts(), HttpStatus.OK);
    }

    /**
     * Gets contact.
     *
     * @param id the id of contact
     * @return the contact
     */
    @RequestMapping(value = "contacts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable("id") String id) {
        Contact contact = this.contactService.getContact(Integer.parseInt(id));

        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create contact response entity.
     *
     * @param payload the contact
     * @return the response entity
     */
    @RequestMapping(value = "contacts", method = RequestMethod.POST)
    public ResponseEntity<Contact> createContact(@RequestBody String payload) {
        ObjectMapper objectMapper = new ObjectMapper();

        Contact contact = null;

        try {
            contact = objectMapper.readValue(payload, Contact.class);
        } catch (JsonProcessingException exception) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        this.contactService.createContact(contact);

        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Update contact response entity.
     *
     * @param id      the id of entity
     * @param payload the payload
     * @return the response entity
     */
    @RequestMapping(value = "contacts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable("id") String id, @RequestBody String payload) {

        ObjectMapper objectMapper = new ObjectMapper();

        Contact contact = null;

        try {
            contact = objectMapper.readValue(payload, Contact.class);
        } catch (JsonProcessingException exception) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (this.contactService.updateContact(Integer.parseInt(id), contact) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
    }
}
