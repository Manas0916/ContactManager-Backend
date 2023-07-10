package com.ContactManager.ContactManager.services;

import com.ContactManager.ContactManager.entity.Groups;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepo extends MongoRepository<Groups, Integer> {
}
