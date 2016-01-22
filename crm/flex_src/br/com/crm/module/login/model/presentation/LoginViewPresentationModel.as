package br.com.crm.module.login.model.presentation
{
	import br.com.crm.component.progressbar.ProgressBarView;
	import br.com.crm.event.CRMEvent;
	import br.com.crm.model.dto.UsuarioSistemaDTO;
	import br.com.crm.model.presentation.PresentationModel;
	import br.com.crm.module.login.controller.ILoginViewController;
	import br.com.crm.module.login.event.LoginViewEvent;
	
	import mx.core.FlexGlobals;
	import mx.resources.ResourceBundle;
	
	
	public class LoginViewPresentationModel extends PresentationModel
	{
		[Bindable]
		public var usuario:String;
		
		[Bindable]
		public var senha:String;
		
		[Bindable]
		public var versaoLogin:String;
		
		[Bindable]
		public var usuarioSistemaDTO:UsuarioSistemaDTO;
		
		[Bindable]
		[Inject(source="loginViewController")]
		public var controller:ILoginViewController;
		/**************************************************************/
		/*********************  REQUEST/RESPONSE  *********************/
		/**************************************************************/
		
		/**
		 * 
		 * 
		 * @author silvano.dantas
		 */
		public function requestLogin():void{
			ProgressBarView.showProgressBar(root);
			controller.requestAutenticarUsuario(usuario,senha);
		}
		
		/**
		 * Resposta do método 'requestLogin'.
		 * 
		 * @author silvano.dantas
		 */
		[EventHandler(event="LoginViewEvent.LOGIN")]
		public function responseLogin():void{
			ProgressBarView.removeProgressBar();
			usuarioSistemaDTO=controller.usuarioSistemaDTO;
			//TODO - Pessima pratica(Melhorar futuramente)
			FlexGlobals.topLevelApplication.usuario= controller.usuarioSistemaDTO;
			dispatcher.dispatchEvent(new CRMEvent(CRMEvent.ESCOLAR_MODULE));
		}
		
		/**
		 * 
		 * 
		 * @author silvano.dantas
		 */
		public function requestAuthentication():void{
			ProgressBarView.showProgressBar(root);
			controller.requestAuthentication();
		}
	}
}