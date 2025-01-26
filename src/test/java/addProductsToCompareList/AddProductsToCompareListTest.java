package addProductsToCompareList;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.JsonManager;


public class AddProductsToCompareListTest extends BaseTest {

    final private String registerPathTestDataFile = "./src/test/resources/magentoJsonDataFiles/registerData.json";
    final private JsonManager json = new JsonManager(registerPathTestDataFile);
    final private String hotSellersPathDataTest = "./src/test/resources/magentoJsonDataFiles/hotSellersData.json";
    final private JsonManager json1 = new JsonManager(hotSellersPathDataTest);



    @Test
    public void testAddTwoProductsToCompareList() {

        // Click On Create-Account Link in Home Page
        HomePage page = new HomePage(driver);
        page.clickOnCreateAccountLink();


        // Fill out Create Account Data Form & Click On Create Button
        CreateAccountPage accountPage = new CreateAccountPage(driver);
        accountPage.insertCreateAccountFirstNameField(
                json.getData("CreateAccountDataForm.ValidData.FirstName"));

        accountPage.insertCreateAccountLastNameField(
                json.getData("CreateAccountDataForm.ValidData.LastName"));

        accountPage.insertCreateAccountEmailField(
                json.getData("CreateAccountDataForm.ValidData.EmailAddress"));

        accountPage.insertCreateAccountPasswordField(
                json.getData("CreateAccountDataForm.ValidData.Password"));

        accountPage.insertCreateAccountConfirmPasswordField(
                json.getData("CreateAccountDataForm.ValidData.ConfirmPassword"));

        accountPage.clickOnCreateAccountButton();


        //Assert To Register Confirmation Success Message
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.getRegisterSuccessMessage(),
                json.getData("registerAccountSuccessMessage.ConfirmationMessage"));

        myAccountPage.clickOnBrandLogoInMyAccountToGoHomePage();


        // Add Two Products To Compare List
        HomePage hotSellers = new HomePage(driver);
        Assert.assertEquals(hotSellers.getHotSellersTitle() , json1.getData("TitlePage.HotSellersTitle"));
        Assert.assertTrue(hotSellers.listOfHotelSellersIsDisplay());
        hotSellers.selectAndClickAProduct();
        hotSellers.selectAndClickAProduct2();
    }

}


  