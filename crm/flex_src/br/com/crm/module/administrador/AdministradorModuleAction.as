import br.com.crm.module.administrador.view.LogradouroView;
import br.com.crm.security.Authorities;

import mx.core.FlexGlobals;
import mx.events.FlexEvent;

	public var enderecoOficial:LogradouroView;

	public function creationComplete(event:FlexEvent):void{
		Authorities.authorities=FlexGlobals.topLevelApplication.usuario.permissoes.source;
	}

	[EventHandler(event="AdministratorModuleEvent.NEW_LOGRADOURO")]
	public function newEnderecoOficial():void{
		vstkMenu.removeAllChildren();
		enderecoOficial = new LogradouroView();
		enderecoOficial.minHeight=200;
		enderecoOficial.minWidth=200;
		vstkMenu.addChild(enderecoOficial);
	}