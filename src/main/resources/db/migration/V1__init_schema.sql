-- 1. 유저 기본 테이블 (인증 정보)
CREATE TABLE users
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    email          VARCHAR(200) NOT NULL UNIQUE,
    email_verified BOOLEAN               DEFAULT FALSE,
    password       VARCHAR(255),                              -- 소셜 전용 유저일 경우 NULL 허용
    role           VARCHAR(20)  NOT NULL DEFAULT 'ROLE_USER', -- 'USER', 'ADMIN'
    created_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. 소셜 로그인 정보 테이블
CREATE TABLE users_oauth
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id       BIGINT       NOT NULL,
    provider      VARCHAR(20)  NOT NULL, -- 'google', 'kakao' 등
    provider_id   VARCHAR(100) NOT NULL, -- 소셜 플랫폼의 고유 ID
    access_token  TEXT,
    refresh_token TEXT,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- 외래 키 설정: 유저 삭제 시 관련 소셜 정보도 삭제
    CONSTRAINT fk_oauth_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,

    -- 인덱스 설정
    UNIQUE KEY uk_provider_provider_id (provider, provider_id),
    UNIQUE KEY uk_user_id_provider (user_id, provider)
);

-- 3. 유저 상세 프로필
CREATE TABLE user_profiles
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id              BIGINT   NOT NULL UNIQUE,
    nickname             VARCHAR(50),
    skin_type            VARCHAR(50),
    sensitivity          INT,
    concerns             JSON, -- ['여드름', '미백'] 등
    excluded_ingredients JSON,
    smell_preferences    JSON,
    created_at           DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at           DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- 외래 키 설정: 유저 삭제 시 프로필도 삭제
    CONSTRAINT fk_profile_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);