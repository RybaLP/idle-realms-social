CREATE TABLE guilds (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    gold_vault BIGINT NOT NULL DEFAULT 0,
    instructor_lvl INT NOT NULL DEFAULT 1,
    owner_id UUID NOT NULL
);