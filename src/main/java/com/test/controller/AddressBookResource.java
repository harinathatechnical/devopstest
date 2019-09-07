package com.test.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts =  new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Contacts by Id",
    notes = "Provide an ID to look up specific contact from address book",
    response = Contact.class)
    public Contact getContact(@ApiParam(value = "ID value for the contact you need to retrive" , required = true)
            @PathVariable String id){

        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){

        contacts.put(contact.getId(),contact);
        return contact;
    }
}
