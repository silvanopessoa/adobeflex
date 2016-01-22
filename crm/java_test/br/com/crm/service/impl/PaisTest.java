package br.com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import mockit.Mockit;

import org.junit.BeforeClass;
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
import br.com.crm.service.IPaisService;
import br.com.crm.session.ISessionTemplate;
import br.com.crm.session.MockContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class PaisTest {

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
	IPaisService service;
	
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
	public void testFindPaisModel() throws DAOException{
		PaisModel model= service.findPaisModel((long) 1);
		Assert.notNull(model);
	}
	
	/**
	 * Objetivo: Tenta salvar um objeto nulo na base de dados.
	 * 
	 * Resultado: Retornar o erro DAOException.
	 * 
	 */
	@Transactional
	@Test(expected=DAOException.class)
	public void testSavePaisModelNulo() throws DAOException{
		service.savePaisModel(null);
	}
	
	/**
	 * Objetivo: Tentar salvar um pais com id informardo.
	 * 
	 * Resultado:  Retornar o erro DAOException, pois não deve permitir.
	 * 
	 */
	@Transactional
	@Test(expected=DAOException.class)
	public void testSavePaisModelComId() throws DAOException{
		PaisModel model = new PaisModel();
		model.setId(15);
		model.setTxPais("Argentina");
		model.setInSigla2("AR");
		model.setInSigla3("ARG");
		service.savePaisModel(model);
	}
	
	/**
	 * Objetivo: Tentar salvar um pais vazio.
	 * 
	 * Resultado: Retornar o erro PersistenceException, pois não deve permitir.
	 * 
	 */
	@Transactional
	@Test(expected=PersistenceException.class)
	public void testSavePaisModelVazio() throws DAOException{
		PaisModel model = new PaisModel();
		service.savePaisModel(model);
	}
	
	/**
	 * Objetivo: Tentar salvar um pais com todos dados informados.
	 * 
	 * Resultado: Devera retornar o id.
	 * 
	 */
	@Transactional
	@Test
	public void testSavePaisModel() throws DAOException{
		PaisModel model = new PaisModel();
		model.setTxPais("Argentina");
		model.setInSigla2("Ar");
		model.setInSigla3("Arg");
		service.savePaisModel(model);
		Assert.isTrue(model.getId()>0);
		//Obs.: Da um rollback apos executar, ou seja, testa se salva e da um rollback
	}

	
	/**
	 * Objetivo: Mostra o Ciclo de Vida Basico do DETACHED/MANAGED
	 * 
	 * Resultado: Devera retornar uma lista.
	 */
	@Test
	@Transactional
	public void testPaisDetachedManaged() throws DAOException{
		//Model(DETACHED) 
		PaisModel modelDetached = new PaisModel();
		modelDetached.setId(1058);
		modelDetached.setInSigla2("BR");
		modelDetached.setInSigla3("BRA");
		modelDetached.setTxPais("Brasil");
		
		//MODEL(MANAGED)
		PaisModel modelManaged = service.findPaisModel((long) 1058);		
		
		PaisModel modelManagedConvertida = service.updatePaisModel(modelDetached);

		//O teste abaixo comprova: Mesma igualdade JVM/Equivalencia/Mesmo id.
		Assert.isTrue(modelManagedConvertida == modelManaged 
				&& service.updatePaisModel(modelDetached).equals(modelManaged));
	}
	

	/**
	 * Objetivo: Mostra o comportamento do mapeamento @OneToMany(mappedBy="tbPai")
	 * 
	 * Resultado: Salvar o pais e nao salvar estado devido o mapeamento passa a responsabilidade de salvar.
	 */
	@Test
	@Transactional
	@Rollback(value=true)
	public void testSavePaisSemEstado() throws DAOException{
		//ESTADO
		List<EstadoModel> tbEstados = new ArrayList<EstadoModel>();
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setTxEstado("Alasca");
		estadoModel.setInSigla2("AL");
		tbEstados.add(estadoModel);
		
		//PAIS
		PaisModel model = new PaisModel();
		model.setTxPais("Estados Unidos");
		model.setInSigla2("US");
		model.setInSigla3("USA");
		model.setTbEstados(tbEstados);
		
		service.savePaisModel(model);
		
		//Não salva o estado devido o @OneToMany(mappedBy="tbPai")
		//Define que o atributo está mapeado em um determinado atributo.
		//Melhor desempenho
		//Ajuda no lazy.
		Assert.isTrue(model.getId()>0 && estadoModel.getId()==0);
	}
	
	
	/**
	 * Objetivo: Obter todos os Paises atraves de HQL num arquivo XML.
	 * 
	 * Resultado: Devera retornar uma lista.
	 */
	@Repeat(value=100)
	@Test
	public void testFindAllPaisModelsHBM()throws DAOException{
		List<PaisModel>list= service.findAllPaisModelsHBM();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Repeat(value=100)
	@Test
	public void testFindPaisAllSQLNativoCode() throws DAOException {
		List<PaisModel> list = service.findPaisAllSQLNativoCode();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Repeat(value=100)
	@Test
	public void findAllPaisModels() throws DAOException {
		List<PaisModel> list = service.findAllPaisModels();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Test
	public void findAllPaisModelsColocandoNoCache() throws DAOException {
		List<PaisModel> list = service.findAllPaisModelsCache();
		Assert.isTrue(list.size()>0);
	}
	
	/**
	 * @throws DAOException
	 */
	@Repeat(value=100)
	@Test
	public void findAllPaisModelsCache() throws DAOException {
		List<PaisModel> list = service.findAllPaisModelsCache();
		Assert.isTrue(list.size()>0);
	}
	
}
