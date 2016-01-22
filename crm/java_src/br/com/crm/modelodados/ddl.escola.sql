spool logs\ddl.escola.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
---------------------------------- GRUPO ESCOLA --------------------------------
--------------------------------------------------------------------------------
create table tb_unidade(
	id						number(18,0)		not null		constraint pk_escola primary key,
	tx_unidade				varchar2(100)		not null
);

-- SEQUENCE
create sequence crm.sq_escola			       increment by 1 start with 100;

spool off
exit