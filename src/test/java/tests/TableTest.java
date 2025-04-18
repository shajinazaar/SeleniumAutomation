package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;

import java.util.List;

public class TableTest extends BaseTest{
    TablePage tablePage;

    @BeforeMethod
    public void openTablePage() {
        driver.get("https://the-internet.herokuapp.com/tables");
        tablePage = new TablePage(driver);
    }

    @Test
    public void printCompanyNames() {
        List<String> names = tablePage.getAllNamesFromFirstColumn();
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        boolean found = tablePage.isNamePresent("Jason Doe");
        System.out.println("Is 'Jason Doe' present? " + found);
    }

}

