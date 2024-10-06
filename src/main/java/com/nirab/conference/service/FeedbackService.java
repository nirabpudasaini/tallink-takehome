package com.nirab.conference.service;

import com.nirab.conference.dto.FeedbackDto;
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
        return entityDtoMapper.toFeedbackDtos(feedbackRepository.findAll());
    }
}
