
spool logs\ddl.modulo.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
---------------------------------- GRUPO MODULO --------------------------------
--------------------------------------------------------------------------------

create table tb_modulo(
	id		                 	number(18,0)     	not null         constraint pk_modulo primary key,
	tx_modulo					varchar2(100)		not null,
	tx_versao					varchar2(50)		not null,
	tx_observacao				varchar2(200)		not null
);

spool off
exit