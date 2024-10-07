package com.nirab.conference.utils;

import com.nirab.conference.dto.ConferenceDetailsDto;
import com.nirab.conference.dto.FeedbackDto;
import com.nirab.conference.dto.RegistrationDto;
import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.Conference;
import com.nirab.conference.model.Feedback;
import com.nirab.conference.model.Registration;
import com.nirab.conference.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    List<RoomDto> toRoomDtos(List<Room> rooms);

    List<FeedbackDto> toFeedbackDtos(List<Feedback> feedbacks);

    @Mapping(source = "room.name", target = "roomName")
    @Mapping(source = "room.address", target = "roomLocation")
    @Mapping(expression = "java(conference.getRegistrations().size())", target = "registeredParticipants")
    ConferenceDetailsDto toConferenceDetailsDto(Conference conference);


    Registration toRegistration(RegistrationDto registrationDto);
    RegistrationDto toRegistrationDto(Registration registration);
}
