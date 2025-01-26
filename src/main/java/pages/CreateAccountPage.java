package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CreateAccountPage extends MethodHandles {

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }


    private final By createAccountFirstNameField = By.cssSelector("#firstname");
    private final By createAccountLastNameField = By.cssSelector("#lastname");
    private final By createAccountEmailField = By.cssSelector("#email_address");
    private final By createAccountPasswordField = By.cssSelector("#password");
    private final By createAccountConfirmPasswordField = By.cssSelector("#password-confirmation");
    private final By createAccountButton = By.cssSelector("button[title='Create an Account']");



    @Step("insert Create Account First Name")
    public void insertCreateAccountFirstNameField(String accountFirstNameField){
        sendKeys(createAccountFirstNameField , 3 , accountFirstNameField);
    }

    @Step("insert Create Account Last Name")
    public void insertCreateAccountLastNameField(String accountLastNameField){
        sendKeys(createAccountLastNameField , 3 , accountLastNameField);
    }

    @Step("insert Create Account Email Address")
    public void insertCreateAccountEmailField(String accountEmailField){
        sendKeys(createAccountEmailField , 3 , accountEmailField);
    }

    @Step("insert Create Account Password")
    public void insertCreateAccountPasswordField(String accountPasswordField){
        sendKeys(createAccountPasswordField , 3 , accountPasswordField);
    }

    @Step("insert Create Account Confirm Password")
    public void insertCreateAccountConfirmPasswordField(String accountConfirmPasswordField){
        sendKeys(createAccountConfirmPasswordField , 3 , accountConfirmPasswordField);
    }


    @Step("Click On Create Account Button")
    public void clickOnCreateAccountButton(){
        click(createAccountButton , 3);
    }




}
