package com.nirab.conference.service;

import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.Room;
import com.nirab.conference.model.RoomStatus;
import com.nirab.conference.repository.RoomRepository;
import com.nirab.conference.utils.EntityDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RoomServiceTest {
    @Mock
    private RoomRepository roomRepository;

    @Mock
    private EntityDtoMapper roomMapper;

    @InjectMocks
    private RoomService roomService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRoom() {
        // Arrange
        RoomDto roomDTO = new RoomDto();
        roomDTO.setName("Room A");
        roomDTO.setAddress("Location A");
        roomDTO.setCapacity(100);
        roomDTO.setStatus(RoomStatus.AVAILABLE);

        Room room = new Room();
        room.setName("Room A");
        room.setAddress("Location A");
        room.setCapacity(100);
        room.setStatus(RoomStatus.AVAILABLE);

        // Mocking behavior of the mapper and repository
        when(roomMapper.toRoom(roomDTO)).thenReturn(room);
        when(roomRepository.save(any(Room.class))).thenReturn(room);
        when(roomMapper.toRoomDto(room)).thenReturn(roomDTO);

        // Act
        Room createdRoomDTO = roomService.createConferenceRoom(roomDTO);

        // Assert
        assertEquals("Room A", createdRoomDTO.getName());
        assertEquals("Location A", createdRoomDTO.getAddress());
        assertEquals(100, createdRoomDTO.getCapacity());
        assertEquals("AVAILABLE", createdRoomDTO.getStatus().toString());
    }}
