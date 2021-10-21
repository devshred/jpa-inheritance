CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE accounts
(
    id         BIGINT NOT NULL,
    identifier VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE account
(
    id           BIGINT NOT NULL,
    parent_id    BIGINT,
    account_name VARCHAR(255),
    accounts_id  BIGINT,
    items_key    VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (parent_id) REFERENCES accounts
);
CREATE TABLE accounts_record
(
    id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE accounts_record_states
(
    accounts_record_id VARCHAR(255) NOT NULL,
    states_id          BIGINT       NOT NULL UNIQUE,
    states_key         VARCHAR(255) NOT NULL,
    PRIMARY KEY (accounts_record_id, states_key),
    FOREIGN KEY (states_id) REFERENCES accounts,
    FOREIGN KEY (accounts_record_id) REFERENCES accounts_record

);

CREATE TABLE profile
(
    id           BIGINT NOT NULL,
    profile_name VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE profile_record
(
    id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE profile_record_states
(
    profile_record_id VARCHAR(255) NOT NULL,
    states_id         BIGINT       NOT NULL UNIQUE,
    states_key        VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_record_id, states_key),
    FOREIGN KEY (states_id) REFERENCES profile,
    FOREIGN KEY (profile_record_id) REFERENCES profile_record
);

CREATE INDEX idx_accounts_record_states_states_key ON accounts_record_states (states_key);
CREATE INDEX idx_profile_record_states_states_key ON profile_record_states (states_key);
