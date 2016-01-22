spool logs\dml.security.txt
connect crm/crm

--Antes de alterar verificar se o eclipse está abrindo no formato ISO-8859-1
--Devido problema de acentuacao ao dar insert na base de dados.

insert into tb_sistema_permissao (id, tx_sistema_permissao,tx_descricao) values (1,'ROLE_USER','Usuário');
insert into tb_sistema_permissao (id, tx_sistema_permissao,tx_descricao) values (2,'ROLE_ADMIN','Administrador');
insert into tb_sistema_permissao (id, tx_sistema_permissao,tx_descricao) values (3,'ROLE_GUEST','Visitante');

insert into tb_usuario_sistema (id,tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values (1,'silvano.dantas','e10adc3949ba59abbe56e057f20f883e',1,1,sysdate);
insert into tb_usuario_sistema (id,tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values (2,'valter.sa','e10adc3949ba59abbe56e057f20f883e',1,1,sysdate);
insert into tb_usuario_sistema (id,tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values (3,'heder.bento','e10adc3949ba59abbe56e057f20f883e',1,1,sysdate);
--insert into tb_usuario_sistema (tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values ('silvano.dantas','123456',1,65);
--insert into tb_usuario_sistema (tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values ('valter.sa','123456',1,66);
--insert into tb_usuario_sistema (tx_nome, tx_senha,in_ativo,id_pessoa,dt_create) values ('heder.bento','123456',0,67);


insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (1,'silvano.dantas',1);
insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (2,'silvano.dantas',2);
insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (3,'valter.sa',1);
insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (4,'valter.sa',2);
insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (5,'heder.bento',1);
insert into tb_usuario_sistema_permissao(id,tx_nome,id_sistema_permissao) values (6,'heder.bento',2);





commit;
spool off
exit