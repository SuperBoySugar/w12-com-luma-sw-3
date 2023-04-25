package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {

        // Mouse hover on Mens tab and then mouse hover on Bottoms
        doMouseHoverOnFirstThenSecondElement(By.xpath("//span[normalize-space()='Men']"), By.cssSelector("a[id='ui-id-18'] span:nth-child(1)"));
        // Mouse hover and Click on Pants
        doMouseHoverAndClick(By.cssSelector("a[id='ui-id-23'] span:nth-child(1)"));

        // Mouse hover on 'Cronus Yoga Pant' and mouse hover and click on size 32
        doMouseHoverOnFirstThenSecondAndClick(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"),
                By.cssSelector("#option-label-size-143-item-175"));
        // Mouse hover and click on Colour Black
        doMouseHoverAndClick(By.cssSelector("#option-label-color-93-item-49"));
        // Clicking on Add to Cart button
        clickOnElement(By.xpath("//span[text() = 'Add to Cart']"));

       // Verify product added to cart message
        verifyText("You added Cronus Yoga Pant to your shopping cart.",
                By.xpath("//div[contains(text(),'You added Cronus Yoga Pant  to your ')]"),
                "User is not able to add Cronus Yoga Pant to their shopping cart.");
        // Clicking on Shopping cart link
        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        // Verify Shopping Cart Title
        verifyText("Shopping Cart", By.xpath("//span[text()='Shopping Cart']"), "Shopping Cart");
        // Verify the Product Name in the Cart
        verifyText("Cronus Yoga Pant", By.cssSelector("td[class='col item'] strong[class='product-item-name']"),
                "Cronus Yoga Pant ");
        // Verify the Product Size 32
        verifyText("32", By.xpath("//dd[contains(text(),'32')]"), "32");
        // Verify Product Colour is Black
        verifyText("Black", By.xpath("//dd[contains(text(),'Black')]"), "Black");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
