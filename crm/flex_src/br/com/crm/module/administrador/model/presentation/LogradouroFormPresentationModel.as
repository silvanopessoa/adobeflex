package br.com.crm.module.administrador.model.presentation
{
	import br.com.crm.model.presentation.PresentationModel;
	import br.com.crm.module.administrador.controller.ILogradouroFormController;

	public class LogradouroFormPresentationModel extends PresentationModel
	{
		/* CONTROLLER */
		[Bindable]
		[Inject(source="logradouroFormController")]
		public var controller:ILogradouroFormController;
		
		/* COMBOS ENABLED*/
		[Bindable]
		public var CMB_ESTADO_ENABLE:Boolean;
		
		[Bindable]
		public var CMB_CIDADE_ENABLE:Boolean;
		[Bindable]
		public var CMB_BAIRRO_ENABLE:Boolean;
		
		[Bindable]
		public var CMB_CEP_ENABLE:Boolean;
	}
}