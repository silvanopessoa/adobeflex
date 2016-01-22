package br.com.crm.controller{
	import br.com.crm.component.progressbar.ProgressBarView;
	import br.com.crm.util.ApplicationAlerts;
	
	import flash.events.IEventDispatcher;
	
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	
	import org.swizframework.utils.services.ServiceHelper;

	/** Controller
	 * 
	 * Classe pai responsável por implementar a estrutura básica da camada controller.
	 * @author silvano.dantas
	 * 
	 */
	public class Controller{
		/* Objeto para acesso a camada Service */
		[Inject]
		public var sh:ServiceHelper;
		
		/* Objeto para invocar um Evento */
		[Dispatcher]
		public var dispatcher:IEventDispatcher;
		
		/**
		 * Trata formatado da mensagem de erro e o fluxo.
		 * 
		 * @param event Evento de Erro.
		 * @author silvano.dantas
		 */
		protected function onError(event:FaultEvent):void {
			ProgressBarView.removeProgressBar();
			switch (event.fault.faultCode) { 
				case "Application.Exception" : 
					ApplicationAlerts.applicationException(event);
					break; 
				case "Application.Alert" : 
					ApplicationAlerts.applicationAlert(event);
					break; 
				default : 
					ApplicationAlerts.applicationException(event);
			}
		}
		
		protected function onFault(event:FaultEvent,token:Object = null):void {
			ProgressBarView.removeProgressBar();
			Alert.show(event.fault.faultString, "Login Failed");
		}
			
	}
}