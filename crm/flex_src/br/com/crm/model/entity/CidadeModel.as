package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.CidadeModel")]
	public class CidadeModel
	{
		public var id:Number;

		public var txCidade:String;
		
		public var tbBairros:ArrayCollection;
		
		public var tbEstado:EstadoModel;
	}
}