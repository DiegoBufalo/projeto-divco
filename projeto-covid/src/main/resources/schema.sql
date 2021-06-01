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


-- public.pergunta foreign keys

ALTER TABLE public.pergunta ADD CONSTRAINT fk9i03d0ikg76bwx7rc01hs752r FOREIGN KEY (id_resposta) REFERENCES resposta_assistente(id);