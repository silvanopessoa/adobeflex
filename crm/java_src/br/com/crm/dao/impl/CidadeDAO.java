package br.com.crm.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.crm.dao.ICidadeDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CidadeModel;
import br.com.crm.support.DAOSupport;

@Repository
public class CidadeDAO extends DAOSupport implements ICidadeDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.ICidadeDAO#deleteCidadeModel(br.com.crm.model.entity.CidadeModel)
	 */
	@Override
	public void deleteCidadeModel(CidadeModel entity) throws DAOException {
		this.entityManager.remove(entity);
	}

	/* (non-Javadoc)
	 * @see br.com.crm.dao.ICidadeDAO#findCidadeModel(java.lang.Long)
	 */
	@Override
	public CidadeModel findCidadeModel(Long id) throws DAOException {
		if (id == null) return null;
		return entityManager.find(CidadeModel.class, id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.dao.ICidadeDAO#findAllCidadeModels()
	 */
	@Override
    public List<CidadeModel> findAllCidadeModels() throws DAOException {
        return entityManager.createQuery("select o from CidadeModel o", CidadeModel.class).getResultList();
    }
    
    /* (non-Javadoc)
     * @see br.com.crm.dao.ICidadeDAO#findAllCidadeHBMModels()
     */
    @Override
    @SuppressWarnings("unchecked")
	public List<CidadeModel> findAllCidadeHBMModels() throws DAOException {
    	return entityManager.createNamedQuery("hql.cidade.all").getResultList();
    }
    
    /* (non-Javadoc)
     * @see br.com.crm.dao.ICidadeDAO#findAllCidadeSQLCodeModels()
     */
    @Override
    @SuppressWarnings("unchecked")
	public List<CidadeModel> findAllCidadeSQLCodeModels() throws DAOException {
    	String sql ="select * from tb_cidade";
    	Query query =(Query) entityManager.createNativeQuery(sql);
    	List<CidadeModel>  list =query.getResultList();
    	return list;
    }
    
    /* (non-Javadoc)
     * @see br.com.crm.dao.ICidadeDAO#findAllCidadeSQLHBMModels()
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<CidadeModel> findAllCidadeSQLHBMModels() throws DAOException {
    	Query query =(Query) entityManager.createNamedQuery("sql.cidade.all");
    	List<CidadeModel>  list =query.getResultList();
    	return list;
    	//return null;
    }
    
    /* (non-Javadoc)
     * @see br.com.crm.dao.ICidadeDAO#executeProcedure()
     */
    @Override
    public void executeProcedure() throws DAOException {
    	entityManager.createNamedQuery("proc.cidade.insert").executeUpdate();
    }
   
    /* (non-Javadoc)
     * @see br.com.crm.dao.ICidadeDAO#saveCidadeModel(br.com.crm.model.entity.CidadeModel)
     */
    @Override
    public void saveCidadeModel(CidadeModel entity) throws DAOException{
		if(entity == null || entity.getId()>0){
    		throw new DAOException(
    				this.getMessage("exception.generic.invalido",
    								new Object [] {"Cidade"}));
    	}
    	this.entityManager.persist(entity);
    }
    
    @SuppressWarnings("unchecked")
	public List<CidadeModel> findAllCidadeJDBCModels() throws DAOException {
    	String sql = "select * from tb_cidade";
    	@SuppressWarnings("rawtypes")
		List resultados = (List) jdbcTemplate.queryForList(sql);
    	return resultados;
    	
    }
}
