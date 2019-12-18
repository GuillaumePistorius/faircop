package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {

    private long id;
    private String name;
    private Integer floor;
    private long buildingId;
    private List<LightDto> lights;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.buildingId = room.getBuilding().getId();
        this.lights = new ArrayList<LightDto>();
        for (Light light : room.getLights()) {
            this.lights.add(new LightDto(light));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public List<LightDto> getLights() {
        return lights;
    }
}
