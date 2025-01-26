package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class MyAccountPage extends MethodHandles {


    public MyAccountPage(WebDriver driver){
        super(driver);
    }



    private final By registerSuccessMessage = By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    private final By clickOnBrandLogoInMyAccount = By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']");



    @Step("Get Register Success Message")
    public String getRegisterSuccessMessage(){
        return getText(registerSuccessMessage , 3);
    }




    @Step("Click On Brand Logo In My Account To Go Home Page")
    public HomePage clickOnBrandLogoInMyAccountToGoHomePage(){
        click(clickOnBrandLogoInMyAccount , 3);
        return new HomePage(driver);
    }
    



}
