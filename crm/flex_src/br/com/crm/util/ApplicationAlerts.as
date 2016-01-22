package br.com.crm.util
{
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;

	/**
	 * 
	 * @author silvano.dantas
	 * 
	 */
	public class ApplicationAlerts{
			
			/**
			 * 
			 * @param event
			 * @return 
			 * @author silvano.dantas
			 * 
			 */
			public static function applicationException(event:FaultEvent):void{
				Alert.yesLabel="CONTINUAR";
				Alert.noLabel="REPORTAR";
				Alert.buttonWidth=90;
				Alert.show("Ocorreu um erro imprevisto! \nContate o suporte ou reporte o problema!","Mensagem de Erro",Alert.YES | Alert.NO);
			}
			
			/**
			 * 
			 * @param event
			 * @return 
			 * @author silvano.dantas
			 * 
			 */
			public static function applicationAlert(event:FaultEvent):void{
				Alert.show(event.fault.faultString,"Mensagem de Alerta");
			}
			
			public static function alert(mensagem:String):void{
				Alert.show(mensagem,"Mensagem de Alerta");
			}
			
	}
}