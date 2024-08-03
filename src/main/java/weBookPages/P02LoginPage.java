package weBookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import weBookBase.PageBase;

public class P02LoginPage extends PageBase {
    public P02LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By emailTitle = By.xpath("//*[normalize-space()='Email']");
    private final By emailInput = By.xpath("//*[@type='email']");
    private final By passwordTitle = By.xpath("//*[normalize-space()='Password']");
    private final By passwordInput = By.xpath("//*[@type='password']");
    private final By resetPassword = By.xpath("(//*[normalize-space()='Reset your password?'])[2]");
    private final By loginCTA = By.xpath("//*[@id='email-login-button']");
    private final By doNotHaveAnAccount = By.xpath("(//p[@class='text-sm'])[1]");
    private final By createAnAccount = By.xpath("//button[normalize-space()='Create an account']");
    private final By createANAccountTitle = By.xpath("//*[normalize-space()='Please complete your account details.']");
    public void checkLoginScreenElements(){
        ElementsValidator(emailTitle,emailInput,passwordTitle,passwordInput,resetPassword,loginCTA,doNotHaveAnAccount,createAnAccount);
        Assert.assertTrue(driver.findElement(doNotHaveAnAccount).getText().contains("Don't have an account?"));
    }
    public void checkNavigatingToRegister(){
        clickOnElement(createAnAccount);
        waitForVisibilityOfElement(createANAccountTitle);
    }
}
