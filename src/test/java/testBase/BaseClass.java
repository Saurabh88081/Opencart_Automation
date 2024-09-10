package testBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v111.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	//public Browser br;
	public Properties properties;
	String propertyFilePath = ".//src/test/resources/config.properties";
    public Logger logger;
	@BeforeClass
	@Parameters({"os", "br"})
	public void setUp(String os, String br) throws MalformedURLException {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		logger=LogManager.getLogger(this.getClass());
		if(properties.getProperty("Execution_Environment").equalsIgnoreCase("Remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//Operating system
			if(os.equalsIgnoreCase("windows"))
			{
			  cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No match found");
			}
			//Browser name
			//WebDriverManager.chromedriver().setup();
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome"); break;
			case "edge" :cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox" :cap.setBrowserName("firefox"); break;
			default:System.out.println("No match found");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		if(properties.getProperty("Execution_Environment").equalsIgnoreCase("local"))
		{
		WebDriverManager.chromedriver().setup();
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default:System.out.println("Invalid browser name..");break;
		}
		}
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(properties.getProperty("App_URL"));// reading url from properties files
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomeAlphaNumberic() {
		String generatedString=RandomStringUtils.randomAlphanumeric(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return(generatedString+"@"+generatedNumber);
	}
	public String captureScreen(String tname) throws IOException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+".\\screenshots\\" + tname +"_" +timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
