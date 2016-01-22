package br.com.crm.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CepModel;

public interface CepService {
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	CepModel findCepoModel(Long id) throws DAOException;

}
