CREATE SCHEMA IF NOT EXISTS "appname";

CREATE SEQUENCE IF NOT EXISTS "appname".sq_exemplo  	 INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS "appname".sq_log_endpoint  INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE IF NOT EXISTS "appname".exemplo
(
	id INT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	CONSTRAINT exemplo_pkey PRIMARY KEY (id)
);
INSERT INTO "appname".exemplo VALUES(1, 'Valor 1') ON CONFLICT (id) DO NOTHING;
INSERT INTO "appname".exemplo VALUES(2, 'Valor 2') ON CONFLICT (id) DO NOTHING;

CREATE TABLE IF NOT EXISTS "appname".log_endpoint
(
	id BIGINT NOT NULL,
	timestamp TIMESTAMP NOT NULL,
	time_taken BIGINT NOT NULL,
    status INT NOT NULL,
    method VARCHAR(50) NOT NULL,
    uri TEXT NOT NULL,
    host VARCHAR(255) NOT NULL,
    user_agent TEXT NOT NULL,
    referer TEXT,
    username VARCHAR(255),
    remote_address VARCHAR(50) NOT NULL,
    request_body TEXT,
    response_body TEXT,
   	CONSTRAINT log_endpoint_pkey PRIMARY KEY (id)
);