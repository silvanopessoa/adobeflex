package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.LogradouroTipoModel")]
	public class LogradouroTipoModel
	{
		public var id:Number;
		
		public var inLogradouroTipoAbrev:String;
		
		public var txLogradouroTipo:String;
		
		public var tbLogradouros:ArrayCollection;
	}
}