package FirstFramework.AppiumFramework1;
import static java.time.Duration.ofSeconds;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerceProject_TC4 extends base {

	@Test
	public void totalValidation() throws IOException, InterruptedException {


		// TODO Auto-generated method stub
		service=startServer();
		AndroidDriver<AndroidElement> driver= capabilites("GeneralStoreApp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Anas");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByXPath("//*[@text='Australia']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(4000);
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0.0;
		for(int i=0; i<count;i++)
		{
			String amount1= driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText(); 
			double amount=getAmount(amount1);
			sum=sum+amount;
		}


		String total=	driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		total=total.substring(1);
		double totalValue=Double.parseDouble(total);
		System.out.println("Total values"+totalValue);
		Assert.assertEquals(sum, totalValue);
	//	service.stop();
	}
@BeforeTest
public void KillAll() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("taskkill  /F  /IM  node.exe");
	Thread.sleep(3000);
}
@AfterTest
public void KillAll2() throws IOException, InterruptedException
{
	Runtime.getRuntime().exec("taskkill  /F  /IM  node.exe");
	Thread.sleep(3000);
}
	public static double getAmount(String value)
	{
		value=value.substring(1);
		double amountvalue1=Double.parseDouble(value);

		return amountvalue1;
	}
}
