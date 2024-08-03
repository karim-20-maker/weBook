package weBookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import weBookBase.PageBase;

import java.util.List;

public class P03RegisterScreen extends PageBase {
    public P03RegisterScreen(WebDriver driver) {
        super(driver);
    }
    private final By firstNameTitle = By.xpath("//*[normalize-space()='First Name']");
    private final By firstNameInput = By.xpath("//*[@id='first_name']");
    private final By lastNameTitle = By.xpath("//*[normalize-space()='Last Name']");
    private final By lastNameInput = By.xpath("//*[@id='last_name']");
    private final By emailTitle = By.xpath("//*[normalize-space()='Email']");
    private final By emailInput = By.xpath("//*[@id='email']");
    private final By confirmEmailTitle = By.xpath("//*[normalize-space()='Confirm Email']");
    private final By confirmEmailInput = By.xpath("//*[@id='confirm_email']");
    private final By passwordTitle = By.xpath("//*[normalize-space()='Password']");
    private final By passwordInput = By.xpath("//*[@name='password']");
    private final By passwordIcon = By.xpath("(//*[name()='svg'][@class='fill-input/40'])[1]");
    private final By passwordWarningMessage = By.xpath("//*[normalize-space()='Passwords must be at least 8 characters and contain at least one letter and one number. Passwords are case sensitive']");
    private final By mobileNumberTitle = By.xpath("//*[normalize-space()='Mobile Number']");
    private final By mobileInput = By.xpath("//*[@type='tel']");
    private final By countryCodeDropDownArrow = By.cssSelector("button[aria-label='Open undefined'] svg");
    private final By egyptOption= By.xpath("//span[normalize-space()='Egypt']");
    private final By agreeTermsCheckBox = By.xpath("//input[@name='agreeTerms']");
    private final By createAnAccountCTA = By.xpath("//button[normalize-space()='Create Account']");
    private final By required = By.xpath("//*[normalize-space()='Required']");
    private final By userIcon = By.xpath("//*[@class='flex items-center gap-1 text-sm']");
    private String Email = generateRandoEmail();
    String Password = "Pass@" + generateRandomDigits(3);

    public void checkRegisterElements(){
        ElementsValidator(firstNameTitle,firstNameInput,lastNameTitle,lastNameInput
        ,emailTitle,emailInput,confirmEmailTitle,confirmEmailInput,passwordTitle,passwordInput
        ,passwordIcon,passwordWarningMessage,mobileNumberTitle,mobileInput,countryCodeDropDownArrow
        ,agreeTermsCheckBox,createAnAccountCTA);
    }
    public void selectEgypt(){
        scrollToElement(mobileNumberTitle);
        clickOnElement(countryCodeDropDownArrow);
        scrollToElement(egyptOption);
        clickOnElement(egyptOption);
    }
    public void checkMandatoryFields(){
        scrollToElement(createAnAccountCTA);
        clickOnElement(createAnAccountCTA);
        List<WebElement> messages = driver.findElements(required);
        for(int i = 0 ; i < messages.size();i++){
            Assert.assertTrue(messages.size()>3);
            scrollToElement(messages.get(i));
        }
    }
    private void scrollAndSendText(By element , String text){
            scrollToElement(element);
            sendTextToInputField(text,element);
    }
    public void fillRegisterForm(){
        scrollAndSendText(firstNameInput,"first name" + generateRandomDigits(3));
        scrollAndSendText(lastNameInput,"last name" + generateRandomDigits(3));
        scrollAndSendText(emailInput,Email);
        scrollAndSendText(confirmEmailInput,Email);
        scrollAndSendText(passwordInput,Password);
        scrollToElement(countryCodeDropDownArrow);
        selectEgypt();
        scrollAndSendText(mobileInput,generateRandomNumber());
        scrollToElement(agreeTermsCheckBox);
        clickOnElement(agreeTermsCheckBox);

    }
    private void createAccount(){
        scrollToElement(createAnAccountCTA);
        clickOnElement(createAnAccountCTA);
    }
    private void checkUserIcon(){
        waitForVisibilityOfElement(userIcon);
        clickOnElement(userIcon);
        waitForVisibilityOfElement(By.xpath("//*[normalize-space()='" +Email + "']"));
        clickOnElement(userIcon);
    }
    public void checkRegisterSuccessfully(){
        fillRegisterForm();
        createAccount();
        checkUserIcon();
    }
    public void checkRegisterWithInvalidPassword(){
        fillRegisterForm();
        checkInvalidPassword();
    }
    private void checkInvalidPassword(){
        scrollToElement(passwordInput);
        driver.findElement(passwordInput).clear();
        sendTextToInputField("123",passwordInput);
        waitForVisibilityOfElement(invalidPasswordMessage);

    }
    public void checkRegisterAfterCorrectPassword(){
        scrollToElement(passwordInput);
        driver.findElement(passwordInput).clear();
        sendTextToInputField(Password,passwordInput);
        createAccount();
        checkUserIcon();
        System.out.println("email===> " + Email);
        System.out.println("password===> " + Password);
    }
    private final By invalidPasswordMessage = By.xpath("//*[normalize-space()='Invalid password']");
}
