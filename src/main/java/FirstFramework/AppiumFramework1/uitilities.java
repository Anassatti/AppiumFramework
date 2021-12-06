package FirstFramework.AppiumFramework1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class uitilities {
	
	AndroidDriver driver;
	
	public uitilities(AndroidDriver<AndroidElement> driver)
	{
	   this.driver=driver;
	}
	
	public void scrolToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"));");
	}

}
