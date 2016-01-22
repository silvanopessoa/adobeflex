spool logs\ddl.endereco.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
-------------------------------- GRUPO endereco -------------------------------
--------------------------------------------------------------------------------
-- Por padr�o SQL Plus e SQL Developer converte tudo que nao esteja entre aspas dupla para de lowercase para upper.
-- Maximo 30 caracteres e pode ter letras, numeros, _, $ e #. 
create table tb_pais(
	id								number(18,0)				not null 		constraint pk_pais		primary key,-- PK
	tx_pais							varchar2(20)				not null, -- Brasil
	in_sigla2						char(2)						not null,
	in_sigla3						char(3)						not null
);

create table tb_estado(
	id								number(18,0)				not null 		constraint pk_estado	primary key,-- PK
	tx_estado						varchar2(100)				not null,-- Sao Paulo
	in_sigla2						char(2)						not null,-- SP
	id_pais							number(18,0)				not null,-- FK
	id_regiao						number(18,0)				not null -- FK
);

create table tb_regiao(
	id								number(18,0)				not null 		constraint pk_regiao	primary key,-- PK
	tx_regiao						varchar2(20)				not null
);

create table tb_cidade(
	--Id da cidade conforme o IBGE
	id								number(18,0)				not null		constraint pk_cidade	primary key,-- 1
	tx_cidade						varchar2(100)				not null,-- Sao Paulo
	id_estado						number(18,0)				not null,-- FK
	constraint fk_cidade_estado		foreign key(id_estado) 		references tb_estado(id)
);

create table tb_bairro(
	id								number(18,0)				not null		constraint pk_bairro	primary key,-- 1
	tx_bairro						varchar2(200)				not null,--Vila Maria
	in_oficial						number(1)					default '0'					not null,-- 1=OFICIAL /0= NAO OFICIAL
	id_cidade						number(18,0)				not null
);

alter table tb_bairro add constraint ck_bairro_oficial check(in_oficial in('1','0'));
-- 1 = BAIRRO OFICIAL
-- 0 = BAIRRO NAO OFICIAL

-- Verificar a necessidade do informar o lado da rua
create table tb_cep(
	id								number(18,0)				not null		constraint pk_cep	primary key,-- 1
	tx_cep							varchar2(8)					not null,-- 02168070
	in_oficial						number(1)					default '0' 				not null,-- 1=OFICIAL /0= NAO OFICIAL
	nr_faixa_inicial				varchar2(5)					not null,
	nr_faixa_final					varchar2(5)					not null,
	in_lado_rua						char(1)						default 'N' not null,-- P=PAR /I=IMPAR /N= NAO DEFINIDO
	id_bairro						number(18,0)				not null -- FK
);
alter table tb_cep add constraint ck_cep_oficial check(in_oficial in('1','0'));
-- 1 = CEP OFICIAL
-- 0 = CEP NAO OFICIAL

--Tipo de Rua = Rua, Avenida, Alameda.
create table tb_logradouro_tipo(
	id								number(18,0)				not null		constraint pk_logradouro_tipo		primary key,-- PK
	tx_logradouro_tipo				varchar2(60)				not null, 	--Rua/Avenida
	in_logradouro_tipo_abrev		char(5)						null		--R/Av
);

--Nome da Rua
create table tb_logradouro(
	id											number(18,0)							not null 	constraint pk_logradouro		primary key,	
	tx_logradouro								varchar2(200)							not null,	-- Rua do Jambo
	in_oficial									number(1)			default '0'			not null,-- 1=OFICIAL /0= NAO OFICIAL
	id_cep										number(18,0)							not null,-- FK
	id_logradouro_tipo							number(18,0)							not null-- FK
);
alter table tb_logradouro add constraint ck_logradouro_oficial check(in_oficial in('1','0'));
-- S = LOGRADOURO OFICIAL
-- N = LOGRADOURO NAO OFICIAL

create table tb_complemento_tipo(
	id								number(18,0)				not null 				constraint pk_complemento_tipo	primary key,
	tx_complemento_tipo				varchar2(200)				not null-- APTO/CASA/SOBRADO
);

create table tb_endereco_tipo(
	id									number(18,0)				not null			constraint pk_endereco_tipo		primary key,
	tx_endereco_tipo					varchar2(50)				not null--Residencial/Comercial/
);

create table tb_endereco(
	id									number(18,0)				not null			constraint pk_endereco		primary key,
	id_endereco_tipo					number(18,0)				not null,-- fk
	vl_numero							number(8,0)					not null,-- 45
	vl_bloco							number(8,0)						null,-- B/Casa Fundo
	tx_travessa_1						varchar2(200)					null,-- Rua Araritaguaba
	tx_travessa_2						varchar2(200)			 		null,-- Rua Morango
	tx_complemento						varchar2(200)					null,-- O numero antigo da casa era 250C
	tx_ponto_referencia					varchar2(200)				 	null, -- Viaduto curuca
	id_complemento_tipo					number(18,0)				not null,--fK
	id_pessoa                    		number(18,0)     			not null,--fk
	id_funcionario						number(18,0)     			not null,--fk
	dt_create                    		date             			not null,--Data do Cadastro
    dt_update                    		date                 		null,	 --Data de Atualizacao
    id_unidade							number(18,0)     			not null,--Unidade Escolar
	id_logradouro						number(18,0)				not null
);



-- FOREIGN KEY
alter table tb_endereco  	add constraint fk_endereco_complemento_tipo		foreign key(id_complemento_tipo)		references tb_complemento_tipo(id);
alter table tb_endereco  	add constraint fk_endereco_tipo					foreign key(tb_endereco_tipo)			references tb_endereco_tipo(id);
alter table tb_endereco  	add constraint fk_endereco_logradouro			foreign key(id_logradouro) 				references tb_logradouro(id);
alter table tb_logradouro 	add constraint fk_logradouro_logradouro_tipo	foreign key(id_logradouro_tipo) 		references tb_logradouro_tipo(id);
alter table tb_logradouro 	add constraint fk_logradouro_cep				foreign key(id_cep) 					references tb_cep(id);
alter table tb_estado 	  	add constraint fk_estado_regiao					foreign key(id_regiao) 					references tb_regiao(id);
alter table tb_estado 	  	add constraint fk_estado_pais 					foreign key(id_pais) 					references tb_pais(id);
alter table tb_cep 		  	add constraint fk_cep_bairro					foreign key(id_bairro) 					references tb_bairro(id);
alter table tb_bairro	  	add constraint fk_bairro_cidade					foreign key(id_cidade) 					references tb_cidade(id);

-- SEQUENCE
create sequence crm.sq_pais 				increment by 1 start with 100;
create sequence crm.sq_estado 				increment by 1 start with 100;
-- Uma sequence pode ser alterada atraves do alter sequence;
-- ALTER SEQUENCE crm.sq_estado   MAXVALUE 30;
create sequence crm.sq_cidade 				increment by 1 start with 500000;
create sequence crm.sq_regiao				increment by 1 start with 100;
create sequence crm.sq_bairro 				increment by 1 start with 100;
create sequence crm.sq_cep 					increment by 1 start with 100;
create sequence crm.sq_logradouro_tipo 		increment by 1 start with 100;
create sequence crm.sq_logradouro 			increment by 1 start with 100;
create sequence crm.sq_endereco 			increment by 1 start with 100;
create sequence crm.sq_endereco_tipo		increment by 1 start with 100;
create sequence crm.sq_complemento_tipo		increment by 1 start with 100;


spool off
exit