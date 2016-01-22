package br.com.crm.event
{
	import flash.events.Event;

	/**
	 * Classe responsável por criar um repositório de evento para Aplicacao 'CRM'.
	 * 
	 * @author silvano.pessoa
	 * 
	 */
	public class CRMEvent extends Event
	{
		/**
		 * Construtor da classe.
		 *  
		 * @param type Tipo do Evento 'CRM'.
		 * @author silvano.pessoa
		 */
		public function CRMEvent(type:String)
		{
			super(type);
		}
		
		//Constantes
		
		/* Evento responsável por tratar erros */
		public static const ERROR:String 		= "(CRMEvent) ERROR";
		
		/* Evento responsável por carregar a permissão */
		public static const ESCOLAR_MODULE:String 	= "(CRMEvent) ESCOLAR_MODULE";
		
	}
}