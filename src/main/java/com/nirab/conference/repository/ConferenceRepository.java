package com.nirab.conference.repository;

import com.nirab.conference.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findByRoomId(Long roomId);
}
