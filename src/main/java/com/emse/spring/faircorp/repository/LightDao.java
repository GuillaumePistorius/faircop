package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Long>, LightDaoCustom {
}
