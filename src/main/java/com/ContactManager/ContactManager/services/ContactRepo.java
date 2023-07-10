package com.ContactManager.ContactManager.services;

import com.ContactManager.ContactManager.entity.Contacts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepo extends MongoRepository<Contacts, Integer> {
}
