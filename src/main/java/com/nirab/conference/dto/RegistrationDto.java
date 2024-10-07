package com.nirab.conference.dto;

import java.time.LocalDate;
import java.util.Objects;

public class RegistrationDto {
    private Long id;
    private Long conferenceId;
    private String participantFname;
    private String participantLname;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private String uniqueCode;

    public RegistrationDto() {}

    public RegistrationDto(Long id, Long conferenceId, String participantFname,
                           String participantLname, String gender, String email,
                           LocalDate dateOfBirth, String uniqueCode) {
        this.id = id;
        this.conferenceId = conferenceId;
        this.participantFname = participantFname;
        this.participantLname = participantLname;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.uniqueCode = uniqueCode;
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

    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "id=" + id +
                ", conferenceId=" + conferenceId +
                ", participantFname='" + participantFname + '\'' +
                ", participantLname='" + participantLname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", uniqueCode='" + uniqueCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDto that = (RegistrationDto) o;
        return Objects.equals(id, that.id) && Objects.equals(conferenceId, that.conferenceId) && Objects.equals(participantFname, that.participantFname) && Objects.equals(participantLname, that.participantLname) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(uniqueCode, that.uniqueCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conferenceId, participantFname, participantLname, gender, email, dateOfBirth, uniqueCode);
    }
}
