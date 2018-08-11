-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-08-10 22:26:40.565

-- tables
-- Table: Bus
CREATE TABLE Bus (
    idBus int  NOT NULL IDENTITY(1, 1),
    cantAs int  NULL,
    fechaVj date  NULL,
    Trabajador_idTrab int  NOT NULL,
    CONSTRAINT Bus_pk PRIMARY KEY  (idBus)
);

-- Table: Contrato
CREATE TABLE Contrato (
    idCont int  NOT NULL IDENTITY(1, 1),
    fechaCont date  NULL,
    horaVj int  NULL,
    numAs int  NULL,
    precioVj int  NULL,
    Ruta_idRuta int  NOT NULL,
    Pasajero_idPas int  NOT NULL,
    Bus_idBus int  NOT NULL,
    CONSTRAINT Contrato_pk PRIMARY KEY  (idCont)
);

-- Table: Pasajero
CREATE TABLE Pasajero (
    idPas int  NOT NULL IDENTITY(1, 1),
    nomPas varchar(40)  NULL,
    apePas varchar(40)  NULL,
    dniPas varchar(8)  NULL,
    edadPas varchar(2)  NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY  (idPas)
);

-- Table: Ruta
CREATE TABLE Ruta (
    idRuta int  NOT NULL IDENTITY(1, 1),
    origen varchar(20)  NULL,
    destino varchar(20)  NULL,
    CONSTRAINT Ruta_pk PRIMARY KEY  (idRuta)
);

-- Table: Sucursal
CREATE TABLE Sucursal (
    idSuc int  NOT NULL IDENTITY(1, 1),
    nomSuc varchar(20)  NULL,
    CONSTRAINT Sucursal_pk PRIMARY KEY  (idSuc)
);

-- Table: Trabajador
CREATE TABLE Trabajador (
    idTrab int  NOT NULL IDENTITY(1, 1),
    nomTrab varchar(40)  NULL,
    apeTrab varchar(40)  NULL,
    dniTrab varchar(8)  NULL,
    Sucursal_idSuc int  NOT NULL,
    CONSTRAINT Trabajador_pk PRIMARY KEY  (idTrab)
);

-- foreign keys
-- Reference: Bus_Trabajador (table: Bus)
ALTER TABLE Bus ADD CONSTRAINT Bus_Trabajador
    FOREIGN KEY (Trabajador_idTrab)
    REFERENCES Trabajador (idTrab);

-- Reference: Contrato_Bus (table: Contrato)
ALTER TABLE Contrato ADD CONSTRAINT Contrato_Bus
    FOREIGN KEY (Bus_idBus)
    REFERENCES Bus (idBus);

-- Reference: Contrato_Pasajero (table: Contrato)
ALTER TABLE Contrato ADD CONSTRAINT Contrato_Pasajero
    FOREIGN KEY (Pasajero_idPas)
    REFERENCES Pasajero (idPas);

-- Reference: Contrato_Ruta (table: Contrato)
ALTER TABLE Contrato ADD CONSTRAINT Contrato_Ruta
    FOREIGN KEY (Ruta_idRuta)
    REFERENCES Ruta (idRuta);

-- Reference: Trabajador_Sucursal (table: Trabajador)
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Sucursal
    FOREIGN KEY (Sucursal_idSuc)
    REFERENCES Sucursal (idSuc);

-- End of file.

