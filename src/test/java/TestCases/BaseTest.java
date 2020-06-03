package TestCases;

import org.testng.asserts.SoftAssert;

import Way2auto.Pageobject.ExcelReader;

public class BaseTest {
	public static ExcelReader excel = new ExcelReader("./Runner/testdata.xlsx");
	public static SoftAssert softassert = new SoftAssert();
	
}
