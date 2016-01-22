
spool logs\ddl.inscricao.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
-------------------------------- GRUPO INSCRICAO -------------------------------
--------------------------------------------------------------------------------
create table tb_inscricao(
    id			                 number(18,0)     not null         constraint pk_inscricao primary key,
    dt_create                    date             not null,--Data do Cadastro
    dt_update                    date                 null,--Data de Atualizacao
    id_pessoa                    number(18,0)     not null,--fk
    id_inscricao_situacao        number(18,0)     not null,--fk
    id_funcionario               number(18,0)     not null,--fk
    id_unidade					 number(18,0)	  not null,--fk
    id_serie                     number(18,0)     not null --fk
);

create table tb_inscricao_situacao(
    id					          number(18,0)    not null         constraint pk_inscricao_situacao primary key,
    tx_inscricao_situacao         varchar2(200)   not null--Lista de Espera/documentos pendentes / Cancelados.
);

-- SEQUENCE
create sequence crm.sq_inscricao			       increment by 1 start with 100;
create sequence crm.sq_inscricao_situacao          increment by 1 start with 100;

-- FOREIGN KEY
alter table tb_inscricao 	add constraint fk_inscricao_pessoa 		  foreign key(id_pessoa) 				references tb_pessoa(id);
alter table tb_inscricao 	add constraint fk_inscricao_situacao 	  foreign key(id_inscricao_situacao) 	references tb_inscricao_situacao(id);
alter table tb_inscricao 	add constraint fk_inscricao_serie 	      foreign key(id_serie) 	            references tb_serie(id);
alter table tb_inscricao 	add constraint fk_inscricao_funcionario   foreign key(id_funcionario) 	        references tb_funcionario(id);
alter table tb_inscricao 	add constraint fk_inscricao_unidade		  foreign key(id_unidade) 				references tb_unidade(id);



spool off
exit