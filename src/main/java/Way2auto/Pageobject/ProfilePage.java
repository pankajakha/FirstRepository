package Way2auto.Pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Way2auto.Pageobject.HomePage;
import Way2auto.Pageobject.page;

public class ProfilePage extends page{

	
	public ProfilePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomePage updatephoto() throws InterruptedException, IOException
	{
		Boolean bool = iselement();
		System.out.println(bool);
		click("profilepic_xpath");
		//Thread.sleep(3000);
		type("uploadphoto_xpath","C:\\Users\\pankaj\\Desktop\\Fortune world school\\class 6 google form image.jpg");
        // WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OR.getProperty("zoom_xpath")))));
		click("cancel_xpath");
		click("cancelagain_xpath");
		click("home_xpath");
		click("confirm_xpath");
		return new HomePage();
	}
	
	public  boolean iselement()
	{
		try{
			//Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("profilepic_xpath")));
			return true;
		}
		catch(Throwable t)
		{
			return false;
		}
	}
	
	public void friendssearch()
	{
		click("profilepage_xpath");
		click("Friends_xpath");
		//WebElement count= driver.findElement(By.xpath(OR.getProperty("Friends_no_xpath")));
		//System.out.println("The print value is "+count.getText());
		//click("Friends_xpath");
		
		
	}
	public int searchresults(String value)
	{
		type("search_friends_xpath",value);
		List <WebElement> list= driver.findElements(By.xpath(OR.getProperty("Search_results_xpath")));
		int count = list.size();
		driver.findElement(By.xpath(OR.getProperty("search_friends_xpath"))).clear();
		return count;
	}
}
