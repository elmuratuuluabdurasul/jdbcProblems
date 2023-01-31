package org.example.model;

import java.sql.Date;

public class Restourant {
    private Long id;
    private String name;
    private String address;
    private String openYear;

    public Restourant(Long id, String name, String address, String openYear) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openYear = openYear;
    }

    public Restourant(String name, String address, String openYear) {
        this.name = name;
        this.address = address;
        this.openYear = openYear;
    }

    public Restourant(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenYear() {
        return openYear;
    }

    public void setOpenYear(String openYear) {
        this.openYear = openYear;
    }

    @Override
    public String toString() {
        return "Restourant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openYear=" + openYear +
                '}';
    }
}
