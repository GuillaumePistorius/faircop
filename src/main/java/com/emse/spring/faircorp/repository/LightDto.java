package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.Light;
import com.emse.spring.faircorp.model.Status;

public class LightDto {

    private  Long id;
    private  Integer level;
    private Status status;
    private long roomId;

    public LightDto() {
    }

    public LightDto(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
        this.roomId = light.getRoom().getId();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public long getRoomId() {
        return this.roomId;
    }
}
