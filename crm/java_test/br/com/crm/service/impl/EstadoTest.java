package br.com.crm.service.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.EstadoModel;
import br.com.crm.model.entity.PaisModel;
import br.com.crm.model.entity.RegiaoModel;
import br.com.crm.service.IEstadoService;
import br.com.crm.service.IPaisService;
import br.com.crm.service.IRegiaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class EstadoTest {
	
	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	@Autowired
	IEstadoService service;
	
	@Autowired
	IRegiaoService regiaoService;
	
	@Autowired
	IPaisService paisService;
	
	/**************************************************************/
	/*************************** TESTES ***************************/
	/**************************************************************/
	/**
	 * Objetivo: Mostra o comportamento de tentar salvar um objeto DETACHED sem cascate/persiste.
	 * 
	 * Resultado: Não consegue salvar porque o Pais
	 */
	@Test(expected=PersistenceException.class)
	@Transactional
	@Rollback(value=true)
	public void testSaveEstadoPaisSemCascateProblema() throws DAOException{
		//REGIAO - MANAGED
		RegiaoModel regiaoModel = regiaoService.findRegiaoModel((long) 1);
		
		//PAIS - DETACHED
		PaisModel paisModel = new PaisModel();
		paisModel.setTxPais("Estados Unidos");
		paisModel.setInSigla2("US");
		paisModel.setInSigla3("USA");
		
		//ESTADO - DETACHED
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setTxEstado("Alasca");
		estadoModel.setInSigla2("AL");
		estadoModel.setTbPais(paisModel);
		estadoModel.setTbRegiao(regiaoModel);//SALVA
		
		//SALVA
		service.saveEstadoModel(estadoModel);
	}
	
	/**
	 * Objetivo: Mostra o comportamento de tentar salvar um objeto DETACHED sem cascate/persiste.
	 * 
	 * Resultado: Não consegue salvar porque o Pais
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void testSaveEstadoPaisSemCascateSolucao() throws DAOException{
		//REGIAO - MANAGED
		RegiaoModel regiaoModel = regiaoService.findRegiaoModel((long) 1);
		
		//PAIS - DETACHED
		PaisModel paisModel = new PaisModel();
		paisModel.setTxPais("Estados Unidos");
		paisModel.setInSigla2("US");
		paisModel.setInSigla3("USA");
		paisService.savePaisModel(paisModel);//Solucao 1 ou adicionar o cascate no atrinuto pais na model estado.
		
		//ESTADO - DETACHED
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setTxEstado("Alasca");
		estadoModel.setInSigla2("AL");
		estadoModel.setTbPais(paisModel);
		estadoModel.setTbRegiao(regiaoModel);//SALVA
		
		//SALVA
		service.saveEstadoModel(estadoModel);
		
		Assert.isTrue(estadoModel.getId()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void testFlushEstado() throws DAOException{
		//REGIAO - MANAGED
		RegiaoModel regiaoModel = regiaoService.findRegiaoModel((long) 1);
		
		//PAIS - DETACHED
		PaisModel paisModel = new PaisModel();
		paisModel.setTxPais("Estados Unidos");
		paisModel.setInSigla2("US");
		paisModel.setInSigla3("USA");
		paisService.savePaisModel(paisModel);//Solucao 1 ou adicionar o cascate no atrinuto pais na model estado.
		
		
		
		//ESTADO - DETACHED
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setTxEstado("Alasca");
		estadoModel.setInSigla2("AL");
		estadoModel.setTbPais(paisModel);
		estadoModel.setTbRegiao(regiaoModel);//SALVA
		
		//SALVA
		service.saveEstadoModel(estadoModel);
		
		Assert.isTrue(estadoModel.getId()>0);
	}
	
	
	/**
	 * @throws DAOException
	 */
	@Test
	@Transactional
	public void testFindAllEstadoModelsByPais() throws DAOException{
		List<EstadoModel> list = service.findAllEstadoModels();
		Assert.isTrue(list.size()>0);
	}

	/**
	 * @throws DAOException
	 */
	@Test
	@Repeat(value=80)
	public void testFindAllEstadoModelsByPaisCache() throws DAOException{
		List<EstadoModel> list = service.findAllEstadoModels();
		Assert.isTrue(list.size()>0);
	}
}
