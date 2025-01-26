package createAccount;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.JsonManager;

public class CreateAccountTest extends BaseTest {

    final private String registerPathTestDataFile = "./src/test/resources/magentoJsonDataFiles/registerData.json";
    final private JsonManager json = new JsonManager(registerPathTestDataFile);



    @Test
    public void testCreateAnAccountWithValidData(){

        // Click On Create-Account Link in Home Page
        HomePage page = new HomePage(driver);
        page.clickOnCreateAccountLink();


        // Fill out Create Account Data Form & Click On Create Button
        CreateAccountPage accountPage = new CreateAccountPage(driver);
        accountPage.insertCreateAccountFirstNameField(
                json.getData("CreateAccount1DataForm.ValidData.FirstName"));

        accountPage.insertCreateAccountLastNameField(
                json.getData("CreateAccount1DataForm.ValidData.LastName"));

        accountPage.insertCreateAccountEmailField(
                json.getData("CreateAccount1DataForm.ValidData.EmailAddress"));

        accountPage.insertCreateAccountPasswordField(
                json.getData("CreateAccount1DataForm.ValidData.Password"));

        accountPage.insertCreateAccountConfirmPasswordField(
                json.getData("CreateAccount1DataForm.ValidData.ConfirmPassword"));

        accountPage.clickOnCreateAccountButton();


        //Assert To Register Confirmation Success Message
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.getRegisterSuccessMessage(),
                json.getData("register1AccountSuccessMessage.ConfirmationMessage"));
    }

}
