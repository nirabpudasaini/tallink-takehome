package com.nirab.conference.service;

import com.nirab.conference.dto.ConferenceDetailsDto;
import com.nirab.conference.dto.ConferenceDto;
import com.nirab.conference.model.Conference;
import com.nirab.conference.model.Room;
import com.nirab.conference.model.RoomStatus;
import com.nirab.conference.repository.ConferenceRepository;
import com.nirab.conference.repository.RegistrationRepository;
import com.nirab.conference.repository.RoomRepository;
import com.nirab.conference.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private EntityDtoMapper entityDtoMapper;

    public Conference createConference(ConferenceDto dto) {
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No room found with id " + dto.getRoomId()));
        if (!(room.getStatus() == RoomStatus.AVAILABLE)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room is not available");
        }

        List<Conference> overlappingConferences = conferenceRepository
                .findByRoomId(dto.getRoomId())
                .stream()
                .filter(conference -> conference.getStartDateTime().isBefore(dto.getEndDateTime()) &&
                        conference.getEndDateTime().isAfter(dto.getStartDateTime()))
                .toList();

        if (!overlappingConferences.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Room is not available at the specified time.");
        }

        Conference conference = new Conference();
        conference.setRoom(room);
        conference.setStartDateTime(dto.getStartDateTime());
        conference.setEndDateTime(dto.getEndDateTime());
        return conferenceRepository.save(conference);
    }

    public void cancelConference(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Conference not found"));

        if (conference.getStartDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot cancel past or ongoing conferences.");
        }

        registrationRepository.deleteAll(conference.getRegistrations());
        conferenceRepository.delete(conference);
    }

    public boolean checkConferenceAvailability(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Conference not found"));

        int maxCapacity = conference.getRoom().getCapacity();
        int registeredParticipants = conference.getRegistrations().size();

        return registeredParticipants < maxCapacity;
    }

    public Conference updateConference(Long conferenceId, ConferenceDto dto) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Conference not found"));

        if (!conference.getRoom().getId().equals(dto.getRoomId())) {
            Room room = roomRepository.findById(dto.getRoomId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Room not found"));
            conference.setRoom(room);
        }

        conference.setStartDateTime(dto.getStartDateTime());
        conference.setEndDateTime(dto.getEndDateTime());
        return conferenceRepository.save(conference);
    }

    public List<ConferenceDetailsDto> findAvailableConferences(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return conferenceRepository.findByStartDateTimeBetween(startDateTime, endDateTime)
                .stream()
                .map(entityDtoMapper::toConferenceDetailsDto)
                .collect(Collectors.toList());
    }
}
