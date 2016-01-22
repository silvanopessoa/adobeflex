package br.com.crm.dao;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.RegiaoModel;

public interface IRegiaoDAO {

	RegiaoModel findRegiaoModel(Long id) throws DAOException;

}
