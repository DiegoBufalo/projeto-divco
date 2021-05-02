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

-- relatorio source

CREATE OR REPLACE VIEW relatorio
AS SELECT pessoa.data_vacinacao AS data,
    count(pessoa.data_vacinacao) AS media_diaria
   FROM pessoa
  WHERE pessoa.data_nascimento < to_timestamp('2020-01-01'::text, 'yyyy,mm,dd'::text) AND pessoa.data_nascimento > to_timestamp('1930-01-01'::text, 'yyyy,mm,dd'::text)
  GROUP BY pessoa.data_vacinacao;