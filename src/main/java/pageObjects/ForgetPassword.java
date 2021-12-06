package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {

	public WebDriver driver;
	
	By email=	By.cssSelector("[id='user_email']");

By sendMeInstruction= By.cssSelector("[type='submit']");



  public ForgetPassword(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  this.driver=driver;
}
  public WebElement getEmail()
  {
	  return driver.findElement(email);
  }
  
  public WebElement sendMeInstruction()
  {
	  return driver.findElement(sendMeInstruction);
  }

}
