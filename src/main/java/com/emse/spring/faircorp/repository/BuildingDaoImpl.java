package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Light;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Light> findLightsByBuilding(long buildingId) {
        String jpql = "select lt from Building bd, IN (bd.rooms) rm , IN (rm.lights) lt where bd.id = :buildingId";
        return em.createQuery(jpql, Light.class)
                .setParameter("buildingId", buildingId)
                .getResultList();
    }
}
