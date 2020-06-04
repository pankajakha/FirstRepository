package TestCases;

import java.io.IOException;

import Way2auto.Pageobject.HomePage;
import Way2auto.Pageobject.Loginpage;
import Way2auto.Pageobject.ProfilePage;

public class test {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		Loginpage p = new Loginpage();
		HomePage h =p.login("pankajakha@gmail.com", "swat92#");
		ProfilePage p2= h.profilenav();
		p2.updatephoto();
		System.out.println("Testing git");
		System.out.println("Thats correct");
        //new Loginpage().login("pankajakha@gmail.com", "swat92#").profilenav().updatephoto();
	}

}
