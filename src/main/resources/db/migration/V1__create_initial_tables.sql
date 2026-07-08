CREATE TABLE currency (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(3) NOT NULL UNIQUE,
    description VARCHAR(50) NOT NULL
);

CREATE TABLE exchange_rate (
    id BIGSERIAL PRIMARY KEY,

    from_currency_id BIGINT NOT NULL,
    to_currency_id BIGINT NOT NULL,

    rate NUMERIC(19,8) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_exchange_rate_from
        FOREIGN KEY (from_currency_id)
        REFERENCES currency(id),

    CONSTRAINT fk_exchange_rate_to
        FOREIGN KEY (to_currency_id)
        REFERENCES currency(id)
);