package br.com.crm.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.PaisModel;

public interface IPaisService {
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<PaisModel> findAllPaisModelsHBM()throws DAOException;
	
	@Secured("ROLE_USER")
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public PaisModel findPaisModel(Long id) throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void savePaisModel(PaisModel entity) throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deletePaisModel(PaisModel entity) throws DAOException;
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public PaisModel updatePaisModel(PaisModel entity) throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<PaisModel> findPaisAllSQLNativoCode()throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<PaisModel> findAllPaisModels() throws DAOException;
	
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public List<PaisModel> findAllPaisModelsCache() throws DAOException;
}
