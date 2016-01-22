package br.com.crm.module.login.controller
{
	import br.com.crm.model.dto.UsuarioSistemaDTO;

	public interface ILoginViewController{
		
		//Variaveis
		function get dsLoginResposta():Object;
		function get usuarioSistemaDTO():UsuarioSistemaDTO;
		
		//Funções
		function requestLogin(usuario:String,senha:String):void;
		function requestAutenticarUsuario(usuario:String,senha:String):void;
		function requestAuthentication():void;
	}
}