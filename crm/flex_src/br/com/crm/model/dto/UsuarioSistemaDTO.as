package br.com.crm.model.dto
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.dto.UsuarioSistemaDTO")]
	public class UsuarioSistemaDTO
	{
		public var permissoes:ArrayCollection;
		
		public var usuario:String;
	}
}