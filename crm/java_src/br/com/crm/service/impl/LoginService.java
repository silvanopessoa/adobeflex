package br.com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.security3.AuthenticationResultUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.crm.exception.java.DAOException;
import br.com.crm.exception.java.ServiceException;
import br.com.crm.model.dto.UsuarioSistemaDTO;
import br.com.crm.service.ILoginService;
import br.com.crm.service.IPaisService;
import br.com.crm.support.ServiceSupport;
import flex.messaging.FlexContext;

@Service
@RemotingDestination
public class LoginService extends ServiceSupport implements ILoginService{
	
	@Resource
	IPaisService paisService;
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ILoginService#requestAuthentication()
	 */
	@Override
	public Map<String, Object> requestAuthentication() throws Exception{
		Map<String, Object> resposta = AuthenticationResultUtils.getAuthenticationResult();
		return resposta;
	}
	
	/* (non-Javadoc)
	 * @see br.com.crm.service.ILoginService#requestAutenticarUsuario(java.lang.String, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UsuarioSistemaDTO requestAutenticarUsuario(String usuario, String senha) throws ServiceException, DAOException{
		UsuarioSistemaDTO dto = new UsuarioSistemaDTO();
		try{
			//RN01 - 
			ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(FlexContext.getServletConfig().getServletContext());
			//RN02 - Obtem o Authentication Manager definido no security-config.xml
			AuthenticationManager manager = (AuthenticationManager) appContext.getBean("_authenticationManager");
			//RN03 - Substitui os ? nos sql do Authentication Manager e defini no token
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario, senha);
			//RN04 - Realiza a autenticacao, ou seja, valida senha e login conforme com token. Se for inválida retorna o erro.
			Authentication authentication = manager.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			//RN05 - Autorizacoes
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			//RN06 - Resposta
			//TODO - Separar em uma funcionalidade
			dto.setUsuario(usuario);
			List<String> permissoes = new ArrayList<String>();
			for (GrantedAuthority grantedAuthority : authorities) {
				permissoes.add(grantedAuthority.getAuthority());
			}
			dto.setPermissoes(permissoes);
			//RN07 - Validar Versoes do Sistema
			//TODO - Falta Implementar
		}catch (BadCredentialsException e) {
			throw new ServiceException(this.getMessage("exceptions.usuario.senha.invalido"));
		}
		return dto;
	}
	
}
