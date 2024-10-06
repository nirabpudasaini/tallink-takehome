package com.nirab.conference.dto;

import java.util.Objects;

public class FeedbackDto {
    private Long id;
    private String participantName;
    private String feedbackContent;

    public FeedbackDto() {}

    public FeedbackDto(Long id, String participantName, String feedbackContent) {
        this.id = id;
        this.participantName = participantName;
        this.feedbackContent = feedbackContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "id=" + id +
                ", participantName='" + participantName + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackDto that = (FeedbackDto) o;
        return Objects.equals(id, that.id) && Objects.equals(participantName, that.participantName) && Objects.equals(feedbackContent, that.feedbackContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, participantName, feedbackContent);
    }
}
