package br.com.crm.model.presentation
{
	import flash.events.IEventDispatcher;
	
	import mx.core.UIComponent;
	
	import org.swizframework.core.ISwiz;

	public class PresentationModel
	{

		public var root:UIComponent;
		
		/* Objeto para invocar um Evento */
		[Dispatcher]
		public var dispatcher:IEventDispatcher;
		
	
	}
}