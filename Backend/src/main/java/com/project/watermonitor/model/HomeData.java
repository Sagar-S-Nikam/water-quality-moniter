package com.project.watermonitor.model;


import jakarta.persistence.*;

@Entity
public class HomeData {

    @Id
    @GeneratedValue
    private Long id;

    private String homeName;
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
// getters & setters
}