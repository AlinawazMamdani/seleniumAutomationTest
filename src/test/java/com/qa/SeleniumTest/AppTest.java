package com.qa.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest{
 private WebDriver driver;
	@Before
	public void setup() {
		
		  System.setProperty("webdriver.chrome.driver",
	        		"C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  
	        
	       
	}
	@After
	public void teardown() {
		driver.quit();
		
	}
	@Ignore
	@Test
	public void test1() {
		driver.get("https://www.google.co.uk/");
        String xpathGoogleSearch="//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input";
        WebElement we= driver.findElement(By.xpath((xpathGoogleSearch)));
        we.sendKeys("cats");
        WebElement goButton= driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]"));
        goButton.submit();
        WebElement checkCats=driver.findElement(By.xpath("//*[@id=\"rhs_block\"]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/span"));
        assertEquals(checkCats.getText(),"Cat");
        
	}
	@Test
	@Ignore
	public void test2() {
		driver.get("http://thedemosite.co.uk/");
		WebElement addUserPath=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUserPath.sendKeys(Keys.ENTER);
		WebElement selectLogin=driver.findElement(By.name("username"));
		selectLogin.sendKeys("bobo");
		 selectLogin=driver.findElement(By.name("password"));
		selectLogin.sendKeys("bobo2");
		 selectLogin=driver.findElement(By.name("FormsButton2"));
		 selectLogin.sendKeys(Keys.ENTER);
		WebElement selectLoginPage=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		selectLoginPage.sendKeys(Keys.ENTER);
		selectLoginPage.sendKeys(Keys.TAB);
		selectLoginPage=driver.findElement(By.name("username"));
		selectLoginPage.sendKeys("bobo");
		selectLoginPage=driver.findElement(By.name("password"));
		selectLoginPage.sendKeys("bobo2");
		selectLoginPage=driver.findElement(By.name("FormsButton2"));
		selectLoginPage.sendKeys(Keys.ENTER);
		WebElement loginSuccess=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	    assertEquals(loginSuccess.getText(),"**Successful Login**");
	    
	}
	@Ignore
	@Test
	public void tabTest() {
		driver.get("http://thedemosite.co.uk/");
		WebElement addUserPath=driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUserPath.sendKeys(Keys.ENTER);
		WebElement selectLogin=driver.findElement(By.name("username"));
		selectLogin.sendKeys("bobo");
		selectLogin.sendKeys(Keys.TAB);
		selectLogin.sendKeys("bobo2");
	}
	@Test
	@Ignore
	public void shoppingTest() {
		driver.get("http://automationpractice.com/index.php");
		WebElement searchPath=driver.findElement(By.name("search_query"));
		searchPath.sendKeys("dress");
		searchPath.sendKeys(Keys.ENTER);
		WebElement number=driver.findElement(By.className("heading-counter"));
	    Integer things= Integer.parseInt(number.getText().substring(0, 1));
	    System.out.println(things);
	    assertNotSame(0,things);
	}
	@Test
	public void ftse() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		WebElement risers=driver.findElement(By.xpath("//*[@title=\"View risers\"]"));
		risers.sendKeys(Keys.ENTER);
		WebElement tableStuff=driver.findElement(By.className("table-odd"));
		System.out.println(tableStuff.getText());
		WebElement fallers=driver.findElement(By.xpath("//*[@title=\"View fallers\"]"));
		fallers.sendKeys(Keys.ENTER);
		tableStuff=driver.findElement(By.className("table-odd"));
		System.out.println(tableStuff.getText());
	}
}
