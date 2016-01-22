spool logs\ddl.turma.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
---------------------------------- GRUPO TURMA ---------------------------------
--------------------------------------------------------------------------------

create table tb_turma(
	id						 	number(18,0)		not null         constraint pk_turma primary key,
	tx_turma					varchar2(100)     	not null
);

create table tb_ano_letivo(
	id							 number(18,0)		not null         constraint pk_ano_letivo primary key,
	tx_ano_letivo				 varchar2(100)     	not null
);

create table tb_serie(
    id		                    number(18,0)		not null         constraint pk_serie primary key,
    tx_serie                    varchar2(200)     	not null,--2° ano/3° ano/9° ano
    id_modalidade_ensino        number(18,0)     	not null--fk
);

create table tb_modalidade_ensino(
    id					               number(18,0)    	not null         constraint pk_modalidade_ensino primary key,
    tx_modalidade_ensino               varchar2(200)     not null--Educação infantil/Ensino fundamental/Ensino médio/
);

-- SEQUENCE
create sequence crm.sq_turma			           increment by 1 start with 100;
create sequence crm.sq_serie			       	   increment by 1 start with 100;
create sequence crm.sq_ano_letivo				   increment by 1 start with 100;
create sequence crm.sq_modalidade_ensino		   increment by 1 start with 100;

-- FOREIGN KEY
alter table tb_serie 	add constraint fk_serie_modalidade_ensino	foreign key(id_modalidade_ensino)		references tb_modalidade_ensino(id);

spool off
exit