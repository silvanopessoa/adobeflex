spool logs\dml.pessoa.txt
connect crm/crm

insert into tb_pessoa (id, tx_nome,in_sexo,in_tipo) values (1,'Silvano Pessoa Dantas','M','F');
insert into tb_pessoa (id, tx_nome,in_sexo,in_tipo) values (2,'Valter de Oliveira','M','F');
insert into tb_pessoa (id, tx_nome,in_sexo,in_tipo) values (3,'Heder Floriano Bento','M','F');
commit;
spool off
exit