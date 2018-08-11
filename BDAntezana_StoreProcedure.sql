USE BDAntezana
GO
/* Store Procedure de Pasajero */
CREATE PROCEDURE sp_Pasajero
    @Nombre VARCHAR(MAX),
    @Apellido VARCHAR(MAX),
    @Dni VARCHAR(MAX),
    @Edad VARCHAR(MAX)
AS
    BEGIN
        INSERT INTO Pasajero
            (nomPas, apePas, dniPas, edadPas)
        VALUES (@Nombre, @Apellido, @Dni, @Edad);
    END
GO
/* Ejecutar SP */
EXEC sp_Pasajero @Nombre=Jose, @Apellido=Perez, @Dni=56878756, @Edad=20
EXEC sp_Pasajero @Nombre=Miguel, @Apellido=Rodriguez, @Dni=53247556, @Edad=37
EXEC sp_Pasajero @Nombre=Enrique, @Apellido=Salas, @Dni=75778734, @Edad=40
EXEC sp_Pasajero @Nombre=Daniel, @Apellido=Martinez, @Dni=68785410, @Edad=25
EXEC sp_Pasajero @Nombre=Pedro, @Apellido=Pereira, @Dni=70459385, @Edad=60
GO

/* Store Procedure de Sucursal */
CREATE PROCEDURE sp_Sucursal
    @Nombre VARCHAR(MAX)
AS
    BEGIN
        INSERT INTO Sucursal
            (nomSuc)
        VALUES (@Nombre);
    END
GO
/* Ejecutar SP */
EXEC sp_Sucursal @Nombre='Sucursal Lima'
EXEC sp_Sucursal @Nombre='Sucursal Cañete'
EXEC sp_Sucursal @Nombre='Sucursal Chincha'
EXEC sp_Sucursal @Nombre='Sucursal Pisco'
EXEC sp_Sucursal @Nombre='Sucursal Ica'
GO

/* Store Procedure de Trabajador */
CREATE PROCEDURE sp_Trabajador
    @Nombre VARCHAR(MAX),
    @Apellido VARCHAR(MAX),
    @Dni VARCHAR(MAX),
    @IdSucursal INT
AS
    BEGIN
        INSERT INTO Trabajador
            (nomTrab, apeTrab, dniTrab, Sucursal_idSuc)
        VALUES (@Nombre, @Apellido, @Dni, @IdSucursal);
    END
GO
/* Ejecutar SP */
EXEC sp_Trabajador @Nombre=Raul, @Apellido=Rodriguez, @Dni=57659840, @IdSucursal=1
EXEC sp_Trabajador @Nombre=Pedro, @Apellido=Casas, @Dni=47658709, @IdSucursal=2
EXEC sp_Trabajador @Nombre=Alexander, @Apellido=Meneces, @Dni=43675897, @IdSucursal=3
EXEC sp_Trabajador @Nombre=Pablo, @Apellido=Perez, @Dni=48796546, @IdSucursal=4
EXEC sp_Trabajador @Nombre=Ernesto, @Apellido=Rojas, @Dni=64201938, @IdSucursal=5
GO

/* Store Procedure de Bus */
CREATE PROCEDURE sp_Bus
    @CantidadAs INT,
    @FechaVj DATE,
    @IdTrabajador INT
AS
    BEGIN
        INSERT INTO Bus
            (cantAs, fechaVj, Trabajador_idTrab)
        VALUES (@CantidadAs, @FechaVj, @IdTrabajador);
    END
GO
/* Ejecutar SP */
EXEC sp_Bus @CantidadAs=40, @FechaVj='2018/07/11', @IdTrabajador=1
EXEC sp_Bus @CantidadAs=30, @FechaVj='2017/05/21', @IdTrabajador=2
EXEC sp_Bus @CantidadAs=40, @FechaVj='2017/04/17', @IdTrabajador=3
EXEC sp_Bus @CantidadAs=40, @FechaVj='2018/02/19', @IdTrabajador=4
EXEC sp_Bus @CantidadAs=30, @FechaVj='2016/03/28', @IdTrabajador=5
GO

/* Store Procedure de Ruta */
CREATE PROCEDURE sp_Ruta
    @Origen VARCHAR(MAX),
    @Destino VARCHAR(MAX)
AS
    BEGIN
        INSERT INTO Ruta
            (origen, destino)
        VALUES (@Origen, @Destino);
    END
GO
/* Ejecutar SP */
EXEC sp_Ruta @Origen=Lima, @Destino=Cañete
EXEC sp_Ruta @Origen=Cañete, @Destino=Lima
EXEC sp_Ruta @Origen=Chincha, @Destino=Pisco
EXEC sp_Ruta @Origen=Pisco, @Destino=Ica
EXEC sp_Ruta @Origen=Ica, @Destino=Cañete
GO

/* Store Procedure de Contrato */
CREATE PROCEDURE sp_Contrato
    @FechContrato DATE,
    @HoraViaje INT,
    @NumAsiento INT,
    @PrecioViaje INT,
    @IdRuta INT,
    @IdPasajero INT,
    @IdBus INT
AS
    BEGIN
        INSERT INTO Contrato
            (fechaCont, horaVj, numAs, precioVj, Ruta_idRuta, Pasajero_idPas, Bus_idBus)
        VALUES (@FechContrato, @HoraViaje, @NumAsiento, @PrecioViaje, @IdRuta, @IdPasajero, @IdBus);
    END
GO
/* Ejecutar SP */
EXEC sp_Contrato @FechContrato='2018/07/10', @HoraViaje=08, @NumAsiento=20, @PrecioViaje=15, @IdRuta=1, @IdPasajero=1, @IdBus=1
EXEC sp_Contrato @FechContrato='2017/05/20', @HoraViaje=10, @NumAsiento=15, @PrecioViaje=15, @IdRuta=2, @IdPasajero=2, @IdBus=2
EXEC sp_Contrato @FechContrato='2017/04/15', @HoraViaje=11, @NumAsiento=21, @PrecioViaje=15, @IdRuta=3, @IdPasajero=3, @IdBus=3
EXEC sp_Contrato @FechContrato='2018/02/18', @HoraViaje=16, @NumAsiento=17, @PrecioViaje=15, @IdRuta=4, @IdPasajero=4, @IdBus=4
EXEC sp_Contrato @FechContrato='2016/03/28', @HoraViaje=17, @NumAsiento=15, @PrecioViaje=15, @IdRuta=5, @IdPasajero=5, @IdBus=5
GO