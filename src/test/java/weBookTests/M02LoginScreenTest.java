package weBookTests;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weBookPages.P01HomePage;
import weBookPages.P02LoginPage;

public class M02LoginScreenTest extends BaseTest {
    P01HomePage home;
    P02LoginPage login;
    @BeforeClass
    public void initObjects(){
        home = new P01HomePage(driver);
        login = new P02LoginPage(driver);
    }
    @Test
    public void Tc_01validateLoginScreen() {
        home.checkHomeScreen();
        home.navigateToRegisterScreen();
        login.checkLoginScreenElements();
    }
    @Test
    public void Tc_02validateNavigatingToRegisterScreen(){
        login.checkNavigatingToRegister();
    }

}
