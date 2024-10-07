package com.nirab.conference.intregration;

import com.nirab.conference.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RoomIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomRepository roomRepository;

    @BeforeEach
    public void setup() {
        roomRepository.deleteAll(); // Clean up before each test
    }

    @Test
    public void testCreateRoom() throws Exception {
        // JSON payload to create a room
        String roomJson = "{\"name\": \"Room A\", \"address\": \"Building 1\", \"status\": \"AVAILABLE\", \"capacity\": 50}";

        // Perform the POST request to create a room
        mockMvc.perform(post("/api/backoffice/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roomJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Room A"))
                .andExpect(jsonPath("$.address").value("Building 1"))
                .andExpect(jsonPath("$.status").value("AVAILABLE"))
                .andExpect(jsonPath("$.capacity").value(50));
    }


}
