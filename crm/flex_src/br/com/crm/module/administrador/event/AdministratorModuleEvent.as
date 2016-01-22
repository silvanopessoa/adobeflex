package br.com.crm.module.administrador.event
{
	import flash.events.Event;

	/**
	 * Classe responsável por criar um repositório de evento para Module 'Administrator'.
	 * 
	 * @author silvano.dantas
	 * 
	 */
	public class AdministratorModuleEvent extends Event
	{
		
		/**
		 * Construtor da classe.
		 *  
		 * @param type Tipo do Evento 'Administrator'.
		 * @author silvano.dantas
		 */
		public function AdministratorModuleEvent(type:String)
		{
			super(type);
		}
		
		//Constantes
		
		/* Evento responsável por tratar erros */
		public static const ERROR:String 	= "(AdministratorModuleEvent) ERROR";
		
		/* Evento responsável por solicitar uma nova view: Logradouro Oficial*/
		public static const NEW_LOGRADOURO:String 	= "(AdministratorModuleEvent) NEW_LOGRADOURO";

	}
}