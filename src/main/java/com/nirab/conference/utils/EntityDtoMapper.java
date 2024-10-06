package com.nirab.conference.utils;

import com.nirab.conference.dto.FeedbackDto;
import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.Feedback;
import com.nirab.conference.model.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityDtoMapper {
    List<RoomDto> toRoomDtos(List<Room> rooms);
    List<FeedbackDto> toFeedbackDtos(List<Feedback> feedbacks);
}
