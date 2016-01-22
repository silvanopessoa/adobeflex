package br.com.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.EstadoModel;

public interface IEstadoService {

	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveEstadoModel(EstadoModel entity) throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<EstadoModel> findAllEstadoModels() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public EstadoModel findEstadoModel(Long id) throws DAOException;

	public EstadoModel findCidadeModel(long l);
}
