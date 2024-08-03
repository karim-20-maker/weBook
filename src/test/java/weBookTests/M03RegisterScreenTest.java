package weBookTests;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weBookPages.P01HomePage;
import weBookPages.P02LoginPage;
import weBookPages.P03RegisterScreen;

public class M03RegisterScreenTest extends BaseTest {
    P01HomePage home;
    P02LoginPage login;
    P03RegisterScreen register;
    @BeforeClass
    public void initObjects(){
        home = new P01HomePage(driver);
        login = new P02LoginPage(driver);
        register = new P03RegisterScreen(driver);
    }
    @Test
    public void Tc_01validateRegisterScreen() {
        home.checkHomeScreen();
        home.navigateToRegisterScreen();
        login.checkLoginScreenElements();
        login.checkNavigatingToRegister();
        register.checkRegisterElements();

    }

    @Test
    public void Tc_02validateRequiredFields(){
        register.checkMandatoryFields();
    }
    @Test
    public void Tc_03validateRegisterWithInvalidPasswordSchema(){
        register.checkRegisterWithInvalidPassword();
    }
    @Test
    public void Tc_04validateRegisterSuccessfully(){
        register.checkRegisterAfterCorrectPassword();
    }

}
