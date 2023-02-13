CREATE TABLE IF NOT EXISTS movie (
    id  INT NOT NULL AUTO_INCREMENT,
    name    VARCHAR(64)    NOT NULL,
    description    VARCHAR(256)    NOT NULL,
    format    ENUM('FULL', 'SERIES', 'SHORT')    NOT NULL,
    genre    VARCHAR(32)    NOT NULL,
    date    DATE   NOT NULL,
    PRIMARY KEY (id)
);