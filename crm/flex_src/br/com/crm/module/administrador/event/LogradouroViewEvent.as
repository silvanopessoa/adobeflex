package br.com.crm.module.administrador.event
{
	import flash.events.Event;

	/**
	 * Classe responsável por criar um repositório de evento para View 'Logradouro'.
	 * 
	 * @author silvano.dantas
	 * 
	 */
	public class LogradouroViewEvent extends Event
	{
		
		/**
		 * Construtor da classe.
		 *  
		 * @param type Tipo do Evento 'Logradouro'.
		 * @author silvano.dantas
		 */
		public function LogradouroViewEvent(type:String)
		{
			super(type);
		}
		
		//Constantes
		
		/* Evento responsável por tratar erros */
		public static const ERROR:String 	= "(LogradouroViewEvent) ERROR";
		
		/* Evento responsável por solicitar uma nova view: Logradouro Oficial*/
		public static const NEW_LOGRADOURO:String 	= "(LogradouroViewEvent) NEW_LOGRADOURO";
	}
}