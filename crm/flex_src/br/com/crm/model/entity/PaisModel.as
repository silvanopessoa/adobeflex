package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.PaisModel")]
	public class PaisModel
	{
		public var id:Number;
		
		public var inSigla2:String;
		
		public var inSigla3:String;
		
		public var txPais:String;
		
		public var tbEstados:ArrayCollection;
	}
}