package br.com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.crm.dao.ICepDAO;
import br.com.crm.exception.java.DAOException;
import br.com.crm.model.entity.CepModel;
import br.com.crm.support.ServiceSupport;

@Service
@RemotingDestination
public class CepService  extends ServiceSupport implements ICepDAO {

	
	@Resource
	ICepDAO dao;

	@Override
	public List<CepModel> findAllCepSQLHBMModels() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CepModel findCepModel(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
