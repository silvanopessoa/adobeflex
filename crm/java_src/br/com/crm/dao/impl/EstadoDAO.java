package br.com.crm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.crm.dao.IEstadoDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.EstadoModel;
import br.com.crm.support.DAOSupport;

@Repository
public class EstadoDAO extends DAOSupport implements IEstadoDAO {

	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IEstadoDAO#saveEstadoModel(br.com.crm.model.entity.EstadoModel)
	 */
	@Override
    public void saveEstadoModel(EstadoModel entity) throws DAOException{
		if(entity == null || entity.getId()>0){
    		throw new DAOException(this.getMessage("exception.generic.invalido",new Object [] {"Estado"}));
    	}
    	this.entityManager.persist(entity);
    }

	/* (non-Javadoc)
	 * @see br.com.crm.dao.IEstadoDAO#findAllEstadoModels()
	 */
	@Override
    public List<EstadoModel> findAllEstadoModels() throws DAOException {
        return entityManager.createQuery("select o from EstadoModel o", EstadoModel.class).getResultList();
    }
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IEstadoDAO#findEstadoModel(java.lang.Long)
	 */
	@Override
	public EstadoModel findEstadoModel(Long id) throws DAOException {
		if (id == null) return null;
		return entityManager.find(EstadoModel.class, id);
	 }
    
}
