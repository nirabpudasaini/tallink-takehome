package com.nirab.conference.controller;

import com.nirab.conference.dto.ConferenceDto;
import com.nirab.conference.model.Conference;
import com.nirab.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @PostMapping("/backoffice/conferences")
    public ResponseEntity<ConferenceDto> createConference(@RequestBody ConferenceDto dto) {
        Conference conference = conferenceService.createConference(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/backoffice/conferences/{conferenceId}")
    public ResponseEntity<Void> cancelConference(@PathVariable Long conferenceId) {
        conferenceService.cancelConference(conferenceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/backoffice/conferences/available/{conferenceId}")
    public ResponseEntity<String> checkConferenceAvailability(@PathVariable Long conferenceId) {
        boolean isAvailable = conferenceService.checkConferenceAvailability(conferenceId);
        String message = isAvailable
                ? "Conference available."
                : "Conference has reached its maximum capacity.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/backoffice/conferences/{conferenceId}")
    public ResponseEntity<ConferenceDto> updateConference(@PathVariable Long conferenceId, @RequestBody ConferenceDto dto) {
        Conference conference = conferenceService.updateConference(conferenceId, dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
