CREATE SCHEMA 'HOTELCALIFORNIA';

CREATE TABLE `HOTELCALIFORNIA`.`HOTEL`(
	MATRICULA INT NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	VALOR_DIARIA NUMERIC(8,2),
    CIDADE VARCHAR(100) NOT NULL,
    ESTRELAS NUMERIC(2,1),
    PRIMARY KEY (MATRICULA)
);

CREATE TABLE `HOTELCALIFORNIA`.`CLIENTE`(
	CPF VARCHAR(11),
	NOME VARCHAR(100) NOT NULL,
	FONE VARCHAR(14),
    IDADE INT,
    EMAIL VARCHAR(100),
    MATRICULA INT NOT NULL,
	PRIMARY KEY (MATRICULA)
);

ALTER TABLE `HOTELCALIFORNIA`.`CLIENTE` ADD CONSTRAINT `FK_HOTEL` FOREIGN KEY ( `MATRICULA` ) REFERENCES `HOTELCALIFORNIA`.HOTEL ( `MATRICULA` ) ;