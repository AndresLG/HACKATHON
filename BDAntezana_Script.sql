-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-07-24 15:15:32.266
CREATE DATABASE BDAntezana
GO
USE BDAntezana
GO
-- tables
-- Table: Contrato
CREATE TABLE Contrato (
    idCont int  NOT NULL IDENTITY(1, 1),
    fechaCont date  NOT NULL,
    fechaVj date  NOT NULL,
    horaVj int  NOT NULL,
    numAs int  NOT NULL,
    CantAs int  NOT NULL,
    precioVj int  NOT NULL,
    Pasajero_idPas int  NOT NULL,
    Sucursal_idSuc int  NOT NULL,
    CONSTRAINT Contrato_pk PRIMARY KEY  (idCont)
);

-- Table: Pasajero
CREATE TABLE Pasajero (
    idPas int  NOT NULL IDENTITY(1, 1),
    nomPas varchar(40)  NOT NULL,
    apePas varchar(40)  NOT NULL,
    tipoDocPas varchar(20)  NOT NULL,
    numDocPas varchar(8)  NOT NULL,
    edadPas VARCHAR(2)  NOT NULL,
    origenPas varchar(20)  NOT NULL,
    destPas varchar(20)  NOT NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY  (idPas)
);

-- Table: Sucursal
CREATE TABLE Sucursal (
    idSuc int  NOT NULL IDENTITY(1, 1),
    nomSuc varchar(20)  NOT NULL,
    Trabajador_idTrab int  NOT NULL,
    CONSTRAINT Sucursal_pk PRIMARY KEY  (idSuc)
);

-- Table: Trabajador
CREATE TABLE Trabajador (
    idTrab int  NOT NULL IDENTITY(1, 1),
    nomTrab varchar(40)  NOT NULL,
    apeTrab varchar(40)  NOT NULL,
    dniTrab varchar(8)  NOT NULL,
    CONSTRAINT Trabajador_pk PRIMARY KEY  (idTrab)
);

-- foreign keys
-- Reference: Contrato_Pasajero (table: Contrato)
ALTER TABLE Contrato ADD CONSTRAINT Contrato_Pasajero
    FOREIGN KEY (Pasajero_idPas)
    REFERENCES Pasajero (idPas);

-- Reference: Contrato_Sucursal (table: Contrato)
ALTER TABLE Contrato ADD CONSTRAINT Contrato_Sucursal
    FOREIGN KEY (Sucursal_idSuc)
    REFERENCES Sucursal (idSuc);

-- Reference: Sucursal_Trabajador (table: Sucursal)
ALTER TABLE Sucursal ADD CONSTRAINT Sucursal_Trabajador
    FOREIGN KEY (Trabajador_idTrab)
    REFERENCES Trabajador (idTrab);

-- End of file.

