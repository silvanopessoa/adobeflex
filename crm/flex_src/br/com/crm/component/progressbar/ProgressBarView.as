package br.com.crm.component.progressbar
{
	import mx.controls.ProgressBar;
	import mx.core.FlexGlobals;
	import mx.core.UIComponent;
	import mx.managers.PopUpManager;
	
	public class ProgressBarView extends ProgressBar
	{
		private static var progressBar:ProgressBar;
		
		public function ProgressBarView()
		{
			if(progressBar ==null){
				progressBar = new ProgressBar();
				progressBar.indeterminate = true;
				progressBar.mode="manual";
				progressBar.label = 'Processando...';
			}
		}
		
		public static function showProgressBar(ui:UIComponent):void {
			PopUpManager.addPopUp(progressBar,ui, true);
			PopUpManager.centerPopUp(progressBar);
		}
		
		public static function removeProgressBar():void {
			PopUpManager.removePopUp(progressBar);
		}
	}
}