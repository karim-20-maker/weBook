package weBookPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import weBookBase.PageBase;

import java.util.List;

public class P04SearchPage extends PageBase {
    public P04SearchPage(WebDriver driver) {
        super(driver);
    }
    private final By searchInput = By.xpath("//input[@inputmode='search']");
    private final By moduleSubTitle = By.xpath("//*[@class='text-sm leading-none text-gray-400']");
    private final By explore = By.xpath("//*[@data-category='Explore']");

    public void checkSearchTags(){
        waitForVisibilityOfElement(searchInput);
        clickOnElement(searchInput);
        checkElementsByText("Events","Experiences","Restaurants","Shows","Streams","Conferences");


    }
    public void checkElementsByText(String... text) {
        for (String elementText : text) {
            By element = By.xpath("//*[normalize-space()='" + elementText+ "']");
            scrollToElement(element);
            Assert.assertTrue(assertElementDisplayed(element));
        }
    }
    public void checkEachSearchModule(){
        scrollToElement(explore);
        clickOnElement(explore);
        checkEachSearchTag("Events","Experiences","Restaurants","Shows","Streams","Conferences");

    }
    public void checkEachSearchTag(String... text) {
        for (String elementText : text) {
            System.out.println(elementText);
            By element = By.xpath("//*[normalize-space()='" + elementText + "']");
            clickOnElement(element);
            for (int i = 0; i < driver.findElements(moduleSubTitle).size(); i++) {
                scrollToElement(driver.findElements(moduleSubTitle).get(i));
                Assert.assertTrue(driver.findElements(moduleSubTitle).get(i).getText().contains(trimLastCharacter(elementText)));
            }
            scrollToElement(element);
            clickOnElement(element);
        }
    }
}
