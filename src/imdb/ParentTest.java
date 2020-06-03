package imdb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ParentTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	protected void validateMovieExists(String movieName) {
		// TODO Auto-generated method stub
		WebElement resultado = driver.findElement(By.linkText(movieName));
		wait.until(ExpectedConditions.visibilityOf(resultado));
		assertTrue(resultado.isDisplayed());
	}
	protected void searchMovie(String movieName) {

		//encontrar el campo de busqueda name= "q"
		WebElement campoBusqueda = driver.findElement(By.cssSelector("[name='q']"));
		campoBusqueda.sendKeys(movieName);
		//encontrar el boton de busqueda id="navbar-submit-button
		WebElement botonBusqueda = driver.findElement(By.cssSelector("#suggestion-search-button"));
		botonBusqueda.click();
	}
	//Econtrar el campo busqueda

	protected void validatePage() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='q']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#home_img")));

	}

	protected void navigateToPage(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}
	
	protected void playTrailer() {
		WebElement iniciarTrailer = driver.findElement(By.cssSelector("[alt='Trailer']"));
		iniciarTrailer.submit();
		
	}

	protected void validateCorrectMovie() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='The Avengers: Los Vengadores Poster']")));
	}

	protected void selectMovie(String movieName, String movieYear) {
		// encontramos un elemento cuyo link diga 'movieName' y cuyo anio coincida con movieYear
		String xpathResultado = "//td[contains(., '" + movieName + " (" + movieYear+ ")')]/a";
		WebElement peliculaCorrecta = driver.findElement(By.xpath(xpathResultado));
		peliculaCorrecta.click();

		// TODO Auto-generated method stub
		
	}
	
	protected void validateMovieStars() {
		// TODO Auto-generated method stub
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[itemprop='ratingValue']")));

		WebElement estrellas = driver.findElement(By.cssSelector("[itemprop='ratingValue']"));
		String numeroEstrellas = estrellas.getText();

		if(numeroEstrellas.equals("8,0")){
			System.out.println("La película es correcta");
		}else{
			System.out.println("La no es correcta");
		}

	}


}
