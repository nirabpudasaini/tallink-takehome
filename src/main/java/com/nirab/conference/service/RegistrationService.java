package com.nirab.conference.service;

import com.nirab.conference.dto.RegistrationDto;
import com.nirab.conference.model.Conference;
import com.nirab.conference.model.Registration;
import com.nirab.conference.repository.ConferenceRepository;
import com.nirab.conference.repository.RegistrationRepository;
import com.nirab.conference.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private EntityDtoMapper entityDtoMapper;

    public RegistrationDto registerParticipant(RegistrationDto dto) {
        System.out.println(dto.toString());
        Conference conference = conferenceRepository.findById( dto.getConferenceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Conference not found"));

        Registration registration = entityDtoMapper.toRegistration(dto);
        registration.setUniqueCode(UUID.randomUUID().toString());
        registration.setConference(conference);

        if (conference.getRegistrations().size() >= conference.getRoom().getCapacity()) {
            throw new IllegalArgumentException("Conference room capacity is full.");
        }

        return entityDtoMapper.toRegistrationDto(registrationRepository.save(registration));
    }
}
