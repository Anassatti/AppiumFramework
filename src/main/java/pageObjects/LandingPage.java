package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
private By sigining=By.cssSelector("a[href*='sign_in']");
private By title = By.cssSelector(".text-center>h2");
private By menu = By.cssSelector(".nav.navbar-nav.navbar-right");
private By forgetPassword= By.cssSelector("a[href*='password/new']");
private By header= By.cssSelector("div[class*='video-banner'] h3");



  public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  this.driver=driver;
}
  public ForgetPassword forGotPassword()
  {
	  driver.findElement(forgetPassword).click();
	return new ForgetPassword(driver);
  }

public WebElement getLogin()
  {
	  /* driver.findElement(sigining).click();
	   LoginPage log= new LoginPage(driver);
	   return log;*/
	return driver.findElement(sigining);
  }
public WebElement gettitle()
{
	  return driver.findElement(title);
}

public WebElement getmenu()
{
	System.out.println("Trying to identify navigation bar");
	  return driver.findElement(menu);
}


public WebElement getHeader() {
	// TODO Auto-generated method stub
	 return driver.findElement(header);
}
}
