package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    By tableRows = By.xpath("//table[1]/tbody/tr");

    public List<String> getAllNamesFromFirstColumn() {
        List<WebElement> rows = driver.findElements(tableRows);
        List<String> names = new ArrayList<>();
        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("td[1]")).getText();
            names.add(name);
        }
        return names;
    }

    public boolean isNamePresent(String nameToCheck) {
        return driver.getPageSource().contains(nameToCheck);
    }
}
