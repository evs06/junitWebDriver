package imdb;

import org.junit.Test;

public class ImdbTest extends ParentTest{
	
	@Test
	public void testSearchMovie() {
		navigateToPage("http://imdb.com");
		validatePage();
		searchMovie("The Avengers");
		validateMovieExists("The Avengers: Los Vengadores");
	}
	
	
	@Test
	public void testPlayTrailer() throws InterruptedException {
		navigateToPage("http://imdb.com");
		validatePage();
		searchMovie("The Avengers");
		validateMovieExists("The Avengers: Los Vengadores");
		selectMovie("The Avengers: Los Vengadores", "2012");
		Thread.sleep(5000);
		validateCorrectMovie();
		playTrailer();
	}

	@Test
	public void testValidateMovieStars() {
		navigateToPage("http://imdb.com");
		validatePage();
		searchMovie("The Avengers");
		validateMovieExists("The Avengers: Los Vengadores");
		selectMovie("The Avengers: Los Vengadores", "2012");
		validateCorrectMovie();
		validateMovieStars();
	}

	

}
