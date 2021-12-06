package FirstFramework.AppiumFramework1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public AppiumDriverLocalService startServer()
	{
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
	}
	public static void StartEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\StartEmulator.bat");
		Thread.sleep(6000);
	}
	//Start and stop the server programmatically
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	public static AndroidDriver<AndroidElement> capabilites(String appName) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub


		FileInputStream fil=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\FirstFramework\\AppiumFramework1\\global.properties");
		Properties prop= new Properties();
		prop.load(fil);

		//File directory
		File appDir= new File("src");
		File f= new File(appDir, (String)prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
	//	String device=(String) prop.get("device");
		
		String device=System.getProperty("deviceName");
		if(device.contains("Emulator"))
		{
			StartEmulator();
		}
		
		
		
		//add device name       
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		//Give automator name --UI Automator>> Andriod app
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);

		//Real Device
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); 
		// add location of the app in your system
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());		
		//Give port number
		driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
		return driver;
	}
	public static void screenshot(String s) throws IOException
	{
	File screenfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile((File) screenfile, new File("C:\\Users\\anass\\Desktop\\Files\\Automation Projects\\Mobile_Automation_Appuim\\"+s+".png"));
	}

}
