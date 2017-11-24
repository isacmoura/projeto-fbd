--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-23 21:56:38

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2827 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 24623)
-- Name: equipamentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE equipamentos (
    idequipamentos integer NOT NULL,
    nome character varying(50),
    quantidade integer
);


ALTER TABLE equipamentos OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24647)
-- Name: equipamentos_has_posto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE equipamentos_has_posto (
    "equipamentos_idEquipamentos" integer NOT NULL,
    "posto_idPosto" integer NOT NULL
);


ALTER TABLE equipamentos_has_posto OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24621)
-- Name: equipamentos_idequipamentos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE equipamentos_idequipamentos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE equipamentos_idequipamentos_seq OWNER TO postgres;

--
-- TOC entry 2828 (class 0 OID 0)
-- Dependencies: 196
-- Name: equipamentos_idequipamentos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipamentos_idequipamentos_seq OWNED BY equipamentos.idequipamentos;


--
-- TOC entry 200 (class 1259 OID 24637)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE paciente (
    cpf character varying(14) NOT NULL,
    nome character varying(150),
    endereco character varying(170),
    complemento character varying(16),
    cidade character varying(80),
    estado character(2),
    datanasc date
);


ALTER TABLE paciente OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24631)
-- Name: posto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE posto (
    idposto integer NOT NULL,
    nome character varying(50),
    cidade character varying(80),
    estado character(2),
    endereco character varying(170)
);


ALTER TABLE posto OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24629)
-- Name: posto_idposto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE posto_idposto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE posto_idposto_seq OWNER TO postgres;

--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 198
-- Name: posto_idposto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE posto_idposto_seq OWNED BY posto.idposto;


--
-- TOC entry 2684 (class 2604 OID 24626)
-- Name: equipamentos idequipamentos; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipamentos ALTER COLUMN idequipamentos SET DEFAULT nextval('equipamentos_idequipamentos_seq'::regclass);


--
-- TOC entry 2685 (class 2604 OID 24634)
-- Name: posto idposto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posto ALTER COLUMN idposto SET DEFAULT nextval('posto_idposto_seq'::regclass);


--
-- TOC entry 2816 (class 0 OID 24623)
-- Dependencies: 197
-- Data for Name: equipamentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY equipamentos (idequipamentos, nome, quantidade) FROM stdin;
\.


--
-- TOC entry 2820 (class 0 OID 24647)
-- Dependencies: 201
-- Data for Name: equipamentos_has_posto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY equipamentos_has_posto ("equipamentos_idEquipamentos", "posto_idPosto") FROM stdin;
\.


--
-- TOC entry 2819 (class 0 OID 24637)
-- Dependencies: 200
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY paciente (cpf, nome, endereco, complemento, cidade, estado, datanasc) FROM stdin;
\.


--
-- TOC entry 2818 (class 0 OID 24631)
-- Dependencies: 199
-- Data for Name: posto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY posto (idposto, nome, cidade, estado, endereco) FROM stdin;
\.


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 196
-- Name: equipamentos_idequipamentos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('equipamentos_idequipamentos_seq', 1, false);


--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 198
-- Name: posto_idposto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('posto_idposto_seq', 1, false);


--
-- TOC entry 2693 (class 2606 OID 24651)
-- Name: equipamentos_has_posto equipamentos_has_posto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipamentos_has_posto
    ADD CONSTRAINT equipamentos_has_posto_pkey PRIMARY KEY ("equipamentos_idEquipamentos", "posto_idPosto");


--
-- TOC entry 2687 (class 2606 OID 24628)
-- Name: equipamentos equipamentos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipamentos
    ADD CONSTRAINT equipamentos_pk PRIMARY KEY (idequipamentos);


--
-- TOC entry 2691 (class 2606 OID 24641)
-- Name: paciente paciente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY paciente
    ADD CONSTRAINT paciente_pk PRIMARY KEY (cpf);


--
-- TOC entry 2689 (class 2606 OID 24636)
-- Name: posto posto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY posto
    ADD CONSTRAINT posto_pk PRIMARY KEY (idposto);


-- Completed on 2017-11-23 21:56:48

--
-- PostgreSQL database dump complete
--

