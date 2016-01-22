
spool logs\ddl.security.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
---------------------------------- GRUPO USERS ---------------------------------
--------------------------------------------------------------------------------

create table tb_usuario_sistema(
	id							number(18,0)	not null 		constraint pk_usuario_sistema primary key,
	tx_nome 					varchar2(50) 	not null,
	tx_senha 					varchar2(50) 	not null,
	id_pessoa 					number(18.0) 	not null,
	dt_create          			date            not null,--Data do Cadastro
    dt_update           		date                null,--Data de Atualizacao
	in_ativo 					number(1) 		not null
);

create table tb_usuario_sistema_permissao(
	id							number(18,0)	not null 		constraint pk_usuario_sistema_permissao primary key,
	tx_nome 					varchar2(50) 	not null,
	id_sistema_permissao		number(18,0)	not null 
);

create table tb_sistema_permissao(
	id							number(18,0)	not null 		constraint pk_sistema_permissao primary key,
	tx_sistema_permissao		varchar2(50) 	not null,
	tx_descricao				varchar2(100) 	not null
);
-- SEQUENCE
create sequence crm.sq_sistema_permissao     				increment by 1 start with 100;
--create sequence crm.sq_usuario_sistema_permissao    	increment by 1 start with 100;

-- FOREIGN KEY
alter table tb_usuario_sistema_permissao 	add constraint fk_usuario_sistema_permissao 	foreign key(id_sistema_permissao) 	references tb_usuario_sistema(id);
alter table tb_usuario_sistema				add constraint fk_usuario_sistema_pessoa 		foreign key(id_pessoa) 		references tb_pessoa(id);

spool off
exit
