import br.com.crm.module.login.model.presentation.LoginViewPresentationModel;

	[Bindable]
	[Inject(source="loginViewPresentationModel")]
	public var model:LoginViewPresentationModel;


/**************************************************************/
/*********************** INICIALIZACAO ************************/
/**************************************************************/
	/**
	 * Inicializa o componente.
	 *  
	 * @author silvano.pessoa
	 */
	private function initView():void{
		model.root=this;
		model.versaoLogin=txtVersaoLogin.text;
		//model.requestAuthentication();
	}

