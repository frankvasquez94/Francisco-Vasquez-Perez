--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 9.6.9

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: lifebank_products; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA lifebank_products;


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: beneficiarios; Type: TABLE; Schema: lifebank_products; Owner: -
--

CREATE TABLE lifebank_products.beneficiarios (
    bnf_id integer NOT NULL,
    bnf_id_tipo_cuenta integer NOT NULL,
    bnf_id_user integer NOT NULL,
    bnf_num_cuenta character varying(20) NOT NULL,
    bnf_nombre character varying(80) NOT NULL,
    bnf_correo character varying(50) NOT NULL
);


--
-- Name: beneficiarios_bnf_id_seq; Type: SEQUENCE; Schema: lifebank_products; Owner: -
--

CREATE SEQUENCE lifebank_products.beneficiarios_bnf_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: beneficiarios_bnf_id_seq; Type: SEQUENCE OWNED BY; Schema: lifebank_products; Owner: -
--

ALTER SEQUENCE lifebank_products.beneficiarios_bnf_id_seq OWNED BY lifebank_products.beneficiarios.bnf_id;


--
-- Name: lb_users; Type: TABLE; Schema: lifebank_products; Owner: -
--

CREATE TABLE lifebank_products.lb_users (
    usr_id integer NOT NULL,
    usr_username character varying(20) NOT NULL,
    usr_password character varying(255) NOT NULL,
    usr_token character varying(255),
    usr_bloqueado boolean DEFAULT false,
    usr_intentos integer DEFAULT 0,
    usr_lastintento timestamp without time zone DEFAULT ('now'::text)::timestamp without time zone NOT NULL
);


--
-- Name: lb_users_usr_id_seq; Type: SEQUENCE; Schema: lifebank_products; Owner: -
--

CREATE SEQUENCE lifebank_products.lb_users_usr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: lb_users_usr_id_seq; Type: SEQUENCE OWNED BY; Schema: lifebank_products; Owner: -
--

ALTER SEQUENCE lifebank_products.lb_users_usr_id_seq OWNED BY lifebank_products.lb_users.usr_id;


--
-- Name: tipo_cuenta; Type: TABLE; Schema: lifebank_products; Owner: -
--

CREATE TABLE lifebank_products.tipo_cuenta (
    tcn_id integer NOT NULL,
    tcn_nombre character varying(50) NOT NULL
);


--
-- Name: tipo_cuenta_tcn_id_seq; Type: SEQUENCE; Schema: lifebank_products; Owner: -
--

CREATE SEQUENCE lifebank_products.tipo_cuenta_tcn_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tipo_cuenta_tcn_id_seq; Type: SEQUENCE OWNED BY; Schema: lifebank_products; Owner: -
--

ALTER SEQUENCE lifebank_products.tipo_cuenta_tcn_id_seq OWNED BY lifebank_products.tipo_cuenta.tcn_id;


--
-- Name: beneficiarios bnf_id; Type: DEFAULT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.beneficiarios ALTER COLUMN bnf_id SET DEFAULT nextval('lifebank_products.beneficiarios_bnf_id_seq'::regclass);


--
-- Name: lb_users usr_id; Type: DEFAULT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.lb_users ALTER COLUMN usr_id SET DEFAULT nextval('lifebank_products.lb_users_usr_id_seq'::regclass);


--
-- Name: tipo_cuenta tcn_id; Type: DEFAULT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.tipo_cuenta ALTER COLUMN tcn_id SET DEFAULT nextval('lifebank_products.tipo_cuenta_tcn_id_seq'::regclass);


--
-- Data for Name: beneficiarios; Type: TABLE DATA; Schema: lifebank_products; Owner: -
--

COPY lifebank_products.beneficiarios (bnf_id, bnf_id_tipo_cuenta, bnf_id_user, bnf_num_cuenta, bnf_nombre, bnf_correo) FROM stdin;
1	1	1	AE00870857664	Test	correo@gmail.com
\.


--
-- Name: beneficiarios_bnf_id_seq; Type: SEQUENCE SET; Schema: lifebank_products; Owner: -
--

SELECT pg_catalog.setval('lifebank_products.beneficiarios_bnf_id_seq', 1, true);


--
-- Data for Name: lb_users; Type: TABLE DATA; Schema: lifebank_products; Owner: -
--

COPY lifebank_products.lb_users (usr_id, usr_username, usr_password, usr_token, usr_bloqueado, usr_intentos, usr_lastintento) FROM stdin;
1	frank	test	\N	t	5	2019-05-12 12:33:53.381712
\.


--
-- Name: lb_users_usr_id_seq; Type: SEQUENCE SET; Schema: lifebank_products; Owner: -
--

SELECT pg_catalog.setval('lifebank_products.lb_users_usr_id_seq', 1, true);


--
-- Data for Name: tipo_cuenta; Type: TABLE DATA; Schema: lifebank_products; Owner: -
--

COPY lifebank_products.tipo_cuenta (tcn_id, tcn_nombre) FROM stdin;
1	personal
2	tarjeta de credito
3	prestamo
\.


--
-- Name: tipo_cuenta_tcn_id_seq; Type: SEQUENCE SET; Schema: lifebank_products; Owner: -
--

SELECT pg_catalog.setval('lifebank_products.tipo_cuenta_tcn_id_seq', 3, true);


--
-- Name: beneficiarios lb_beneficiarios_pk; Type: CONSTRAINT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.beneficiarios
    ADD CONSTRAINT lb_beneficiarios_pk PRIMARY KEY (bnf_id);


--
-- Name: tipo_cuenta lb_tipo_cuenta_pk; Type: CONSTRAINT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.tipo_cuenta
    ADD CONSTRAINT lb_tipo_cuenta_pk PRIMARY KEY (tcn_id);


--
-- Name: lb_users lb_users_pk; Type: CONSTRAINT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.lb_users
    ADD CONSTRAINT lb_users_pk PRIMARY KEY (usr_id);


--
-- Name: beneficiarios beneficiarios_bnf_id_tipo_cuenta_fk; Type: FK CONSTRAINT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.beneficiarios
    ADD CONSTRAINT beneficiarios_bnf_id_tipo_cuenta_fk FOREIGN KEY (bnf_id_tipo_cuenta) REFERENCES lifebank_products.tipo_cuenta(tcn_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: beneficiarios beneficiarios_bnf_id_user_fk; Type: FK CONSTRAINT; Schema: lifebank_products; Owner: -
--

ALTER TABLE ONLY lifebank_products.beneficiarios
    ADD CONSTRAINT beneficiarios_bnf_id_user_fk FOREIGN KEY (bnf_id_user) REFERENCES lifebank_products.lb_users(usr_id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

