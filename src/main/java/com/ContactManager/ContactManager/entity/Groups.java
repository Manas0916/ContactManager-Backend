package com.ContactManager.ContactManager.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Groups")
public class Groups
{
    private int id;
    private String name;

    public Groups(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public Groups(){
        super();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
