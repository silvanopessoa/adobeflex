
import br.com.crm.module.administrador.model.presentation.LogradouroFormPresentationModel;

import mx.managers.PopUpManager;

	[Bindable]
	[Inject(source="logradouroFormPresentationModel")]
	public var model:LogradouroFormPresentationModel;

/**************************************************************/
/*********************** INICIALIZACAO ************************/
/**************************************************************/

	/**
	 * Inicializa o componente.
	 *  
	 * @author silvano.pessoa
	 */
	private function initForm():void{
		PopUpManager.centerPopUp(this);
	}


/**************************************************************/
/*********************** FINALIZACAO ************************/
/**************************************************************/

	/**
	 * Finaliza o componente.
	 *  
	 * @author silvano.pessoa
	 */
	private function closeForm():void{
		PopUpManager.removePopUp(this);
	}