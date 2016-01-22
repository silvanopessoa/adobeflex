package br.com.crm.dao;

import java.util.List;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CepModel;

public interface ICepDAO {

	
	/**
	 * @return
	 * @throws DAOException
	 */
	public List<CepModel> findAllCepSQLHBMModels() throws DAOException;

	CepModel findCepModel(Long id);

}
