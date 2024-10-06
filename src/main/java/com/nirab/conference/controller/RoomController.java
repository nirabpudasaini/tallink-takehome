package com.nirab.conference.controller;

import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.Room;
import com.nirab.conference.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/backoffice/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        return new ResponseEntity<>(roomService.findAllRooms(),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<RoomDto> createConferenceRoom(@RequestBody RoomDto roomDto) {
        Room room = roomService.createConferenceRoom(roomDto);
        return new ResponseEntity<>(roomDto, HttpStatus.CREATED);
    }

    @PutMapping("/{roomId}/status")
    public ResponseEntity<String> updateRoomStatus(@PathVariable Long roomId, @RequestBody String status) {
        Room room = roomService.updateConferenceRoomStatus(roomId, status);
        return new ResponseEntity<>("Status Updated", HttpStatus.OK);
    }

    @PutMapping("/{roomId}/capacity")
    public ResponseEntity<String> updateRoomCapacity(@PathVariable Long roomId, @RequestBody int capacity) {
        Room room = roomService.updateRoomCapacity(roomId, capacity);
        return new ResponseEntity<>("Capacity Updated", HttpStatus.OK);
    }

}
