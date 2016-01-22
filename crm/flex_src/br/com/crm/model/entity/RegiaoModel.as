package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.RegiaoModel")]
	public class RegiaoModel
	{
		public var id:Number;
		
		public var txRegiao:String;
		
		public var tbEstados:ArrayCollection;
	}
}