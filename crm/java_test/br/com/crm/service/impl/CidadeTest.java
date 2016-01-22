package br.com.crm.service.impl;

import java.util.List;

import org.junit.Before;
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
import br.com.crm.model.entity.CidadeModel;
import br.com.crm.model.entity.EstadoModel;
import br.com.crm.service.ICidadeService;
import br.com.crm.service.IEstadoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class CidadeTest {

	/**************************************************************/
	/************************* ATRIBUTOS **************************/
	/**************************************************************/
	@Autowired
	ICidadeService service;
	
	@Autowired
	IEstadoService estadoService;
	
	EstadoModel estadoModel;
	/**************************************************************/
	/*************************** TESTES ***************************/
	/**************************************************************/
	
	
	/**
	 * @throws DAOException
	 */
	@Before
	public void initTest() throws DAOException{
		estadoModel = estadoService.findCidadeModel((long) 26);
	}
	
	
	/**
	 * Objetivo: Remover uma Cidade(ESTADO=DETACHED) da base de dados.
	 * 
	 * Resultado: Deverá retornar IllegalArgumentException pois tem que estar no ESTADO=MANAGED.
	 */
	@Transactional
	@Test(expected=IllegalArgumentException.class)
	public void testDeleteCidadeModel() throws DAOException{
		try{
			CidadeModel model = new CidadeModel();
			model.setId(355700);
			model.setTxCidade("Zacarias");
			service.deleteCidadeModel(model);
		}catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	/**
	 * Objetivo: Simular um erro grave onde ao remover uma Cidade da base de dados com CascadeType.ALL nos estados.
	 * 
	 * Resultado: Deveria retornar um checked exception mais não retorna.
	 */
	@Transactional
	@Test
	public void testCascadeTypeALLProblema() throws Exception{
		try{
		//************** ATIVAR O CASCATE NA MODEL *****************/
		//************* DESATIVAR O Rollback=false *****************/
			//Obtem - Cidade de São Paulo.
			CidadeModel model = service.findCidadeModel((long) 355030);
			//Obtem - Estados no Lazy.
			model.getTbEstado();
			service.deleteCidadeModel(model);
		}catch (Exception e) {
			//Nunca cai aqui
			throw e;
		}
	}
	

	/**
	 * @throws DAOException
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeHQLCodeModels1000x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeModels();
		Assert.isTrue(list.size()>0);
	}
	

	/**
	 * @throws DAOException
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeSQLCodeModels1000x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeSQLCodeModels();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * 
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeSQLHBMModels1000x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeSQLHBMModels();
		Assert.isTrue(list.size()>0);
	}
	
	
	/**
	 * 
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeHBMModels1000x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeHBMModels();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Test
	public void testFindAllCidadeModelsAddCache1x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeModelsCache();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * 
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeModelsCache1000x() throws DAOException{
		List<CidadeModel> list = service.findAllCidadeModelsCache();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Repeat(value=3)
	@Test
	public void testFindAllCidadeJDBCModels3x()throws DAOException{
		List<CidadeModel> list = service.findAllCidadeJDBCModels();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Repeat(value=1000)
	@Test
	public void testFindAllCidadeJDBCModels1000x()throws DAOException{
		List<CidadeModel> list = service.findAllCidadeJDBCModels();
		Assert.isTrue(list.size()>0);
	}
	
	
	/**
	 * @throws DAOException
	 */
	@Test
	@Transactional
	@Repeat(value=100)
	@Rollback(value=false)
	public void testExecuteProcedureInsert()throws DAOException{
		service.executeProcedure();
	}
	
	/**
	 * @throws DAOException
	 */
	@Test
	@Transactional
	@Repeat(value=100)
	@Rollback(value=false)
	public void testExecuteHQLInsert()throws DAOException{
		CidadeModel model = new CidadeModel();
		model.setTxCidade("Flex Vision Cidade");
		model.setTbEstado(estadoModel);
		service.saveCidadeModel(model);
	}
	

}
