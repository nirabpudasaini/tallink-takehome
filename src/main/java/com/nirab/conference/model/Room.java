package com.nirab.conference.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private String address;
    private int capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Conference> conferences;

    public Room() {
    }

    public Room(Long id, String name, RoomStatus status, String address, int maxCapacity, List<Conference> conferences) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.capacity = maxCapacity;
        this.conferences = conferences;
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

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", conferences=" + conferences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(id, room.id) && Objects.equals(name, room.name) && status == room.status && Objects.equals(address, room.address) && Objects.equals(conferences, room.conferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, address, capacity, conferences);
    }
}
