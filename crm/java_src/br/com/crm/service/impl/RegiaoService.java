package br.com.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.crm.dao.IRegiaoDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.RegiaoModel;
import br.com.crm.service.IRegiaoService;
import br.com.crm.support.ServiceSupport;

@Service
public class RegiaoService extends ServiceSupport implements IRegiaoService {
	
	@Resource
	IRegiaoDAO dao;

	/* (non-Javadoc)
	 * @see br.com.crm.service.IRegiaoService#findRegiaoModel(java.lang.Long)
	 */
	@Override
	public RegiaoModel findRegiaoModel(Long id) throws DAOException {
		return dao.findRegiaoModel(id);
	}
}
