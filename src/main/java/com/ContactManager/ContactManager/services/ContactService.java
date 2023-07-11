package com.ContactManager.ContactManager.services;

import com.ContactManager.ContactManager.entity.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ContactService {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo){
        this.contactRepo = contactRepo;
    }

    public ResponseEntity<?> getContacts(){
        return ResponseEntity.ok(this.contactRepo.findAll());
    }

    public ResponseEntity<?> getContact(Integer contactId){
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

    public ResponseEntity<?> createContact(Contacts contact){
        Random obj = new Random();
        int id = obj.nextInt(1000000000);
        contact.setId(id);
        Contacts save = this.contactRepo.save(contact);
        return ResponseEntity.ok(save);
    }

    public ResponseEntity<?> updateContact(Contacts contact, Integer contactId){
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

    public ResponseEntity<?> deleteContact(Integer contactId){
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
