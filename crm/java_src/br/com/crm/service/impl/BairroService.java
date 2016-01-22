package br.com.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.crm.dao.IBairroDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.BairroModel;
import br.com.crm.service.IBairroService;
import br.com.crm.support.ServiceSupport;

@Service
@RemotingDestination
public class BairroService extends ServiceSupport implements IBairroService{
	
	@Resource
	IBairroDAO dao;

	/* (non-Javadoc)
	 * @see br.com.crm.service.IBairroService#findBairroModel(java.lang.Long)
	 */
	@Override
	public BairroModel findBairroModel(Long id) throws DAOException {
		return dao.findBairroModel(id);
	}
	

}
