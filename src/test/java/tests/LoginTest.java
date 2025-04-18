
package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.ScreenshotUtil;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(driver.getPageSource().contains("Logout"));
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login("invalid", "invalid");
        ScreenshotUtil.captureScreenshot(driver, "resources/invalid_login.png");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

}
