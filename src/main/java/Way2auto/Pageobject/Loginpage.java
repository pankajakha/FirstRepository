package Way2auto.Pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Way2auto.Pageobject.HomePage;
import Way2auto.Pageobject.page;

public class Loginpage extends page{
	
	
    
	public Loginpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomePage login(String username , String password) throws IOException
	{
		type("username_xpath",username);
		type("pasword_xpath",password);
		driver.findElement(By.xpath(OR.getProperty("login_xpath"))).sendKeys(Keys.ENTER);
		return new HomePage();
	}

   
	
	
}
