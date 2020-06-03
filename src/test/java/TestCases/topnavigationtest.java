package TestCases;

import org.testng.annotations.Test;

import Way2auto.Pageobject.Topnavigation;

public class topnavigationtest {
     @Test
	public void topnavigate()
	{
    	 Topnavigation topnav= new Topnavigation();
    	 topnav.logout();
  		topnav.gotoactivity();
  		topnav.gotohome();
	}
}
