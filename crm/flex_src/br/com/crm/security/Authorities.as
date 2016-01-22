package br.com.crm.security
{
	import mx.collections.ArrayCollection;

	public class Authorities
	{
		[Bindable]
		public  static var ROLE_USER:Boolean=false;
		
		[Bindable]
		public  static var ROLE_ADMIN:Boolean=false;
		
		public static function set authorities(roles:Array):void
		{
			ROLE_ADMIN 	= roles.indexOf("ROLE_ADMIN")>=0;
			ROLE_USER 	= roles.indexOf("ROLE_USER")>=0;
		}
	}
}