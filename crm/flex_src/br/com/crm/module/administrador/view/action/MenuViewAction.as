// ActionScript file

import br.com.crm.module.administrador.event.AdministratorModuleEvent;
import br.com.crm.module.administrador.model.presentation.MenuViewPresentationModel;
import br.com.crm.module.administrador.view.LogradouroView;
import br.com.crm.security.Authorities;
import br.com.crm.util.ApplicationAlerts;

import flash.events.IEventDispatcher;
import flash.events.MouseEvent;

import mx.controls.Menu;

	
	[Bindable]
	[Inject(source="menuViewPresentationModel")]
	public var model:MenuViewPresentationModel;




