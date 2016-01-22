spool logs\ddl.relacionamento_tabelas.txt

connect crm/crm

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
---------------------------- RL PESSOA/DOCUMENTO ----------------------------
--------------------------------------------------------------------------------
alter table tb_documento add constraint fk_documento_pessoa foreign key(id_pessoa) references tb_pessoa(id);

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
------------------------------ RL ALUNO/ENDERECO ----------------------------
--------------------------------------------------------------------------------
alter table tb_endereco add constraint fk_endereco_pessoa foreign key(id_pessoa) references tb_pessoa(id);

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
------------------------------ RL PESSOA/ESTADO -----------------------------
--------------------------------------------------------------------------------
alter table tb_pessoa add constraint fk_pessoa_estado foreign key(id_estado) references tb_estado(id);

--------------------------------------------------------------------------------
--------------------------- Data Definition Language ---------------------------
-------------------------------------- DDL -------------------------------------
------------------------------ CREATE, ALTER, DROP -----------------------------
------------------------------- RL MATRICULA/ALUNO -----------------------------
--------------------------------------------------------------------------------
alter table tb_matricula add constraint fk_matricula_aluno foreign key(id_aluno) references tb_aluno(id);

spool off
exit