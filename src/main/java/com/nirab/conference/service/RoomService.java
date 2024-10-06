package com.nirab.conference.service;

import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.Conference;
import com.nirab.conference.model.Room;
import com.nirab.conference.model.RoomStatus;
import com.nirab.conference.repository.ConferenceRepository;
import com.nirab.conference.repository.RoomRepository;
import com.nirab.conference.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private EntityDtoMapper entityDtoMapper;

    public List<RoomDto> findAllRooms() {
        return entityDtoMapper.toRoomDtos(roomRepository.findAll());
    }

    public Room createConferenceRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setAddress(roomDto.getAddress());
        room.setCapacity(roomDto.getCapacity());
        room.setStatus(roomDto.getStatus());

        return roomRepository.save(room);
    }

    public Room updateConferenceRoomStatus(Long roomId, String status) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Room not found"));

        if (status.equals("UNDER_CONSTRUCTION")) {
            List<Conference> futureConferences = conferenceRepository.findByRoomId(roomId);
            if (!futureConferences.isEmpty()) {
                throw new IllegalArgumentException("Room has future conferences.");
            }
        }
        room.setStatus(RoomStatus.valueOf(status));
        return roomRepository.save(room);
    }

    public Room updateRoomCapacity(Long roomId, int newCapacity) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Room not found"));

        List<Conference> futureConferences = conferenceRepository.findByRoomId(roomId);
        for (Conference conference : futureConferences) {
            if (conference.getRegistrations().size() > newCapacity) {
                throw new IllegalArgumentException("Cannot reduce capacity below current registrations.");
            }
        }
        room.setCapacity(newCapacity);
        return roomRepository.save(room);
    }

}
