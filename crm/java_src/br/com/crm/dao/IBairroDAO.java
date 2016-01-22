package br.com.crm.dao;

import java.util.List;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.BairroModel;

public interface IBairroDAO {

	/**
	 * @return
	 * @throws DAOException
	 */
	public List<BairroModel> findAllBairroModels() throws DAOException;

	/**
	 * sad
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	BairroModel findBairroModel(Long id) throws DAOException;
	
}
