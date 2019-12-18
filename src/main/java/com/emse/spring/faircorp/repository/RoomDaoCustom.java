package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Room;

public interface RoomDaoCustom {
    Room findByName(String name);
}
