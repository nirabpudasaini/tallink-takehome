package com.nirab.conference.dto;

import java.util.Objects;

public class FeedbackEntryDto {
    private String participantFname;
    private String participantLname;
    private String feedbackContent;

    public FeedbackEntryDto() {}

    public FeedbackEntryDto(String participantFname, String participantLname, String feedbackContent) {
        this.participantFname = participantFname;
        this.participantLname = participantLname;
        this.feedbackContent = feedbackContent;
    }

    public String getParticipantFname() {
        return participantFname;
    }

    public void setParticipantFname(String participantFname) {
        this.participantFname = participantFname;
    }

    public String getParticipantLname() {
        return participantLname;
    }

    public void setParticipantLname(String participantLname) {
        this.participantLname = participantLname;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    @Override
    public String toString() {
        return "FeedbackEntryDto{" +
                "participantFname='" + participantFname + '\'' +
                ", participantLname='" + participantLname + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackEntryDto that = (FeedbackEntryDto) o;
        return Objects.equals(participantFname, that.participantFname) && Objects.equals(participantLname, that.participantLname) && Objects.equals(feedbackContent, that.feedbackContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantFname, participantLname, feedbackContent);
    }
}
