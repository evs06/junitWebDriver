package todoist;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class TodoistTests extends ParentTest{

    @Test
    @FileParameters("./data/paramsTodoist.csv")
    public void testSearchMovie(String browser, String url, String user, String password,
                                String projectName, String color)
    {
        setUp(browser, url);
        validarLandingPage();
        login(user, password);
        validarHomePage();
        crearProyecto(projectName, color);
        validarProyecto(projectName, color);
    }
}
