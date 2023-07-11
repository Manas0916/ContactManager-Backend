package com.ContactManager.ContactManager.controller;

import com.ContactManager.ContactManager.entity.Contacts;
import com.ContactManager.ContactManager.entity.Groups;
import com.ContactManager.ContactManager.services.ContactService;
import com.ContactManager.ContactManager.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MyController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private ContactService contactService;
    // Get all the Groups
    @GetMapping("/groups")
    public ResponseEntity<?> getGroups(){
        return this.groupService.getGroups();
    }

    @PostMapping("/groups")
    public ResponseEntity<?> createGroup(@RequestBody Groups group){
        return this.groupService.createGroup(group);
    }

    //Get a single group
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<?> getGroup(@PathVariable Integer groupId) {
        return this.groupService.getGroup(groupId);
    }

    //Get all contacts
    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts(){
        return this.contactService.getContacts();
    }

    //Get a Single Contact
    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<?> getContact(@PathVariable Integer contactId) {
        return this.contactService.getContact(contactId);
    }

    //Create a Contact
    @PostMapping("/contacts")
    public ResponseEntity<?> createContact(@RequestBody Contacts contact){
        return this.contactService.createContact(contact);
    }

    //Update a Contact
    @PutMapping("/contacts/{contactId}")
    public ResponseEntity<?> updateContact(@RequestBody Contacts contact, @PathVariable Integer contactId){
        return this.contactService.updateContact(contact, contactId);
    }

    //Delete a Contact
    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable Integer contactId){
        return this.contactService.deleteContact(contactId);
    }
}