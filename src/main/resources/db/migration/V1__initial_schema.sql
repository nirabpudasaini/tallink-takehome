CREATE TABLE room (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE conference (
    id BIGSERIAL PRIMARY KEY,
    room_id BIGINT NOT NULL,
    start_date_time TIMESTAMP NOT NULL,
    end_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(id) ON DELETE CASCADE
);

CREATE TABLE registration (
    id BIGSERIAL PRIMARY KEY,
    participant_fname VARCHAR(255) NOT NULL,
    participant_lname VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    email VARCHAR(255),
    date_of_birth DATE,
    unique_code VARCHAR(50) UNIQUE NOT NULL,
    conference_id BIGINT NOT NULL,
    FOREIGN KEY (conference_id) REFERENCES conference(id) ON DELETE CASCADE
);

CREATE TABLE feedback (
    id BIGSERIAL PRIMARY KEY,
    conference_id BIGINT NOT NULL,
    participant_name VARCHAR(255) NOT NULL,
    feedback_content TEXT NOT NULL,
    FOREIGN KEY (conference_id) REFERENCES conference(id) ON DELETE CASCADE
);