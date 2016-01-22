package br.com.crm.model.entity
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.LogradouroModel")]
	public class LogradouroModel
	{

		public var id:Number;
		
		public var inOficial:Boolean;
		
		public var txLogradouro:String;
		
		public var tbEnderecos:ArrayCollection;
		
		public var tbCep:CepModel;
		
		public var tbLogradouroTipo:LogradouroTipoModel;
		
	}
}