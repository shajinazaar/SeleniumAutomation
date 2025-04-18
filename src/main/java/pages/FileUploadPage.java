package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
    WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    By submitButton = By.id("file-submit");

    public void clickUpload() {
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fileInput);

    }

    public void submit() {
        driver.findElement(submitButton).click();
    }

    public boolean isFileUploaded(String filename) {
        return driver.getPageSource().contains(filename);
    }

    public void uploadFileWithSendKeys(String filePath) {
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
    }

}
