CREATE TABLE skin_result_concern
(
    skin_result_id BIGINT      NOT NULL,
    concern        VARCHAR(50) NOT NULL,

    PRIMARY KEY (skin_result_id, concern),

    CONSTRAINT fk_skin_result_concern_skin_result_id
        FOREIGN KEY (skin_result_id)
        REFERENCES skin_result (id)
        ON DELETE CASCADE
);