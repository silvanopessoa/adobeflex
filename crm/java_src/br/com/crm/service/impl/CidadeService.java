package br.com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.crm.dao.ICidadeDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CidadeModel;
import br.com.crm.service.ICidadeService;
import br.com.crm.support.ServiceSupport;

@Service
@RemotingDestination
public class CidadeService extends ServiceSupport implements ICidadeService{

	@Resource
	ICidadeDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#deleteCidadeModel(br.com.crm.model.entity.CidadeModel)
	 */
	@Override
	public void deleteCidadeModel(CidadeModel entity) throws DAOException {
		dao.deleteCidadeModel(entity);
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findCidadeModel(java.lang.Long)
	 */
	@Override
	public CidadeModel findCidadeModel(Long id) throws DAOException {
		return dao.findCidadeModel(id);
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeModels()
	 */
	@Override
	public List<CidadeModel> findAllCidadeModels() throws DAOException {
		return dao.findAllCidadeModels();
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeModelsCache()
	 */
	@Override
	@Cacheable(value="paisCache")
	public List<CidadeModel> findAllCidadeModelsCache() throws DAOException {
		return dao.findAllCidadeModels();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeHBMModels()
	 */
	@Override
	public List<CidadeModel> findAllCidadeHBMModels() throws DAOException {
		return dao.findAllCidadeHBMModels();
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeSQLCodeModels()
	 */
	@Override
	public List<CidadeModel> findAllCidadeSQLCodeModels() throws DAOException{
		return dao.findAllCidadeSQLCodeModels();
		
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeSQLHBMModels()
	 */
	@Override
	public List<CidadeModel> findAllCidadeSQLHBMModels() throws DAOException {
		return dao.findAllCidadeSQLHBMModels();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#executeProcedure()
	 */
	@Override
	public void executeProcedure() throws DAOException {
		dao.executeProcedure();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#saveCidadeModel(br.com.crm.model.entity.CidadeModel)
	 */
	@Override
	public void saveCidadeModel(CidadeModel entity) throws DAOException {
		dao.saveCidadeModel(entity);		
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.ICidadeService#findAllCidadeJDBCModels()
	 */
	@Override
	public List<CidadeModel> findAllCidadeJDBCModels() throws DAOException {
		return dao.findAllCidadeJDBCModels();
	}
}
