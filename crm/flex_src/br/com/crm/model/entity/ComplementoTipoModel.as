package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.ComplementoTipoModel")]
	public class ComplementoTipoModel
	{
		public var id:Number;
		
		public var txComplementoTipo:String;
		
		public var tbEnderecos:ArrayCollection;
	}
}