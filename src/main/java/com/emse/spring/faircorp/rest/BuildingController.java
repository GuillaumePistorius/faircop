package com.emse.spring.faircorp.rest;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.repository.BuildingDao;
import com.emse.spring.faircorp.repository.BuildingDto;
import com.emse.spring.faircorp.repository.LightDao;
import com.emse.spring.faircorp.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private LightDao lightDao;
    @Autowired
    private BuildingDao buildingDao;

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> new BuildingDto(building)).orElse(null);
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() != null) {
            building = buildingDao.findById(dto.getId()).orElse(null);
        }

        if (building == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {
            building.setName(dto.getName());
            buildingDao.save(building);
        }

        return new BuildingDto(building);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        Building building = buildingDao.findById(id).orElse(null);
        for (Room room : building.getRooms()) {
            for (Light light : room.getLights()) {
                lightDao.deleteById(light.getId());
            }
            roomDao.deleteById(room.getId());
        }
        buildingDao.deleteById(id);
    }
}
