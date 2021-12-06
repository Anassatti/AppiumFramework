package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage (AndroidDriver<AndroidElement> driver)  {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femalOption;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement conuntrySelection;
	
	public WebElement getNameField()
	{
		System.out.println("Trying to find name field");
		return nameField;
	}
	public WebElement conuntrySelection()
	{
		System.out.println("Selecting the option from dropdown list");
		return conuntrySelection;
	}
	
	}
