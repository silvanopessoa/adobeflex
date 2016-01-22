package br.com.crm.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.crm.dao.IRegiaoDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.RegiaoModel;
import br.com.crm.support.DAOSupport;

@Repository
public class RegiaoDAO extends DAOSupport implements IRegiaoDAO {
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IRegiaoDAO#findRegiaoModel(java.lang.Long)
	 */
	@Override
	public RegiaoModel findRegiaoModel(Long id) throws DAOException {
		if (id == null) return null;
		return entityManager.find(RegiaoModel.class, id);
	 }
}
