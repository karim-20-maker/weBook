package weBookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import weBookBase.PageBase;

public class P01HomePage extends PageBase {
    public P01HomePage(WebDriver driver) {
        super(driver);
    }
    private final By weBookTitle = By.xpath("//*[@data-title='webook.com for business']");
    private final By loginOrRegisterCTA = By.xpath("(//*[normalize-space()='Log In / Sign Up'])[2]");
    private final By weBookHeader = By.xpath("(//*[normalize-space()='Book the Best Events, Experiences and Shows in Saudi'])[2]");
    private final By loginTitle = By.xpath("//*[normalize-space()='Login to webook.com']");
    private final By acceptCookiesCTA = By.xpath("//*[normalize-space()='Accept cookies']");
   public void checkHomeScreen(){
        ElementsValidator(weBookTitle,loginOrRegisterCTA,weBookHeader);
        acceptCookies();
    }
    public void navigateToRegisterScreen(){
        clickOnElement(loginOrRegisterCTA);
        waitForVisibilityOfElement(loginTitle);
    }
    private void acceptCookies(){
       waitForVisibilityOfElement(acceptCookiesCTA);
       clickOnElement(acceptCookiesCTA);
    }

}

