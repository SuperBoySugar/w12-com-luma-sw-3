package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {

        // Mouse hover on Gear tab
        doMouseHoverNoClick(By.cssSelector("a[id='ui-id-6'] span:nth-child(2)"));
        // Clicking on Bags option
        clickOnElement(By.xpath("//span[text()='Bags']"));
        // Clicking on Overnight Duffle bag
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle ')]"));

        // To Verify the Text 'Overnight Duffle'
        verifyText("Overnight Duffle", By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Product not displayed");
        // Removed existing quantity value added new value '3'
        sendTextElement(By.id("qty"), Keys.DELETE + "3");
        // Clicking on Add to Cart button
        clickOnElement(By.id("product-addtocart-button"));
        // Verifying product added to cart
        verifyText("You added Overnight Duffle to your shopping cart.",
                By.xpath("//div[contains(text(),'You added Overnight Duffle to your ')]"),
                "User is not added Overnight Duffle to their shopping cart.");

        // Clicking on Shopping cart link
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        // Verify the Product Name in the Cart
        verifyText("Overnight Duffle", By.cssSelector("td[class='col item'] strong[class='product-item-name']"),
                "Product is not displayed");
        // Verify Quantity '3' into cart
//        verifyText("3", By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), "Quantity is not change");

        // Verify the product price '$135.00'
        verifyText("$135.00",By.xpath("//td[@class='col subtotal']//span[@class='price']"),"The price is not displayed");

        // Change Quantity to '5'
        sendTextElement(By.cssSelector("td[class='col qty'] input[class*='input-text qty']"), Keys.DELETE + "5");
        // Click On 'Update Shopping Cart' button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        // Verify the product price '$225.00'
        verifyText("$225.00",By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"),"The price is displayed");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
