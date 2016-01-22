package br.com.crm.service;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.RegiaoModel;

public interface IRegiaoService {
	RegiaoModel findRegiaoModel(Long id) throws DAOException;
}
