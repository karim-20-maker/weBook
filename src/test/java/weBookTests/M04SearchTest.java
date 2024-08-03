package weBookTests;

import baseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import weBookPages.P01HomePage;
import weBookPages.P02LoginPage;
import weBookPages.P03RegisterScreen;
import weBookPages.P04SearchPage;

public class M04SearchTest extends BaseTest {
    P01HomePage home;
    P04SearchPage search;
    @BeforeClass
    public void initObjects(){
        home = new P01HomePage(driver);
        search = new P04SearchPage(driver);
    }
    @Test
    public void Tc_01validateSearchTags() {
        home.checkHomeScreen();
        search.checkSearchTags();

    }
    @Test
    public void Tc_02validateSearchTags(){
        search.checkEachSearchModule();
    }


}
