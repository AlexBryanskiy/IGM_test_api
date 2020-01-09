package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private ContactService contactService;

    @Autowired
    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * Create contact response entity.
     *
     * @param payload the contact
     * @return the response entity
     */
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity<Contact> createContact(@RequestBody String payload) throws JsonProcessingException {
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
}
