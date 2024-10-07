package com.nirab.conference.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConferenceDetailsDto {
    private Long id;
    private String roomName;
    private String roomLocation;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int registeredParticipants;

    public ConferenceDetailsDto() {}

    public ConferenceDetailsDto(Long id, String roomName, String roomLocation, LocalDateTime startDateTime, LocalDateTime endDateTime, int registeredParticipants) {
        this.id = id;
        this.roomName = roomName;
        this.roomLocation = roomLocation;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.registeredParticipants = registeredParticipants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void setRegisteredParticipants(int registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

    @Override
    public String toString() {
        return "ConferenceDetailsDto{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", roomLocation='" + roomLocation + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", registeredParticipants=" + registeredParticipants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceDetailsDto that = (ConferenceDetailsDto) o;
        return registeredParticipants == that.registeredParticipants && Objects.equals(id, that.id) && Objects.equals(roomName, that.roomName) && Objects.equals(roomLocation, that.roomLocation) && Objects.equals(startDateTime, that.startDateTime) && Objects.equals(endDateTime, that.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomName, roomLocation, startDateTime, endDateTime, registeredParticipants);
    }
}
