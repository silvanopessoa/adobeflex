package br.com.crm.module.login.controller.impl{

	import br.com.crm.event.CRMEvent;
	import br.com.crm.model.dto.UsuarioSistemaDTO;
	import br.com.crm.module.login.controller.ILoginViewController;
	import br.com.crm.module.login.event.LoginViewEvent;
	
	import mx.controls.Alert;
	import mx.rpc.AsyncResponder;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import org.swizframework.utils.services.ServiceHelper;
	import br.com.crm.controller.Controller;

	
	/** LoginController
	 * 
	 * CONTROLLER
	 * 
	 * Descricao: Camada Cliente - Responsável por intermediar a comunicação entre camada de apresentação(Adobe Flex)
	 *  e a camada de negócio(Java).<br>
	 * Beneficios: 
	 * 
	 * Classe responsável por intermediar a comunicação entre camada de apresentação e a 
	 * camada de negócio(Java).<br>
	 *    
	 * @author silvano.dantas
	 * 
	 */
	public class LoginViewController extends Controller implements ILoginViewController{
		
		[Inject(source="loginService")]
		public var service:RemoteObject;
		
		/* Código da resposta da autenticação do login */
		[Bindable]
		public var dsLoginResposta:Object;
		
		[Bindable]
		public var usuarioSistemaDTO:UsuarioSistemaDTO;
		
		public function requestLogout():void{
			service.channelSet.logout();
		}
		
		/**
		 * Solicita uma requisição ao service para 'autenticação do login'.
		 * 
		 * @param usuario Nome do Usuário
		 * @param senha	Senha do Usuário
		 * @author silvano.dantas
		 */
		public function requestLogin(usuario:String,senha:String):void{
			var token:AsyncToken = service.channelSet.login(usuario,senha);
			token.addResponder(new AsyncResponder(responseLogin,onFault));
		}

		/**
		 * Obtem a reposta da requisição 'autenticação do login'. 
		 * 
		 * @param event Resultado do evento.
		 * @author silvano.dantas
		 */
		public function responseLogin(event:ResultEvent,token:Object = null):void{
			dsLoginResposta = event.result as Object;
			dispatcher.dispatchEvent(new LoginViewEvent(LoginViewEvent.LOGIN));
		}
		
		public function requestAuthentication():void{
			sh.executeServiceCall(service.requestAuthentication(),responseAuthentication,onError);
		}
		
		public function responseAuthentication(event:ResultEvent):void{
			dsLoginResposta = event.result as Object;
			dispatcher.dispatchEvent(new LoginViewEvent(LoginViewEvent.LOGIN));
		}
		
		//AutenticarUsuario
		public function requestAutenticarUsuario(usuario:String,senha:String):void{
			sh.executeServiceCall(service.requestAutenticarUsuario(usuario,senha),responseAutenticarUsuario,onError);
		}
		public function responseAutenticarUsuario(event:ResultEvent):void{
			usuarioSistemaDTO=event.result as UsuarioSistemaDTO;
			dispatcher.dispatchEvent(new LoginViewEvent(LoginViewEvent.LOGIN));
		}
	}
}