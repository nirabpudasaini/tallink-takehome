package com.nirab.conference.controller;

import com.nirab.conference.dto.RegistrationDto;
import com.nirab.conference.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conference/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationDto> registerParticipant(@RequestBody RegistrationDto dto) {
        RegistrationDto registrationDto = registrationService.registerParticipant(dto);
        return new ResponseEntity<>(registrationDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uniqueCode}")
    public ResponseEntity<Void> cancelRegistration(@PathVariable String uniqueCode) {
        registrationService.cancelRegistration(uniqueCode);
        return ResponseEntity.noContent().build();
    }
}
