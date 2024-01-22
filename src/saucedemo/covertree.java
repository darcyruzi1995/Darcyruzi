package saucedemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.Assert;
import org.testing.annotations.AfterTest;
import org.testing.annotations.BeforeTest;
import org.testing.annotations.Test;

import java.util.List;

public class covertree {
    @Test
    public void logintest(){
        system.setProperty("webdriver.chrome.driver","C://webdrivers/chromedriver.exe");
        webDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.close();




    }



    @Test
    public void testInvalidLogin() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn_action")); usernameField.sendKeys("invalid_user");
        passwordField.sendKeys("invalid_password");
        loginButton.click();
        WebElement errorContainer = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorMessage = errorContainer.getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void testAddToCart() {
        // Login with valid credentials (assuming the login functionality is tested separately)
        // ... (login code)
        // Add items to the shopping cart
        // ... (code to add items)
        // Navigate to the shopping cart
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        // Verify that the added items are displayed in the cart
        List cartItems = driver.findElements(By.cssSelector("#inventory_sidebar_link"));
        Assert.assertTrue(cartItems.size() > 0);

    }
    @Test
    public void testPurchase() {
        // Login with valid credentials (assuming the login functionality is tested separately)
        // ... (login code)
        // Add items to the shopping cart
        // ... (code to add items)
        // Navigate to the shopping cart
        driver.findElement(By.cssSelector("#shopping_cart_link")).click();
        // Proceed to checkout and complete the purchase
        driver.findElement(By.cssSelector("#checkout")).click();
        // ... (code to enter shipping/payment details and complete the purchase)
        // Verify that a confirmation message is displayed
        WebElement confirmationMessage = driver.findElement(By.cssSelector("#complete-header"));
        Assert.assertEquals(confirmationMessage.getText(), "THANK YOU FOR YOUR ORDER");
    }
}
