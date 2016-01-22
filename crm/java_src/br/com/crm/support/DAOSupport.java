package br.com.crm.support;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class DAOSupport {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Autowired
    public MessageSource messages;
	
	protected String getMessage(String msg){
        return messages.getMessage(msg,null,null);
    }
	
	protected String getMessage(String msg,Object[] identificador){
        return messages.getMessage(msg,identificador,null);
    }
	
//	public void flush(){
//		entityManager.setFlushMode(FlushModeType.COMMIT);
//		entityManager.flush();
//	}
}
