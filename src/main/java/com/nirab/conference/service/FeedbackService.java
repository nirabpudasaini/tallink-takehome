package com.nirab.conference.service;

import com.nirab.conference.dto.FeedbackDto;
import com.nirab.conference.dto.FeedbackEntryDto;
import com.nirab.conference.model.Feedback;
import com.nirab.conference.repository.FeedbackRepository;
import com.nirab.conference.utils.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private EntityDtoMapper entityDtoMapper;

    public List<FeedbackDto> findFeedbackForConference(Long conferenceId) {
        return entityDtoMapper.toFeedbackDtos(feedbackRepository.findByConferenceId(conferenceId));
    }

    public Feedback addFeedback(FeedbackEntryDto dto, Long conferenceId) {
        Feedback feedback = new Feedback();
        feedback.setParticipantName(dto.getParticipantFname()+" "+ dto.getParticipantLname().charAt(0));
        feedback.setFeedbackContent(dto.getFeedbackContent());
        return feedbackRepository.save(feedback);
    }
}
