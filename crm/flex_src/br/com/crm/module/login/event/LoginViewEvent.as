package br.com.crm.module.login.event
{
	import flash.events.Event;

	/**
	 * Classe responsável por criar um repositório de evento para View 'Login'.
	 * 
	 * @author silvano.dantas
	 * 
	 */
	public class LoginViewEvent extends Event{
		
		/**
		 * Construtor da classe.
		 *  
		 * @param type Tipo do Evento 'Login'.
		 * @author silvano.dantas
		 */
		public function LoginViewEvent(type:String){
			super(type);
		}
		
		//Constantes
		
		/* Evento responsável por tratar erros */
		public static const ERROR:String 	= "(LoginViewEvent) ERROR";
		
		/* Valida o usuário no sistema e cria uma sessão*/
		public static const LOGIN:String 	= "(LoginViewEvent) LOGIN";
		
		/* Remove sessão do usuário no sistema */
		public static const LOGOUT:String 	= "(LoginViewEvent) LOGOUT";
		
	}
}