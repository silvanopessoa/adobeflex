package br.com.crm.service;

import java.util.Map;

import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.crm.exception.java.DAOException;
import br.com.crm.exception.java.ServiceException;
import br.com.crm.model.dto.UsuarioSistemaDTO;


/**
 * @author silvano.dantas
 *
 */
public interface ILoginService {
	
	@RemotingInclude
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public Map<String, Object> requestAuthentication() throws Exception;
	
	@RemotingInclude
	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS, rollbackFor=Exception.class)
	public UsuarioSistemaDTO requestAutenticarUsuario(String usuario, String senha) throws ServiceException, DAOException;
}
