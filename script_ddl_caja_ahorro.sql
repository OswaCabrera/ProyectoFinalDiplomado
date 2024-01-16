create table if not exists ESTATUS_CUENTA
(
    ESTATUS_CUENTA_ID int auto_increment
        primary key,
    NOMBRE            varchar(40) not null,
    DESCRIPCION       text        not null
);

create table if not exists ESTATUS_PRESTAMOS
(
    ESTATUS_PRESTAMOS_ID int auto_increment
        primary key,
    NOMBRE               varchar(40) not null,
    DESCRIPCION          text        not null
);

create table if not exists ESTATUS_TRANSACCION
(
    ESTATUS_TRANSACCION_ID int auto_increment
        primary key,
    NOMBRE                 varchar(40) not null,
    DESCRIPCION            text        not null
);

create table if not exists PRESTAMO
(
    PRESTAMO_ID          int auto_increment
        primary key,
    MENSUALIDADES        int default 1 not null
        check (`MENSUALIDADES` > 0),
    INTERES              int           not null,
    MONTO_PAGAR          int           not null,
    MONTO_ORIGINAL       int           not null
        check (`MONTO_ORIGINAL` > 0),
    FECHA_PETICION       datetime      not null,
    USUARIO_ID           int           null,
    ESTATUS_PRESTAMOS_ID int           not null,
    CANTIDAD_PAGADA      int default 0 null,
    constraint RefESTATUS_PRESTAMOS8
        foreign key (ESTATUS_PRESTAMOS_ID) references ESTATUS_PRESTAMOS (ESTATUS_PRESTAMOS_ID)
);

create table if not exists HISTORICO_ESTATUS_PRESTAMOS
(
    HISTORICO_ESTATUS_PRESTAMOS_ID int auto_increment
        primary key,
    DEUDA                          int      not null,
    FECHA_ACTUALIZACION            datetime not null,
    ESTATUS_PRESTAMOS_ID           int      not null,
    PRESTAMO_ID                    int      not null,
    constraint RefESTATUS_PRESTAMOS9
        foreign key (ESTATUS_PRESTAMOS_ID) references ESTATUS_PRESTAMOS (ESTATUS_PRESTAMOS_ID),
    constraint RefPRESTAMO10
        foreign key (PRESTAMO_ID) references PRESTAMO (PRESTAMO_ID)
);

create table if not exists ROL
(
    ROL_ID      tinyint auto_increment
        primary key,
    NOMBRE      varchar(40) not null,
    DESCRIPCION varchar(40) not null
);

create table if not exists TIPO_TRANSACCION
(
    TIPO_TRANSACCION_ID tinyint auto_increment
        primary key,
    NOMBRE              varchar(40) not null,
    DESCRIPCION         text        not null
);

create table if not exists USUARIO
(
    USUARIO_ID        int auto_increment
        primary key,
    EMAIL             varchar(100)                                     not null,
    PASSWORD          char(250)                                        not null,
    APELLIDO_MATERNO  varchar(40)                                      not null,
    NUMERO_TELEFONICO varchar(12)                                      not null,
    NOMBRE            varchar(40)                                      not null,
    APELLIDO_PATERNO  varchar(40)                                      not null,
    ROL_ID            tinyint                                          not null,
    fotografia        varchar(100) default 'Sin_imagen_disponible.jpg' null,
    constraint USUARIO_EMAIL_UNIQUE
        unique (EMAIL),
    constraint USUARIO_TELEFONO_UNIQUE
        unique (NUMERO_TELEFONICO),
    constraint RefROL11
        foreign key (ROL_ID) references ROL (ROL_ID)
);

create table if not exists CUENTA
(
    CUENTA_ID         int auto_increment
        primary key,
    SALDO             int default 0 not null,
    FECHA_APERTURA    datetime      not null,
    USUARIO_ID        int           not null,
    ESTATUS_CUENTA_ID int           null,
    constraint RefESTATUS_CUENTA18
        foreign key (ESTATUS_CUENTA_ID) references ESTATUS_CUENTA (ESTATUS_CUENTA_ID),
    constraint RefUSUARIO3
        foreign key (USUARIO_ID) references USUARIO (USUARIO_ID)
);

create table if not exists HISTORICO_ESTATUS_CUENTA
(
    HISTORICO_ESTATUS_CUENTA_ID int auto_increment
        primary key,
    FECHA                       date not null,
    CUENTA_ID                   int  not null,
    ESTATUS_CUENTA_ID           int  not null,
    constraint RefCUENTA16
        foreign key (CUENTA_ID) references CUENTA (CUENTA_ID),
    constraint RefESTATUS_CUENTA17
        foreign key (ESTATUS_CUENTA_ID) references ESTATUS_CUENTA (ESTATUS_CUENTA_ID)
);

create table if not exists TRANSACCION
(
    TRANSACCION_ID         int auto_increment
        primary key,
    MONTO                  int                                              not null,
    FECHA                  datetime                                         not null,
    CUENTA_ID              int                                              not null,
    TIPO_TRANSACCION_ID    tinyint                                          null,
    ESTATUS_TRANSACCION_ID int                                              null,
    comprobante            varchar(100) default 'Sin_imagen_disponible.jpg' null,
    constraint RefCUENTA5
        foreign key (CUENTA_ID) references CUENTA (CUENTA_ID),
    constraint RefESTATUS_TRANSACCION21
        foreign key (ESTATUS_TRANSACCION_ID) references ESTATUS_TRANSACCION (ESTATUS_TRANSACCION_ID),
    constraint RefTIPO_TRANSACCION15
        foreign key (TIPO_TRANSACCION_ID) references TIPO_TRANSACCION (TIPO_TRANSACCION_ID)
);

create table if not exists HISTORICO_ESTATUS_TRANSACCION
(
    HISTORICO_ESTATUS_TRANSACCION_ID int auto_increment
        primary key,
    FECHA                            date not null,
    ESTATUS_TRANSACCION_ID           int  not null,
    TRANSACCION_ID                   int  not null,
    constraint RefESTATUS_TRANSACCION20
        foreign key (ESTATUS_TRANSACCION_ID) references ESTATUS_TRANSACCION (ESTATUS_TRANSACCION_ID),
    constraint RefTRANSACCION24
        foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
);

create table if not exists TRANSACCION_ABONO_AHORRO
(
    TRANSACCION_ID int auto_increment
        primary key,
    DIAS_ATRASO    tinyint null,
    constraint RefTRANSACCION13
        foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
);

create table if not exists TRANSACCION_PAGO_PRESTAMO
(
    TRANSACCION_ID int auto_increment
        primary key,
    PRESTAMO_ID    int not null,
    constraint RefPRESTAMO14
        foreign key (PRESTAMO_ID) references PRESTAMO (PRESTAMO_ID),
    constraint RefTRANSACCION12
        foreign key (TRANSACCION_ID) references TRANSACCION (TRANSACCION_ID)
);


