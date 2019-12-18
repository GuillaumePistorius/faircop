package com.emse.spring.faircorp.rest;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Status;
import com.emse.spring.faircorp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private LightDao lightDao;
    @Autowired
    private BuildingDao buildingDao;

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> new RoomDto(room)).orElse(null);
    }

    @PutMapping(path = "/{id}/switchLight")
    public RoomDto switchLights(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Light light : room.getLights()) {
            light.setStatus(light.getStatus() == Status.ON ? Status.OFF : Status.ON);
        }
        return new RoomDto(room);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId() != null) {
            room = roomDao.findById(dto.getId()).orElse(null);
        }

        if (room == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getFloor(), buildingDao.getOne(dto.getBuildingId())));
        } else {
            room.setName(dto.getName());
            room.setFloor(dto.getFloor());
            roomDao.save(room);
        }

        return new RoomDto(room);
    }


    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElse(null);
        for (Light light : room.getLights()) {
            lightDao.deleteById(light.getId());
        }
        roomDao.deleteById(id);
    }

}
