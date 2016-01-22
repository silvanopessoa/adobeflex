package br.com.crm.service.impl;

import mockit.Mockit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.service.IEnderecoService;
import br.com.crm.session.ISessionTemplate;
import br.com.crm.session.MockContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class EnderecoTest {
	
	/**************************************************************/
	/*********************** INICIALIZACAO ************************/
	/**************************************************************/
	/**
	 * Inicializa o simulador de sessão do flex.
	 *
	 * @throws Exception
	 */
	@BeforeClass
	public static void startFlexSessionMock() throws Exception {
	    Mockit.setUpMocks(MockContext.class);
	}
	
	
	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	@Autowired
	IEnderecoService service;
	
	@Autowired
	ISessionTemplate sessionTemplate;
	
	/**************************************************************/
	/*************************** TESTES ***************************/
	/**************************************************************/
	/**
	 * Objetivo: Mostra o comportamento de tentar salvar um objeto DETACHED sem cascate/persiste.
	 * 
	 * Resultado: Não consegue salvar porque o Pais
	 */
	@Test()
	@Transactional
	@Rollback(value=false)
	public void testSaveEndereco() throws DAOException{
	

	}

	

}
