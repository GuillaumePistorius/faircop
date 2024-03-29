package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    public Building() {
    }

    public Building(String name) {
        this.name=name;
        this.rooms = new ArrayList<Room>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }
}
