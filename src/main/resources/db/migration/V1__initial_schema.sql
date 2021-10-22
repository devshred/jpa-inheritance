CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE payload
(
    id           bigint NOT NULL,
    account_name VARCHAR(255),
    profile_name VARCHAR(255),
    dtype        VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE record
(
    id    VARCHAR(255) NOT NULL,
    dtype VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE record_states
(
    record_id  VARCHAR(255) NOT NULL,
    states_id  bigint       NOT NULL UNIQUE,
    states_key VARCHAR(255) NOT NULL,
    PRIMARY KEY (record_id, states_key),
    FOREIGN KEY (states_id) REFERENCES payload,
    FOREIGN KEY (record_id) REFERENCES record
);

CREATE INDEX idx_record_states_states_key ON record_states (states_key);
