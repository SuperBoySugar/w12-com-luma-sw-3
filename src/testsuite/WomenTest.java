package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        // Mouse hover on Women and then mouse hover on Tops
        doMouseHoverOnFirstThenSecondElement(By.xpath("//span[text()='Women']"),
                By.cssSelector("a[id='ui-id-9'] span:nth-child(1)"));
        // Mouse hover on Jacket and Click
        doMouseHoverAndClick(By.cssSelector("a[id='ui-id-11'] span:nth-child(1)"));
        // Selecting Product Name filter from Dropdown
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name");
        // Verifying products are displayed in alphabetical order
        verifyProductAreInAscendingOrder();
    }

    @Test
    public void verifyTheSortByPriceFilter() {

        // Mouse hover on Women and then mouse hover on Tops
        doMouseHoverOnFirstThenSecondElement(By.xpath("//span[text()='Women']"), By.cssSelector("a[id='ui-id-9'] span:nth-child(1)"));
        // Mouse hover on Jackets and Click
        doMouseHoverAndClick(By.cssSelector("a[id='ui-id-11'] span:nth-child(1)"));
        // Selecting Price from Sort By filter
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");
        // Verify the Products displayed by filter price
        verifyProductsAreSortedByLowToHigh();
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
