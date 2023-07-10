package com.ContactManager.ContactManager.controller;

import com.ContactManager.ContactManager.entity.Contacts;
import com.ContactManager.ContactManager.entity.Groups;
import com.ContactManager.ContactManager.services.ContactRepo;
import com.ContactManager.ContactManager.services.GroupRepo;
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
    private GroupRepo groupRepo;
    @Autowired
    private ContactRepo contactRepo;
    // Get all the Groups
    @GetMapping("/groups")
    public ResponseEntity<?> getGroups(){
        try {
            // Assuming you have a Spring Data MongoDB repository for the Group collection
            List<Groups> groups = groupRepo.findAll();

            if (!groups.isEmpty()) {
                return ResponseEntity.ok(groups);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/groups")
    public ResponseEntity<?> createGroup(@RequestBody Groups group){
        Groups save = this.groupRepo.save(group);
        return ResponseEntity.ok(save);
    }

    //Get a single group
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<?> getGroup(@PathVariable Integer groupId) {
        try {
            // Assuming you have a Spring Data MongoDB repository for the Group collection
            Optional<Groups> group = groupRepo.findById(groupId);

            if (group.isPresent()) {
                return ResponseEntity.ok(group.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Get all contacts
    @GetMapping("/contacts")
    public ResponseEntity<?> getContacts(){
        return ResponseEntity.ok(this.contactRepo.findAll());
    }

    //Get a Single Contact
    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<?> getContact(@PathVariable Integer contactId)
    {
        try {
            Optional<Contacts> contact = contactRepo.findById(contactId);
            if(contact.isPresent()){
                return ResponseEntity.ok(contact.get());
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Create a Contact
    @PostMapping("/contacts")
    public ResponseEntity<?> createContact(@RequestBody Contacts contact){
        Random obj = new Random();
        int id = obj.nextInt(1000000000);
        contact.setId(id);
        Contacts save = this.contactRepo.save(contact);
        return ResponseEntity.ok(save);
    }

    //Update a Contact
    @PutMapping("/contacts/{contactId}")
    public ResponseEntity<?> updateContact(@RequestBody Contacts contact, @PathVariable Integer contactId){
        try {
            // Assuming you have a Spring Data MongoDB repository for the Contact collection
            Optional<Contacts> existingContact = contactRepo.findById(contactId);

            if (existingContact.isPresent()) {
                Contacts updatedContact = existingContact.get();

                // Update the properties of the contact based on the request body
                updatedContact.setId(contact.getId());
                updatedContact.setName(contact.getName());
                updatedContact.setEmail(contact.getEmail());
                updatedContact.setGroupId(contact.getGroupId());
                updatedContact.setCompany(contact.getCompany());
                updatedContact.setMobile(contact.getMobile());
                updatedContact.setPhoto(contact.getPhoto());
                updatedContact.setTitle(contact.getTitle());
                // ... update other properties as needed

                // Save the updated contact
                Contacts savedContact = contactRepo.save(updatedContact);

                return ResponseEntity.ok(savedContact);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete a Contact
    @DeleteMapping("/contacts/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable Integer contactId){
        try {
            // Assuming you have a Spring Data MongoDB repository for the Contact collection
            Optional<Contacts> existingContact = contactRepo.findById(contactId);

            if (existingContact.isPresent()) {
                contactRepo.deleteById(contactId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}