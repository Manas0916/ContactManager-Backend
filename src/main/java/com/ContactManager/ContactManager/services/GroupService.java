package com.ContactManager.ContactManager.services;

import com.ContactManager.ContactManager.entity.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GroupService {
    private final GroupRepo groupRepo;

    @Autowired
    public GroupService(GroupRepo groupRepo){
        this.groupRepo = groupRepo;
    }

    public  ResponseEntity<?> createGroup(Groups group){
        Groups save = this.groupRepo.save(group);
        return ResponseEntity.ok(save);
    }
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

    public ResponseEntity<?> getGroup(Integer groupId){
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

}
