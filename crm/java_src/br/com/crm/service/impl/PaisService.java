package br.com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.crm.dao.IPaisDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.PaisModel;
import br.com.crm.service.IPaisService;
import br.com.crm.support.ServiceSupport;

@Service
@RemotingDestination
public class PaisService extends ServiceSupport implements IPaisService{
	
	@Resource
	IPaisDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#findPaisModel(java.lang.Long)
	 */
	@Override
	public PaisModel findPaisModel(Long id) throws DAOException {
		return dao.findPaisModel(id);
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#savePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
	public void savePaisModel(PaisModel entity) throws DAOException{
		dao.savePaisModel(entity);
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#findAllPaisModelsHBM()
	 */
	@Override
	public List<PaisModel> findAllPaisModelsHBM()throws DAOException{
		return dao.findAllPaisModelsHBM();
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#deletePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
	public void deletePaisModel(PaisModel entity) throws DAOException{
		dao.deletePaisModel(entity);
	}
	
	 /* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#updatePaisModel(br.com.crm.model.entity.PaisModel)
	 */
	@Override
	public PaisModel updatePaisModel(PaisModel entity) throws DAOException{
		 return dao.updatePaisModel(entity);
	 }
	

	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#findPaisEstadoSQLNativoCode()
	 */
	@Override
	public List<PaisModel> findPaisAllSQLNativoCode()throws DAOException{
		return dao.findPaisAllSQLNativoCode();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#findAllPaisModels()
	 */
	@Override
	public List<PaisModel> findAllPaisModels() throws DAOException {
		return dao.findAllPaisModels();
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.IPaisService#findAllPaisModelsCache()
	 */
	@Override
	@Cacheable(value="paisCache")
	public List<PaisModel> findAllPaisModelsCache() throws DAOException{
		return dao.findAllPaisModels();
	}
}
