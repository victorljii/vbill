CREATE TABLE IF NOT EXISTS USERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_date BIGINT,
    created_by VARCHAR(128),
    updated_date BIGINT,
    updated_by VARCHAR(128),
    user_name VARCHAR(128),
    password VARCHAR(128)
);