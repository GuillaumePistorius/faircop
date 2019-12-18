package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<Light> lights;


    public Room() {

    }

    public Room(String name, Integer floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
        this.lights = new ArrayList<Light>();
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

    public Integer getFloor() {
        return this.floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return this.building;
    }

    public List<Light> getLights() {
        return this.lights;
    }
}
