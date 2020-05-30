package todoist;

import org.junit.Test;

public class TodoistTests extends ParentTest{


    @Test
    public void testSearchMovie() {
        navigateToPage("https://todoist.com/es");
        validarLandingPage();
        login("jomarnavarro@gmail.com", "Test@1234");
        validarHomePage();
        crearProyecto("proyectoXXXXL", "Teal");
        validarProyecto("prouectoXXXXL", "Teal");
    }


}
