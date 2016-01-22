package br.com.crm.module.administrador.model.presentation
{
	import br.com.crm.model.presentation.PresentationModel;
	import br.com.crm.module.administrador.event.AdministratorModuleEvent;
	import br.com.crm.util.ApplicationAlerts;
	
	import flash.events.MouseEvent;

	public class MenuViewPresentationModel extends PresentationModel
	{
		/**
		 * 
		 * @param event
		 * 
		 */
		public function newBtnClick(event:MouseEvent):void{
			switch(event.target.label)
			{
				case "Logradouro":
					dispatcher.dispatchEvent(new AdministratorModuleEvent(AdministratorModuleEvent.NEW_LOGRADOURO));
					break;
				default:
					ApplicationAlerts.alert("Chamada Inválida!");
					break;
			}
		}
	}
}