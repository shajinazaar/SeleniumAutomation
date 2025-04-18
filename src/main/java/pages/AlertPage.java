package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage{
    WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");

    public String handleJSAlert() {
        driver.findElement(jsAlertBtn).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        return msg;
    }

    public String handleJSConfirm(boolean accept) {
        driver.findElement(jsConfirmBtn).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        if (accept) alert.accept();
        else alert.dismiss();
        return msg;
    }

    public String handleJSPrompt(String inputText) {
        driver.findElement(jsPromptBtn).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.sendKeys(inputText);
        alert.accept();
        return msg;
    }
}
