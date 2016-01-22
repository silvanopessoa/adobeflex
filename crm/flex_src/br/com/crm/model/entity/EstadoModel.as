package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.EstadoModel")]
	public class EstadoModel
	{
		public var id:Number;
		
		public var inSigla2:String;
		
		public var txEstado:String;
		
		public var tbCidades:ArrayCollection;
		
		public var tbPais:PaisModel;
		
		public var tbRegiao:RegiaoModel;
	}
}