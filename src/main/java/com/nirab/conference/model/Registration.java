package com.nirab.conference.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String participantFname;
    private String participantLname;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private String uniqueCode;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public Registration() {
    }

    public Registration(Long id, String participantName, String gender, String email, LocalDate dateOfBirth, String uniqueCode, Conference conference) {
        this.id = id;
        this.participantFname = participantFname;
        this.participantLname = participantLname;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.uniqueCode = uniqueCode;
        this.conference = conference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", participantFname='" + participantFname + '\'' +
                ", participantLname='" + participantLname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", conference=" + conference +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(id, that.id) && Objects.equals(participantFname, that.participantFname) && Objects.equals(participantLname, that.participantLname) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(uniqueCode, that.uniqueCode) && Objects.equals(conference, that.conference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, participantFname, participantLname, gender, email, dateOfBirth, uniqueCode, conference);
    }
}
