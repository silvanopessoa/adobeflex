package br.com.crm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.crm.dao.IBairroDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.BairroModel;
import br.com.crm.support.DAOSupport;

@Repository
public class BairroDAO extends DAOSupport implements IBairroDAO{

	/* (non-Javadoc)
	 * @see br.com.crm.dao.IBairroDAO#findAllBairroModels()
	 */
	@Override
    public List<BairroModel> findAllBairroModels() throws DAOException {
		//teste
        return entityManager.createQuery("select o from BairroModel o", BairroModel.class).getResultList();
    }
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IBairroDAO#findBairroModel(java.lang.Long)
	 */
	@Override
	public BairroModel findBairroModel(Long id) throws DAOException {
		if (id == null) return null;
		return entityManager.find(BairroModel.class, id);
	 }
}
