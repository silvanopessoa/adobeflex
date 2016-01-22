package br.com.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CidadeModel;

public interface ICidadeService {

	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteCidadeModel(CidadeModel entity) throws DAOException;

	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	CidadeModel findCidadeModel(Long id) throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeModels() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeModelsCache() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeHBMModels() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeSQLCodeModels() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeSQLHBMModels() throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void executeProcedure() throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void saveCidadeModel(CidadeModel entity) throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<CidadeModel> findAllCidadeJDBCModels() throws DAOException;
}
