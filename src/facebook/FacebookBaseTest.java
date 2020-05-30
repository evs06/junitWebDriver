package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookBaseTest {
	
	protected WebDriver driver;
	
	public void setUp(String browser, String url) {
		System.out.println("Arranca el browser porfa y navega a la pagina.");
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		}
		if(browser.equals("firefox")){
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		System.out.println("Destruye la configuracion");
		driver.quit();
	}
	
	protected void likeAllPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void gotoPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void searchFacebookFriend(String friendName) {
		// TODO Auto-generated method stub
		
	}

	protected void logIntoFacebook(String user, String password) {
		// TODO Auto-generated method stub
		
	}

}
