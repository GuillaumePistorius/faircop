package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Light;

import java.util.List;

public interface BuildingDaoCustom {
    List<Light> findLightsByBuilding(long buildingId);
}
