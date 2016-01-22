package br.com.crm.dao;

import java.util.List;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.EstadoModel;


public interface IEstadoDAO {

	/**
	 * @param entity
	 * @throws DAOException
	 */
	void saveEstadoModel(EstadoModel entity) throws DAOException;
	

	/**
	 * @return
	 * @throws DAOException
	 */
	public List<EstadoModel> findAllEstadoModels() throws DAOException;
	
	
	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public EstadoModel findEstadoModel(Long id) throws DAOException;

}
