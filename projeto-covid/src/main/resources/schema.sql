-- pessoa definition

-- Drop table

-- DROP TABLE pessoa;

CREATE TABLE IF NOT EXISTS pessoa (
	id bigserial NOT NULL,
	cpf varchar(255) NULL,
	data_nascimento timestamp NULL,
	data_vacinacao timestamp NULL,
	email varchar(255) NULL,
	endereco varchar(255) NULL,
	nome varchar(255) NULL,
	prof_saude bool NULL,
	senha varchar(255) NULL,
	sobrenome varchar(255) NULL,
	tipo_usuario varchar(255) NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (id),
	CONSTRAINT uk_mc87q8fpvldpdyfo9o5633o5l UNIQUE (email),
	CONSTRAINT uk_nlwiu48rutiltbnjle59krljo UNIQUE (cpf)
);

-- resposta_assistente definition

-- Drop table

-- DROP TABLE resposta_assistente;

CREATE TABLE IF NOT EXISTS resposta_assistente (
	id bigserial NOT NULL,
	resposta varchar(255) NOT NULL,
	CONSTRAINT resposta_assistente_pkey PRIMARY KEY (id)
);

-- public.pergunta definition

-- Drop table

-- DROP TABLE public.pergunta;

CREATE TABLE public.pergunta (
	id bigserial NOT NULL,
	palavra_chave varchar(255) NULL,
	id_resposta int8 NULL,
	CONSTRAINT pergunta_pkey PRIMARY KEY (id)
);

-- public.roles definition


-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	id bigserial NOT NULL,
	name varchar(20) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);

-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id bigserial NOT NULL,
	email varchar(50) NULL,
	"password" varchar(120) NULL,
	username varchar(20) NULL,
	CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
	CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- public.user_roles definition

-- Drop table

-- DROP TABLE public.user_roles;

CREATE TABLE public.user_roles (
	user_id int8 NOT NULL,
	role_id int8 NOT NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id)
);


-- public.user_roles foreign keys

ALTER TABLE public.user_roles ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);
ALTER TABLE public.user_roles ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


-- public.pergunta foreign keys

ALTER TABLE public.pergunta ADD CONSTRAINT fk9i03d0ikg76bwx7rc01hs752r FOREIGN KEY (id_resposta) REFERENCES resposta_assistente(id);