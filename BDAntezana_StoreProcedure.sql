USE BDAntezana
GO
/* Store Procedure de Pasajero */
CREATE PROCEDURE sp_Pasajero
    @Nombre VARCHAR(MAX),
    @Apellido VARCHAR(MAX),
    @TipoDoc VARCHAR(MAX),
    @NumeroDoc VARCHAR(MAX),
    @Edad VARCHAR(MAX),
    @Origen VARCHAR(MAX),
    @Destino VARCHAR(MAX)
AS
    BEGIN
        INSERT INTO Pasajero
            (nomPas, apePas, tipoDocPas, numDocPas, edadPas, origenPas, destPas)
        VALUES (@Nombre, @Apellido, @TipoDoc, @NumeroDoc, @Edad, @Origen, @Destino);
    END
GO
/* Ejecutar SP */
EXEC sp_Pasajero @Nombre=Jose, @Apellido=Perez, @TipoDoc=DNI, @NumeroDoc=56878756, @Edad=20, @Origen=Lima, @Destino=Ica
EXEC sp_Pasajero @Nombre=Miguel, @Apellido=Rodriguez, @TipoDoc=DNI, @NumeroDoc=53247556, @Edad=37, @Origen=Chincha, @Destino=Lima
EXEC sp_Pasajero @Nombre=Enrique, @Apellido=Salas, @TipoDoc=DNI, @NumeroDoc=75778734, @Edad=40, @Origen=Lima, @Destino=Pisco
EXEC sp_Pasajero @Nombre=Daniel, @Apellido=Martinez, @TipoDoc=DNI, @NumeroDoc=68785410, @Edad=25, @Origen=Cañete, @Destino=Ica
EXEC sp_Pasajero @Nombre=Pedro, @Apellido=Pereira, @TipoDoc=DNI, @NumeroDoc=70459385, @Edad=60, @Origen=Pisco, @Destino=Lima
GO

/* Store Procedure de Trabajador */
CREATE PROCEDURE sp_Trabajador
    @Nombre VARCHAR(MAX),
    @Apellido VARCHAR(MAX),
    @Dni VARCHAR(MAX)
AS
    BEGIN
        INSERT INTO Trabajador
            (nomTrab, apeTrab, dniTrab)
        VALUES (@Nombre, @Apellido, @Dni);
    END
GO
/* Ejecutar SP */
EXEC sp_Trabajador @Nombre=Raul, @Apellido=Rodriguez, @Dni=57659840
EXEC sp_Trabajador @Nombre=Pedro, @Apellido=Casas, @Dni=47658709
EXEC sp_Trabajador @Nombre=Alexander, @Apellido=Meneces, @Dni=43675897
EXEC sp_Trabajador @Nombre=Pablo, @Apellido=Perez, @Dni=48796546
EXEC sp_Trabajador @Nombre=Ernesto, @Apellido=Rojas, @Dni=64201938
GO

/* Store Procedure de Sucursal */
CREATE PROCEDURE sp_Sucursal
    @Nombre VARCHAR(MAX),
    @IdTrabajador INT
AS
    BEGIN
        INSERT INTO Sucursal
            (nomSuc, Trabajador_idTrab)
        VALUES (@Nombre, @IdTrabajador);
    END
GO
/* Ejecutar SP */
EXEC sp_Sucursal @Nombre='Sucursal Lima', @IdTrabajador=1
EXEC sp_Sucursal @Nombre='Sucursal Cañete', @IdTrabajador=2
EXEC sp_Sucursal @Nombre='Sucursal Chincha', @IdTrabajador=3
EXEC sp_Sucursal @Nombre='Sucursal Pisco', @IdTrabajador=4
EXEC sp_Sucursal @Nombre='Sucursal Ica', @IdTrabajador=5
GO

/* Store Procedure de Contrato */
CREATE PROCEDURE sp_Contrato
    @FechContrato DATE,
    @FechViaje DATE,
    @HoraViaje INT,
    @NumAsiento INT,
    @CantAsiento INT,
    @PrecioViaje INT,
    @IdPasajero INT,
    @IdSucursal INT
AS
    BEGIN
        INSERT INTO Contrato
            (fechaCont, fechaVj, horaVj, numAs, CantAs, precioVj, Pasajero_idPas, Sucursal_idSuc)
        VALUES (@FechContrato, @FechViaje, @HoraViaje, @NumAsiento, @CantAsiento, @PrecioViaje, @IdPasajero, @IdSucursal);
    END
GO
/* Ejecutar SP */
EXEC sp_Contrato @FechContrato='2018/07/10', @FechViaje='2018/07/11', @HoraViaje=08, @NumAsiento=20, @CantAsiento=1, @PrecioViaje=15, @IdPasajero=1, @IdSucursal=1
EXEC sp_Contrato @FechContrato='2017/05/20', @FechViaje='2017/05/21', @HoraViaje=10, @NumAsiento=15, @CantAsiento=1, @PrecioViaje=15, @IdPasajero=2, @IdSucursal=2
EXEC sp_Contrato @FechContrato='2017/04/15', @FechViaje='2017/04/17', @HoraViaje=11, @NumAsiento=21, @CantAsiento=1, @PrecioViaje=15, @IdPasajero=3, @IdSucursal=3
EXEC sp_Contrato @FechContrato='2018/02/18', @FechViaje='2018/02/19', @HoraViaje=16, @NumAsiento=17, @CantAsiento=1, @PrecioViaje=15, @IdPasajero=4, @IdSucursal=4
EXEC sp_Contrato @FechContrato='2016/03/28', @FechViaje='2016/03/28', @HoraViaje=17, @NumAsiento=15, @CantAsiento=1, @PrecioViaje=15, @IdPasajero=5, @IdSucursal=5
GO