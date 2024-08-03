package weBookTests;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weBookPages.P01HomePage;

public class M01HomeScreenTest extends BaseTest {
    P01HomePage home;
    @BeforeClass
    public void initObjects(){
        home = new P01HomePage(driver);
    }
    @Test
    public void Tc_01validateHomeScreen(){
        home.checkHomeScreen();
    }
    @Test
    public void Tc_02validateNavigatingToLoginScreen(){
        home.navigateToRegisterScreen();
    }
}
