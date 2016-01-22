package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.BairroModel")]
	public class BairroModel
	{
		public var id:Number;
		
		public var inOficial:Boolean;
		
		public var txBairro:String;
		
		public var tbCidade:CidadeModel;
		
		public var tbCeps:ArrayCollection;

	}
}