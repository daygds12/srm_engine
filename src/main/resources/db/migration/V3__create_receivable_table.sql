CREATE TABLE receivable (
    id BIGSERIAL PRIMARY KEY,
    face_value NUMERIC(19,2) NOT NULL,
    term INTEGER NOT NULL,
    type VARCHAR(50) NOT NULL,
    currency_id BIGINT NOT NULL,
    present_value NUMERIC(19,2),

    CONSTRAINT fk_receivable_currency
        FOREIGN KEY (currency_id)
        REFERENCES currency(id)
);