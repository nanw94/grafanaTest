package example;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	private WebDriver driver;
	public static String OSDetector () {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		}else if (os.contains("mac")) {
			return "Mac";
		}else if (os.contains("sunos")) {
			return "Solaris";
		}else {
			return "Other";
		}
	}

	@Test

	public void test1() {
		driver.get("http://guru99.com");
		AssertJUnit.assertTrue(driver.getTitle().contains("Meet Guru99 - Free Training Tutorials"));

	}

	@Test
	public void test2() {
//		AssertJUnit.assertTrue(driver.getTitle().contains("Meet Guru90 - Free Training Tutorials"));
		AssertJUnit.assertTrue(driver.getTitle().contains("Meet Guru99 - Free Training Tutorials"));

	}

	@Test(dependsOnMethods = { "test2" })
	public void test3() {
		AssertJUnit.assertTrue(driver.getTitle().contains("Meet Guru99 - Free Training Tutorials"));
	}

	@BeforeTest
	public void beforeTest() {
		String osname= OSDetector ();
		if(osname.equals("Windows")){
			System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver.exe");
		}
		else if(osname.equals("Mac")){
			System.setProperty("webdriver.chrome.driver", "browser-drivers/chromedriver");
		}
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
