package br.com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.crm.dao.IEstadoDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.EstadoModel;
import br.com.crm.service.IEstadoService;
import br.com.crm.support.ServiceSupport;

@Service
@RemotingDestination
public class EstadoService extends ServiceSupport implements IEstadoService{

	@Resource
	IEstadoDAO dao;
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.IEstadoService#saveEstadoModel(br.com.crm.model.entity.EstadoModel)
	 */
	@Override
	public void saveEstadoModel(EstadoModel entity) throws DAOException{
		dao.saveEstadoModel(entity);
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.IEstadoService#findAllEstadoModels()
	 */
	@Override
	@Cacheable(value="ufCache")
	public List<EstadoModel> findAllEstadoModels() throws DAOException {
		return dao.findAllEstadoModels();
	}

	/* (non-Javadoc)
	 * @see br.com.crm.service.IEstadoService#findCidadeModel(java.lang.Long)
	 */
	@Override
	public EstadoModel findEstadoModel(Long id) throws DAOException {
		return dao.findEstadoModel(id);
	}

	@Override
	public EstadoModel findCidadeModel(long l) {
		// TODO Auto-generated method stub
		return null;
	}
}
