INSERT INTO caja_ahorro_bd.ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES ('Activa', 'La cuenta está activa y en buen estado.');
INSERT INTO caja_ahorro_bd.ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES ('Inactiva', 'La cuenta ha sido desactivada temporalmente.');
INSERT INTO caja_ahorro_bd.ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES ('Pendiente', 'La cuenta está pendiente de aprobación.');
INSERT INTO caja_ahorro_bd.ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES ('Bloqueada', 'La cuenta ha sido bloqueada debido a actividades sospechosas.');
INSERT INTO caja_ahorro_bd.ESTATUS_CUENTA (NOMBRE, DESCRIPCION) VALUES ('Cerrada', 'La cuenta ha sido cerrada permanentemente.');

INSERT INTO caja_ahorro_bd.ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES ('Pendiente', 'El préstamo está pendiente de aprobación.');
INSERT INTO caja_ahorro_bd.ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES ('Aprobado', 'El préstamo ha sido aprobado y está activo.');
INSERT INTO caja_ahorro_bd.ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES ('Rechazado', 'El préstamo ha sido rechazado.');
INSERT INTO caja_ahorro_bd.ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES ('Pagado', 'El préstamo ha sido completamente pagado.');
INSERT INTO caja_ahorro_bd.ESTATUS_PRESTAMOS (NOMBRE, DESCRIPCION) VALUES ('Vencido', 'El préstamo está vencido y pendiente de pago.');

INSERT INTO caja_ahorro_bd.ESTATUS_TRANSACCION (NOMBRE, DESCRIPCION) VALUES ('Exitosa', 'La transacción se ha completado con éxito.');
INSERT INTO caja_ahorro_bd.ESTATUS_TRANSACCION (NOMBRE, DESCRIPCION) VALUES ('Pendiente', 'La transacción está pendiente de procesamiento.');
INSERT INTO caja_ahorro_bd.ESTATUS_TRANSACCION (NOMBRE, DESCRIPCION) VALUES ('Rechazada', 'La transacción ha sido rechazada.');

INSERT INTO caja_ahorro_bd.TIPO_TRANSACCION (NOMBRE, DESCRIPCION) VALUES ('Abono a cuenta', 'Transacción para abonar a cuenta');
INSERT INTO caja_ahorro_bd.TIPO_TRANSACCION (NOMBRE, DESCRIPCION) VALUES ('Pago de prestamo', 'Transaccion para pagar un prestamo');

INSERT INTO caja_ahorro_bd.ROL (NOMBRE, DESCRIPCION) VALUES ('Admin', 'Rol de administrador.');
INSERT INTO caja_ahorro_bd.ROL (NOMBRE, DESCRIPCION) VALUES ('Usuario', 'Usuarios registrados.');
INSERT INTO caja_ahorro_bd.ROL (NOMBRE, DESCRIPCION) VALUES ('Moderador', 'Rol con permisos moderados.');
INSERT INTO caja_ahorro_bd.ROL (NOMBRE, DESCRIPCION) VALUES ('Editor', 'Editar contenido.');
INSERT INTO caja_ahorro_bd.ROL (NOMBRE, DESCRIPCION) VALUES ('Invitado', 'Usuarios no registrados o invitados.');

INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('usuario1@example.com', 'contrasena123', 'Gómez', '5534567890', 'Ana', 'Pérez', 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('usuario2@example.com', 'password456', 'López', '5576543210', 'Juan', 'Sánchez', 3, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('usuario3@example.com', 'pass789', 'Martínez', '5543210987', 'Laura', 'García', 1, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('oswaldo121oswaldo@gmail.com', '$2a$10$PRN06Rzo1Jihvngs18OqZ.jXNWwZvvpJ3dI1CGDuttUpoP86SKmQG', 'Pérez', '5586808075', 'Oswaldo', 'Cabrera', 1, '5_foto_perfil3.jpeg');
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('oswaldo121oswaldo@example.com', '$2a$10$D2UQSEd/zkrkU6hdtbWhduwCfkE6oOeYqN0i1S1lZyFjV2DX5Pagi', 'Cabrera', '5515636281', 'José Luis', 'Lopéz', 2, null);
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('marco@prueba', '$2a$10$rj5loCqIGP.yNAgYs9TJLOgwOePOB1T3vtvOsBsaLeEGs8zed7CGi', 'Hernandez', '5555667788', 'Marco', 'Juarez', 2, null);
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('prueba2@gmail.com', '$2a$10$QZYgKcqJ64qOz3aXKK9JnObwAODYe6CfELmHtxAts97tAf6LTEYAG', 'Saturnino', '5555667711', 'Julio', 'Lopez', 2, null);
INSERT INTO caja_ahorro_bd.USUARIO (EMAIL, PASSWORD, APELLIDO_MATERNO, NUMERO_TELEFONICO, NOMBRE, APELLIDO_PATERNO, ROL_ID, fotografia) VALUES ('sofia@gmail.com', '$2a$10$h4lN80yzIM.wJ2hRhNT9l.h1ldFwUFZqtVIGZsMIwCr1d2Wol1HEe', 'Suarez', '5512345678', 'Sofía', 'Bueno', 2, '12_foto-perfil2.jpeg');

INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (1000, '2023-01-01 08:00:00', 1, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (1500, '2023-02-15 10:30:00', 2, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (2000, '2023-03-20 15:45:00', 3, 2);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (1778, '2024-01-03 20:06:52', 5, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (0, '2024-01-13 02:07:03', 8, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (0, '2024-01-13 09:37:14', 9, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (0, '2024-01-13 09:48:53', 11, 1);
INSERT INTO caja_ahorro_bd.CUENTA (SALDO, FECHA_APERTURA, USUARIO_ID, ESTATUS_CUENTA_ID) VALUES (0, '2024-01-14 15:48:31', 12, 1);

INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (500, '2023-01-01 08:30:00', 1, 2, 1, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1000, '2023-02-15 10:45:00', 2, 1, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1500, '2023-03-20 15:00:00', 3, 1, 3, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (200, '2023-04-10 12:15:00', 1, 1, 1, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1200, '2023-05-05 09:30:00', 2, 1, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (800, '2023-06-20 11:45:00', 1, 2, 3, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (2500, '2023-07-15 14:00:00', 2, 1, 1, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (600, '2023-08-10 16:15:00', 3, 2, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1800, '2023-09-25 13:30:00', 3, 1, 3, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (300, '2023-10-30 10:45:00', 1, 2, 1, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1000, '2024-01-07 00:06:20', 4, 1, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (200, '2024-01-07 22:23:26', 4, 1, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (20, '2024-01-07 22:24:35', 4, 2, 2, 'Sin_imagen_disponible.jpg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1000, '2024-01-07 23:22:21', 4, 1, 2, 'logo_inah.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (200001, '2024-01-07 23:22:57', 4, 1, 2, 'modeloER.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1, '2024-01-07 23:24:20', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (2, '2024-01-07 23:28:06', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (34, '2024-01-07 23:35:58', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (3, '2024-01-07 23:37:44', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (45, '2024-01-07 23:42:43', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (66, '2024-01-07 23:43:05', 4, 1, 2, 'logo_inah.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (3333, '2024-01-07 23:51:05', 4, 1, 2, null);
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (5666, '2024-01-07 23:58:04', 4, 1, 2, null);
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (778, '2024-01-12 00:37:56', 4, 1, 1, null);
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1313, '2024-01-08 00:04:09', 4, 1, 2, 'Flat-design-santa-claus-premium-vector-PNG.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (99, '2024-01-08 15:25:23', 4, 1, 2, 'modeloER.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (33, '2024-01-08 15:26:58', 4, 2, 2, 'logo_inicio.png11');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (22, '2024-01-13 00:49:31', 4, 2, 1, '30_logo_inicio.png11');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1000, '2024-01-12 15:06:03', 4, 1, 1, 'logo_inicio.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (55, '2024-01-12 00:17:13', 4, 2, 3, '32_logo_inicio.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (5, '2024-01-13 00:50:10', 4, 2, 1, '33_foto_perfil.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (5, '2024-01-13 01:31:56', 4, 2, 1, '34_logo_inah2.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (10800, '2024-01-13 01:57:04', 4, 2, 1, '35_foto_perfil2.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (300, '2024-01-14 19:45:09', 8, 2, 1, '36_foto-mujer.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (24, '2024-01-14 19:49:14', 8, 2, 2, '37_incoming-5A5B7E2B-6F8E-40DA-B101-28549B09A928.png');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (100, '2024-01-14 21:40:41', 4, 2, 2, '38_transferencia.jpeg');
INSERT INTO caja_ahorro_bd.TRANSACCION (MONTO, FECHA, CUENTA_ID, TIPO_TRANSACCION_ID, ESTATUS_TRANSACCION_ID, comprobante) VALUES (1000, '2024-01-15 00:54:32', 2, 1, 1, 'Sin_imagen_disponible.jpg');

INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-12', 2, 32);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-12', 2, 26);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-12', 2, 31);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 30);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 30);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 30);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 33);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 34);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-13', 2, 35);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-14', 2, 36);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_TRANSACCION (FECHA, ESTATUS_TRANSACCION_ID, TRANSACCION_ID) VALUES ('2024-01-15', 2, 2);

INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (0);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);
INSERT INTO caja_ahorro_bd.TRANSACCION_ABONO_AHORRO (DIAS_ATRASO) VALUES (null);

INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (12, 5, 12000, 10000, '2023-01-05 14:30:00', 1, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (6, 8, 8000, 7000, '2023-02-10 10:15:00', 2, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (24, 10, 24000, 20000, '2023-03-15 16:45:00', 3, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (18, 6, 18000, 15000, '2023-04-20 12:00:00', 1, 3, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (9, 7, 9000, 8000, '2023-05-25 09:30:00', 2, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (12, 4, 12000, 11000, '2023-06-30 13:45:00', 3, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (6, 9, 6000, 5000, '2023-07-05 11:00:00', 1, 3, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (24, 12, 30000, 25000, '2023-08-10 15:15:00', 2, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (18, 8, 18000, 16000, '2023-09-15 17:30:00', 3, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (9, 5, 9000, 7500, '2023-10-20 14:45:00', 1, 3, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (10, 8, 10800, 10000, '2024-01-05 12:48:34', 5, 4, 10822);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (1, 8, 10, 10, '2024-01-10 23:41:09', 5, 4, 10);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (1, 8, 108, 100, '2024-01-13 01:47:53', 5, 1, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (1, 8, 1800, 1000, '2024-01-14 16:45:39', 12, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (2, 8, 540, 500, '2024-01-14 19:37:36', 12, 1, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (1, 8, 324, 300, '2024-01-14 19:42:15', 12, 2, 300);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (12, 8, 108, 100, '2024-01-14 21:39:35', 5, 2, 0);
INSERT INTO caja_ahorro_bd.PRESTAMO (MENSUALIDADES, INTERES, MONTO_PAGAR, MONTO_ORIGINAL, FECHA_PETICION, USUARIO_ID, ESTATUS_PRESTAMOS_ID, CANTIDAD_PAGADA) VALUES (1, 8, 108, 100, '2024-01-15 00:34:10', 5, 1, 0);

INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES (10800, '2024-01-13 00:49:31', 2, 11);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES (10, '2024-01-13 00:50:10', 1, 12);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES (10, '2024-01-13 01:31:56', 1, 12);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES (10800, '2024-01-13 01:57:04', 2, 11);
INSERT INTO caja_ahorro_bd.HISTORICO_ESTATUS_PRESTAMOS (DEUDA, FECHA_ACTUALIZACION, ESTATUS_PRESTAMOS_ID, PRESTAMO_ID) VALUES (324, '2024-01-14 19:45:09', 2, 16);

INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (11);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (11);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (11);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (11);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (11);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (12);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (12);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (16);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (16);
INSERT INTO caja_ahorro_bd.TRANSACCION_PAGO_PRESTAMO (PRESTAMO_ID) VALUES (17);

