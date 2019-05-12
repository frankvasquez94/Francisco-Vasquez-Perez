
begin transaction;

CREATE SCHEMA if not exists lifebank_products;

set search_path to lifebank_products;

drop  table if exists lifebank_products.lb_users;
drop  table if exists lifebank_products.tipo_cuenta;
drop  table if exists lifebank_products.beneficiarios;

create table lifebank_products.lb_users(
    usr_id serial not null,
    usr_username varchar(20) not null,
    usr_password varchar(255) not null,
    usr_token varchar(255),
    usr_bloqueado boolean default false,
    usr_intentos int default 0,
    usr_lastintento timestamp default localtimestamp not null,
    constraint lb_users_pk primary key(usr_id)
);


create table tipo_cuenta(
    tcn_id serial not null,
    tcn_nombre varchar(50) not null,
    constraint lb_tipo_cuenta_pk primary key(tcn_id)
);

create table beneficiarios(
    bnf_id serial not null,
    bnf_id_tipo_cuenta integer not null,
    bnf_id_user integer not null,
    bnf_num_cuenta varchar(20) not null,
    bnf_nombre varchar(80) not null,
    bnf_correo varchar(50) not null,    
    constraint lb_beneficiarios_pk primary key(bnf_id)
);

alter table beneficiarios add constraint beneficiarios_bnf_id_user_fk foreign key(bnf_id_user)
references lb_users(usr_id) on update cascade on delete restrict;

alter table beneficiarios add constraint beneficiarios_bnf_id_tipo_cuenta_fk foreign key(bnf_id_tipo_cuenta)
references tipo_cuenta(tcn_id) on update cascade on delete restrict;


commit;
