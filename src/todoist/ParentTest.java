package todoist;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.quit();

    }

    protected void navigateToPage(String url) {
        // TODO Auto-generated method stub
        driver.navigate().to(url);
    }

    protected void validarLandingPage() {

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[mask*='#logo-wordmark']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Inicia sesión")));

    }

    protected void login(String user, String password) {

        WebElement loginLink = driver.findElement(By.linkText("Inicia sesión"));
        loginLink.click();

        WebElement userLogin = driver.findElement(By.id("email"));
        userLogin.clear();
        userLogin.sendKeys(user);

        WebElement psdLogin = driver.findElement(By.id("password"));
        psdLogin.clear();
        psdLogin.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.cssSelector(".submit_btn"));
        loginBtn.click();

    }

    protected void validarHomePage() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".left_control > button:last-of-type")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".quick_find__input")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filter_upcoming")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_panel']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-track='navigation|projects_quick_add']")));

    }

    protected void crearProyecto(String nombreProyecto, String color) {

        Actions action = new Actions(driver);
        WebElement plusSign = driver.findElement(By.cssSelector("[data-track='navigation|projects_quick_add']"));
        action.moveToElement(plusSign).build().perform();
        plusSign.click();

        //Solución °2
        //WebElement addBtn = driver.findElement(By.cssSelector("[data-track='navigation|projects_quick_add']"));
        //addBtn.click();

        WebElement nameProject = driver.findElement(By.id("edit_project_modal_field_name"));
        nameProject.sendKeys(nombreProyecto);

        WebElement colorProject = driver.findElement(By.cssSelector(".color_dropdown_toggle"));
        colorProject.click();

        List<WebElement> listColors = driver.findElements(By.cssSelector(".color_dropdown_select__name"));

        for(WebElement colors: listColors) {

            //WebElement nomColor = colors.findElement(By.cssSelector(".color_dropdown_select__name"));
            String textColor = colors.getText();

            if(textColor.equals(color)){

                WebElement teal = colors.findElement(By.id("dropdown-select-4-option-38"));
                //String b = a.getText();
                //WebElement a = driver.findElement(By.cssSelector(".color_dropdown_select__name"));
                teal.click();
                break;
            }
            //System.out.println(textColor);
        }



    }

    protected void validarProyecto(String nombreProyecto, String color) {


    }



}
