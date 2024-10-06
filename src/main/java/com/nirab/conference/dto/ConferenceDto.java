package com.nirab.conference.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConferenceDto {

    private Long id;
    private Long roomId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public ConferenceDto() {
    }

    public ConferenceDto(LocalDateTime endDateTime, LocalDateTime startDateTime, Long roomId, Long id) {
        this.endDateTime = endDateTime;
        this.startDateTime = startDateTime;
        this.roomId = roomId;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    @Override
    public String toString() {
        return "ConferenceDto{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceDto that = (ConferenceDto) o;
        return Objects.equals(id, that.id) && Objects.equals(roomId, that.roomId) && Objects.equals(startDateTime, that.startDateTime) && Objects.equals(endDateTime, that.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, startDateTime, endDateTime);
    }
}
