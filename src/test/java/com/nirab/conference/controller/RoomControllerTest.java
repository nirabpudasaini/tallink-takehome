package com.nirab.conference.controller;

import com.nirab.conference.dto.RoomDto;
import com.nirab.conference.model.RoomStatus;
import com.nirab.conference.service.RoomService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomControllerTest {
    private final MockMvc mockMvc;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    public RoomControllerTest() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
    }

    @Test
    public void testGetAllRooms() throws Exception {
        RoomDto roomDTO = new RoomDto();
        roomDTO.setName("Room A");
        roomDTO.setAddress("Location A");
        roomDTO.setCapacity(100);
        roomDTO.setStatus(RoomStatus.AVAILABLE);

        when(roomService.findAllRooms()).thenReturn(Collections.singletonList(roomDTO));

        mockMvc.perform(get("/api/backoffice/rooms")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name': 'Room A', 'address': 'Location A', 'capacity': 100, 'status': 'AVAILABLE'}]"));
    }
}
