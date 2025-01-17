package com.nirab.conference.controller;

import com.nirab.conference.dto.FeedbackDto;
import com.nirab.conference.dto.FeedbackEntryDto;
import com.nirab.conference.model.Feedback;
import com.nirab.conference.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/backoffice/feedback/{conferenceId}")
    public ResponseEntity<List<FeedbackDto>> findFeedback(@PathVariable Long conferenceId) {
        List<FeedbackDto> feedbacks = feedbackService.findFeedbackForConference(conferenceId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @PostMapping("/conference/feedback/{conferenceId}")
    public ResponseEntity<FeedbackEntryDto> addFeedback(@PathVariable Long conferenceId, @RequestBody FeedbackEntryDto dto) {
        Feedback feedback = feedbackService.addFeedback(dto, conferenceId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
