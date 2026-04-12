ALTER TABLE user_profile
    ADD COLUMN nickname VARCHAR(200) NOT NULL AFTER user_id;