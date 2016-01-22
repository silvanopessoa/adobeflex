package br.com.crm.module.administrador.model.presentation
{
	import br.com.crm.model.presentation.PresentationModel;
	import br.com.crm.module.administrador.controller.ILogradouroViewController;
	import br.com.crm.module.administrador.event.LogradouroViewEvent;
	import br.com.crm.module.administrador.view.form.LogradouroForm;
	
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.managers.PopUpManager;
	
	import org.swizframework.core.ISwizAware;

	public class LogradouroViewPresentationModel extends PresentationModel
	{	
		/* CONTROLLER */
		[Bindable]
		[Inject(source="logradouroViewController")]
		public var controller:ILogradouroViewController;
		
		[Bindable]
		public var enderecoList:ArrayCollection;
		
	
		public function findEnderecoList():void
		{
			
		}
		
		public function editBtnClick(event:MouseEvent):void
		{
			//				if (usuarioGrid.selectedIndex > -1) {
			//					var selectedUsuario:Usuario = usuarioGrid.selectedItem as Usuario;
			//					showForm(selectedUsuario);
			//				}
		}
		
		public function deleteBtnClick(event:MouseEvent):void
		{
			//				if (usuarioGrid.selectedIndex > -1) {
			//					var selectedUsuario:Usuario = usuarioGrid.selectedItem as Usuario;
			//					showProgressBar();
			//					usuarioService.remove(selectedUsuario.id);
			//				}
		}
		
		public function detailsBtnClick(event:MouseEvent):void
		{
			
		}
		
		public function newBtnClick(event:MouseEvent):void
		{
			dispatcher.dispatchEvent(new LogradouroViewEvent(LogradouroViewEvent.NEW_LOGRADOURO));
		}
	}
}