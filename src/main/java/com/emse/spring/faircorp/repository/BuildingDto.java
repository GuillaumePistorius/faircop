package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

import java.util.ArrayList;
import java.util.List;

public class BuildingDto {

    private long id;
    private String name;
    private List<RoomDto> rooms;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = new ArrayList<RoomDto>();
        for (Room room : building.getRooms()) {
            this.rooms.add(new RoomDto(room));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

}
