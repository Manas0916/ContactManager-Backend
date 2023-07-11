package com.ContactManager.ContactManager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contacts")
public class Contacts {
    private int id;
    private String name;
    private String company;
    private String email;
    private String title;
    private String mobile;
    private String photo;
    private int groupId;

    public Contacts(int id, String name, String company, String email, String title, String mobile, String photo, int groupId) {
        super();
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.title = title;
        this.mobile = mobile;
        this.photo = photo;
        this.groupId = groupId;
    }

    public Contacts() {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", mobile=" + mobile +
                ", photo='" + photo + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
