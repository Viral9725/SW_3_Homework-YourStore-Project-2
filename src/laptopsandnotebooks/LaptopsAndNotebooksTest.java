package laptopsandnotebooks;

import baseTest.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 1.3 Select Sort By "Price (High > Low)"
        mouseHoverOnElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Name (A - Z)')]"));
        // 1.4 Verify the Product price will arrange in High to Low order.
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        assertVerifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        // 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 2.3 Select Sort By "Price (High > Low)"
        mouseHoverOnElement(By.xpath("//label[contains(text(),'Sort By:')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        // 2.5 Verify the text “MacBook”
        assertVerifyText(By.xpath("//h1[normalize-space()='MacBook']"), "MacBook");
        // 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertVerifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!");
        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart'],'shopping cart')]"));
        // 2.9 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//a[normalize-space()='shopping cart'],'shopping cart')]"), "shopping cart");
        // 2.10 Verify the Product name "MacBook"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        // 2.11 Change Quantity "2"
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        // 2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        assertVerifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"), "Success: You have modified your shopping cart!");
        // 2.14 Verify the Total £737.45
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"), "$1,204.00");
        // 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        // 2.16 Verify the text “Checkout”
        assertVerifyText(By.xpath("//a[contains(text(),'Checkout')]"), "Checkout");
        // 2.17 Verify the Text “New Customer”
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");
        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));
        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        // 2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='input-payment-firstname']"));
        sendTextToElement(By.name("firstname"), "viral");
        sendTextToElement(By.name("lastname"), "patel");
        sendTextToElement(By.name("email"), "viral123456@gmail.com");
        sendTextToElement(By.name("//input[@id='input-payment-telephone']"), "07875795650");

        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("postcode"), "SW0 92Y");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 street");
        sendTextToElement(By.id("input-payment-postcode"), "NW10 R74");
        clickOnElement(By.id("BillingNewAddress_CountryId"));
        selectByValueFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByValueFromDropDown(By.id("input-payment-zone"), "Greater London");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']']"), "Greater London");

//        clickOnElement(By.id("register-button"));
//        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
//        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
//        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
//        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1998");

        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        // 2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Hello,tutorials ninja?");

        // 2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // 2.25 Verify the message “Warning: Payment method required!”
        assertVerifyText(By.xpath("//div[@class='alert alert-danger alert-dismissible']"),"Warning: Payment method required!");

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
