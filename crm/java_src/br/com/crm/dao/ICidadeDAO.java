package br.com.crm.dao;

import java.util.List;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CidadeModel;

public interface ICidadeDAO {

	
	/** 
	 * @param entity
	 * @throws DAOException
	 */
	public void saveCidadeModel(CidadeModel entity) throws DAOException;
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CidadeModel> findAllCidadeSQLHBMModels() throws DAOException;
	
	/**
	 * Remove a model: 'CidadeModel' conforme o identificador.
	 * 
	 * @param id identificador.
	 * @throws DAOException Exception específica para DAO.
	 */
	public void deleteCidadeModel(CidadeModel entity) throws DAOException;

	/**
	 * Busca o 'CidadeModel' pelo identificador.
	 * 
	 * @param id Identificador.
	 * @return Retorna 'CidadeModel' conforme o identificador.
	 * @throws DAOException Exception específica para DAO.
	 */
	public CidadeModel findCidadeModel(Long id) throws DAOException;
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CidadeModel> findAllCidadeModels() throws DAOException;
	
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CidadeModel> findAllCidadeHBMModels() throws DAOException;
	
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CidadeModel> findAllCidadeSQLCodeModels() throws DAOException;
	
	
	/**
	 * @throws DAOException
	 */
	public void executeProcedure() throws DAOException;
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CidadeModel> findAllCidadeJDBCModels() throws DAOException;
}
