package br.com.crm.service.impl;

import mockit.Mockit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.BairroModel;
import br.com.crm.model.entity.CepModel;
import br.com.crm.model.entity.CidadeModel;
import br.com.crm.model.entity.EstadoModel;
import br.com.crm.model.entity.LogradouroModel;
import br.com.crm.model.entity.PaisModel;
import br.com.crm.service.IBairroService;
import br.com.crm.service.ICidadeService;
import br.com.crm.service.IEstadoService;
import br.com.crm.service.ILogradouroService;
import br.com.crm.service.IPaisService;
import br.com.crm.session.ISessionTemplate;
import br.com.crm.session.MockContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class LogradouroTest {
	
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
	ILogradouroService service;
	
	@Autowired
	IPaisService paisService;
	
	@Autowired
	IEstadoService estadoService;
	
	@Autowired
	ICidadeService cidadeService;
	
	@Autowired
	IBairroService bairroService;
	
	
	@Autowired
	ISessionTemplate sessionTemplate;

	/**************************************************************/
	/*************************** TESTES ***************************/
	/**************************************************************/
	/**
	 * Objetivo: Pesquisa um pais cadastrado na base de dados.
	 * 
	 * Resultado: Trazer a model preenchida desse Pais.
	 * 
	 */
	@Test
	public void testSaveLogradouroOficialModel() throws DAOException{
		LogradouroModel model = new LogradouroModel();
		
		PaisModel paisModel = new PaisModel();
		paisModel.setId(1058);
		
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setId(35);
		
		CidadeModel cidadeModel = new CidadeModel();
		cidadeModel.setId(353650);
		
		BairroModel bairroModel = new BairroModel();
		bairroModel.setId(1);
		
		CepModel cepModel = new CepModel();
		cepModel.setId(1);
		
		//Id Pais - find
		paisModel = paisService.findPaisModel(paisModel.getId()); 
		
		//Id Estado - find 
		estadoModel = estadoService.findEstadoModel(estadoModel.getId());
		
		//Id Cidade - find
		cidadeModel = cidadeService.findCidadeModel(cidadeModel.getId()); 
		
		//Id Bairro - find
		bairroModel = bairroService.findBairroModel(bairroModel.getId());
				
		//Id CEP - find
		
		
		
		//Logradouro - Save
		
		
	}

	
	

}
