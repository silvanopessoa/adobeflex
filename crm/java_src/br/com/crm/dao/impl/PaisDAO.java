package br.com.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.crm.dao.IPaisDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.PaisModel;
import br.com.crm.support.DAOSupport;

@Repository
public class PaisDAO extends DAOSupport implements IPaisDAO{


	 /* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#findPaisModel(java.lang.Long)
	 */
	@Override
	public PaisModel findPaisModel(Long id) throws DAOException {
		if (id == null) return null;
		return entityManager.find(PaisModel.class, id);
	 }
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#findPaisModelEntries(int, int)
	 */
	@Override
    public List<PaisModel> findPaisModelEntries(int firstResult, int maxResults) throws DAOException {
        return entityManager.createQuery("select o from PaisModel o", PaisModel.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#findAllPaisModels()
	 */
	@Override
    public List<PaisModel> findAllPaisModels() throws DAOException {
        return entityManager.createQuery("select o from PaisModel o", PaisModel.class).getResultList();
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#countPaisModels()
	 */
	@Override
    public long countPaisModels() throws DAOException{
        return entityManager.createQuery("select count(o) from PaisModel o", Long.class).getSingleResult();
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#savePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
    public void savePaisModel(PaisModel entity) throws DAOException{
		if(entity == null || entity.getId()>0){
    		throw new DAOException(
    				this.getMessage("exception.generic.invalido",
    								new Object [] {"País"}));
    	}
    	this.entityManager.persist(entity);
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#updatePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
    public PaisModel updatePaisModel(PaisModel entity) throws DAOException{
    	return this.entityManager.merge(entity);
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#deletePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
    public void deletePaisModel(PaisModel entity) throws DAOException{
    	this.entityManager.remove(entity);
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#deletePaisModelById(java.lang.Long)
	 */
	@Override
    public void deletePaisModelById(Long id) throws DAOException{
    	PaisModel entity = this.findPaisModel(id);
    	this.deletePaisModel(entity);
    }
    
	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#findAllPaisModelsHBM()
	 */
	@SuppressWarnings("unchecked")
	public List<PaisModel> findAllPaisModelsHBM()throws DAOException{
		return entityManager.createNamedQuery("hql.pais.all").getResultList();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.dao.IPaisDAO#findPaisEstadoSQLNativoCode()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PaisModel> findPaisAllSQLNativoCode() throws DAOException {
		String sql= "select * from tb_pais" ;
		Query query =(Query) entityManager.createNativeQuery(sql);
		//Query query =(Query) entityManager.createNativeQuery("sql.pais");
		List<PaisModel> list =query.getResultList();
		return  list;
	}
}
