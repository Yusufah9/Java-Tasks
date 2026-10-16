package com.lastma.data.models;

public class Officer {
    private int id;
    private String name;
    private String badgeNumber;
    private String phoneNumber;
    private String email;

    public Officer() {
    }

    public Officer(String name, String badgeNumber, String phoneNumber, String email) {
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Officer(int id, String name, String badgeNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Officer officer = (Officer) object;
        return id == officer.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
