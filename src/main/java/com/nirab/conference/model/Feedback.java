package com.nirab.conference.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    private String participantName;
    private String feedbackContent;

    public Feedback() {
    }

    public Feedback(Long id, Conference conference, String participantName, String feedbackContent) {
        this.id = id;
        this.conference = conference;
        this.participantName = participantName;
        this.feedbackContent = feedbackContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
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
        return "Feedback{" +
                "id=" + id +
                ", conference=" + conference +
                ", participantName='" + participantName + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id) && Objects.equals(conference, feedback.conference) && Objects.equals(participantName, feedback.participantName) && Objects.equals(feedbackContent, feedback.feedbackContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conference, participantName, feedbackContent);
    }
}
