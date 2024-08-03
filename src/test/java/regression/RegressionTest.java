package regression;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weBookPages.P01HomePage;
import weBookPages.P02LoginPage;
import weBookPages.P03RegisterScreen;
import weBookPages.P04SearchPage;

public class RegressionTest extends BaseTest {
    P01HomePage home;
    P02LoginPage login;
    P03RegisterScreen register;
    P04SearchPage search;
    @BeforeClass
    public void initObjects(){
        home = new P01HomePage(driver);
        login = new P02LoginPage(driver);
        register = new P03RegisterScreen(driver);
        search = new P04SearchPage(driver);
    }
    @Test
    public void Tc_01validateHomeScreen(){
        home.checkHomeScreen();
    }

    @Test
    public void Tc_02validateLoginScreen() {
        home.navigateToRegisterScreen();
        login.checkLoginScreenElements();
    }
    @Test
    public void Tc_03validateNavigatingToRegisterScreen(){
        login.checkNavigatingToRegister();
    }

    @Test
    public void Tc_05validateRequiredFields(){
        register.checkMandatoryFields();
    }
    @Test
    public void Tc_06validateRegisterWithInvalidPasswordSchema(){
        register.checkRegisterWithInvalidPassword();
    }
    @Test
    public void Tc_07validateRegisterSuccessfully(){
        register.checkRegisterAfterCorrectPassword();
    }
    @Test
    public void Tc_08validateSearchTags() {
        search.checkSearchTags();

    }
    @Test
    public void Tc_09validateSearchTags(){
        search.checkEachSearchModule();
    }


}
