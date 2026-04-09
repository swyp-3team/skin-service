RENAME TABLE users_oauth TO user_oauth;
RENAME TABLE user_profiles TO user_profile;

ALTER TABLE users
    DROP COLUMN password,
    DROP COLUMN email,
    DROP COLUMN email_verified;

ALTER TABLE user_oauth
    CHANGE COLUMN provider_id provider_user_id VARCHAR(100) NOT NULL,
    ADD COLUMN email VARCHAR(200) AFTER user_id,
    DROP COLUMN access_token,
    DROP COLUMN refresh_token,
    DROP INDEX uk_provider_provider_id,
    ADD UNIQUE KEY uk_provider_provider_user_id (provider, provider_user_id);

ALTER TABLE user_profile
    DROP COLUMN skin_type,
    DROP COLUMN sensitivity,
    DROP COLUMN concerns,
    DROP COLUMN excluded_ingredients,
    DROP COLUMN smell_preferences,
    DROP COLUMN nickname,

    ADD COLUMN profile_image_url VARCHAR(200) AFTER user_id;

CREATE TABLE refresh_token
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT       NOT NULL,
    token       VARCHAR(500) NOT NULL,
    expiry_date DATETIME     NOT NULL,
    revoked     BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_refresh_token_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT uk_refresh_token_token UNIQUE (token)
);

CREATE TABLE skin_result
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id      BIGINT       NOT NULL,
    skin_type    VARCHAR(50)  NOT NULL,
    summary      VARCHAR(255) NOT NULL,
    diagnosed_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_skin_result_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE skin_result_group_score
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    skin_result_id   BIGINT       NOT NULL,
    ingredient_group VARCHAR(50)  NOT NULL,
    score            DOUBLE       NOT NULL,
    priority         INT          NOT NULL,
    reason           VARCHAR(255) NOT NULL,
    created_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_skin_result_group_score_skin_result_id FOREIGN KEY (skin_result_id) REFERENCES skin_result (id) ON DELETE CASCADE
);

CREATE TABLE product
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(200) NOT NULL,
    brand        VARCHAR(100),
    category     VARCHAR(50)  NOT NULL,
    price        INT          NOT NULL,
    description  TEXT,
    image_url    VARCHAR(500),
    purchase_url VARCHAR(500),
    active       BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE product_group_score
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id       BIGINT      NOT NULL,
    ingredient_group VARCHAR(50) NOT NULL,
    score            DOUBLE      NOT NULL,
    `rank`           INT         NOT NULL,
    created_at       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_product_group_score_product_id FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
);

CREATE TABLE routine_group
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id        BIGINT       NOT NULL,
    skin_result_id BIGINT       NOT NULL,
    title          VARCHAR(100) NOT NULL,
    summary        VARCHAR(500),
    caution        VARCHAR(500),
    created_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_routine_group_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_routine_group_skin_result_id FOREIGN KEY (skin_result_id) REFERENCES skin_result (id) ON DELETE CASCADE
);

CREATE TABLE routine
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    routine_group_id BIGINT      NOT NULL,
    routine_type     VARCHAR(20) NOT NULL,
    memo             VARCHAR(500),
    created_at       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_routine_routine_group_id FOREIGN KEY (routine_group_id) REFERENCES routine_group (id) ON DELETE CASCADE
);

CREATE TABLE routine_product
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    routine_id BIGINT   NOT NULL,
    product_id BIGINT   NOT NULL,
    sort_order INT      NOT NULL,
    note       VARCHAR(255),
    reason     VARCHAR(255),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_rp_routine_id FOREIGN KEY (routine_id) REFERENCES routine (id) ON DELETE CASCADE,
    CONSTRAINT fk_rp_product_id FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE,

    UNIQUE KEY uk_routine_sort_order (routine_id, sort_order),
    UNIQUE KEY uk_routine_product (routine_id, product_id)
);