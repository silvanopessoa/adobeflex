
spool logs\ddl.funcionario.txt

connect crm/crm
--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
------------------------------- GRUPO FUNCIONARIO ------------------------------
--------------------------------------------------------------------------------
create table tb_funcionario(
    id			                   number(18,0)     not null         constraint pk_funcionario primary key,
    dt_create                      date             not null,--Data do Cadastro
    dt_update                      date                 null,--Data de Atualizacao
    in_ativo                       char(1)          default '1'     not null,
    id_pessoa                      number(18,0)     not null, --fk
    id_funcionario_tipo			   number(18,0)     not null --fk 
);

create table tb_funcionario_tipo(
	id							number(18,0)     not null   constraint pk_funcionario_tipo primary key,
	tx_funcionario_tipo		    varchar2(100)    not null-- Professor -coordenador - diretor 
);

-- SEQUENCE
create sequence crm.sq_funcionario			       increment by 1 start with 100;
create sequence crm.sq_funcionario_tipo  	       increment by 1 start with 100;
-- FOREIGN KEY
alter table tb_funcionario 	add constraint fk_funcionario_pessoa 	foreign key(id_pessoa) 	         references tb_pessoa(id);
alter table tb_funcionario 	add constraint fk_funcionario_tipo   	foreign key(id_funcionario_tipo) references tb_funcionario_tipo(id);

-- CHECK
alter table tb_funcionario add constraint ck_funcionario_ativo check(in_ativo in('0','1'));
-- 0 = DESATIVADO
-- 1 = ATIVADO

spool off
exit
