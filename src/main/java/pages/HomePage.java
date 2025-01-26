package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JsonManager;
import utils.MethodHandles;

import java.util.List;

public class HomePage extends MethodHandles {



    public HomePage(WebDriver driver){
        super(driver);
    }


    private final By createAccountLink = By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)");
    private final By listOfHotSellers =  By.cssSelector(".product-items.widget-product-grid");
    private final By hotSellersTitle = By.cssSelector("h2[class='title']");
    private final By addCompareButton = By.xpath("(//a[@title='Add to Compare'])[1]");
    private final By addCompareButton2 = By.xpath("(//a[@title='Add to Compare'])[2]");


    @Step("Click On Create Account Link Page")
    public void clickOnCreateAccountLink(){
        click(createAccountLink , 3);
    }

    @Step("Get Hot Sellers Title")
    public String getHotSellersTitle(){
        ScrollDown(driver);
        return getText(hotSellersTitle , 3);
    }

    @Step("Get List Of Hot Sellers Products are Displayed ")
    public boolean listOfHotelSellersIsDisplay(){
        return isDisplayed(listOfHotSellers , 3);
    }

    @Step("Click On Product to adds it to Compare List")
    public void selectAndClickAProduct(){
        click(addCompareButton, 10);

    }

    @Step("Click On Product to adds it to Compare List")
    public void selectAndClickAProduct2(){
        ScrollDown(driver);
        click(addCompareButton2, 10);
    }
}