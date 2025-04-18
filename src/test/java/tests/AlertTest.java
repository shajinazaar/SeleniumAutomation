package tests;
import org.testng.annotations.*;
import pages.AlertPage;

public class AlertTest extends BaseTest{

    AlertPage alertPage;

    @BeforeMethod
    public void openAlertPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        alertPage = new AlertPage(driver);
    }

    @Test
    public void testJSAlerts() {
        String alertMsg = alertPage.handleJSAlert();
        System.out.println("Alert Message: " + alertMsg);

        String confirmMsg = alertPage.handleJSConfirm(false);
        System.out.println("Confirm Message: " + confirmMsg);

        String promptMsg = alertPage.handleJSPrompt("Shaji");
        System.out.println("Prompt Message: " + promptMsg);
    }

}
