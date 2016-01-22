package br.com.crm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.crm.dao.ICepDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CepModel;
import br.com.crm.support.DAOSupport;

 
@Repository
public class CepDAO extends DAOSupport implements ICepDAO {

	@Override
	public List<CepModel> findAllCepSQLHBMModels() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CepModel findCepModel(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
