import br.com.crm.module.administrador.model.presentation.LogradouroViewPresentationModel;
import br.com.crm.module.administrador.view.form.LogradouroForm;
import br.com.crm.security.Authorities;

import mx.managers.PopUpManager;

import org.swizframework.core.ISwiz;

	[Bindable]
	[Inject(source="logradouroViewPresentationModel")]
	public var model:LogradouroViewPresentationModel;

/**************************************************************/
/*********************** INICIALIZACAO ************************/
/**************************************************************/

	/* FORM */
	[Bindable]
	[Inject(source="logradouroForm")]
	public var logradouroForm:LogradouroForm;

	/**
	 * Inicializa o componente.
	 *  
	 * @author silvano.pessoa
	 */
	private function initView():void{
		model.root=this;
		_swiz.registerWindow(logradouroForm);
	}


	protected var _swiz : ISwiz;
	
	/**
	 * Implement ISwizAware so that we get the Swiz instance injected. We'll use this
	 * to register additional PopUps.
	 */
	public function set swiz( swiz : ISwiz ) : void
	{
		_swiz = swiz;
	}

	/**
	 * 
	 * 
	 */
	[EventHandler(event="LogradouroViewEvent.NEW_LOGRADOURO")]
	public function newLogradouroForm():void
	{
		PopUpManager.addPopUp(logradouroForm,this,true);
	}