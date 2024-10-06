package com.nirab.conference.dto;

import com.nirab.conference.model.Room;
import com.nirab.conference.model.RoomStatus;

public class RoomDto {
    private Long id;
    private String name;
    private RoomStatus status;
    private String address;
    private int capacity;

    public RoomDto() {}

    public RoomDto(Long id, String name, RoomStatus status, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
