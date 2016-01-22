package br.com.crm.model.entity
{
	[Bindable]
	[RemoteClass(alias="br.com.crm.model.entity.EnderecoModel")]
	public class EnderecoModel
	{
		public var id:Number;
		
		public var dtCreate:Date;
		
		public var dtUpdate:Date;
		
		public var idEnderecoTipo:Number;
		
		public var idFuncionario:Number;
		
		public var idPessoa:Number;
		
		public var idUnidade:Number;
		
		public var txComplemento:String;
		
		public var txPontoReferencia:String;
		
		public var txTravessa1:String;
		
		public var txTravessa2:String;
		
		public var vlBloco:int;
		
		public var vlNumero:int;
		
		public var tbComplementoTipo:ComplementoTipoModel;
		
		public var tbLogradouro:LogradouroModel;
	}
}