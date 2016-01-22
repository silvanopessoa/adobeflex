spool logs\dml.endereco.txt
connect crm/crm

--select * from tb_endereco_tipo
insert into tb_endereco_tipo values (1,'Residencial')
insert into tb_endereco_tipo values (2,'Comercial')











commit;
spool off
exit