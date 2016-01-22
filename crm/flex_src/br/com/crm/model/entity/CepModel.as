package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.CepModel")]
	public class CepModel
	{
		public var id:Number;
		
		public var inLadoRua:String;
		
		public var inOficial:Boolean;
		
		public var nrFaixaFinal:String;
		
		public var nrFaixaInicial:String;
		
		public var txCep:String;
		
		public var tbBairro:BairroModel;
		
		public var tbLogradouros:ArrayCollection;
	}
}