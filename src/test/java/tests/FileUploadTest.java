package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FileUploadPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;

public class FileUploadTest extends BaseTest {
    FileUploadPage uploadPage;

    @BeforeMethod
    public void openUploadPage() {
        driver.get("https://the-internet.herokuapp.com/upload");
        uploadPage = new FileUploadPage(driver);
    }

    @Test
    public void uploadFileUsingRobot() throws AWTException, InterruptedException {
        uploadPage.clickUpload();

        String path = Paths.get("resources", "testfile.txt").toAbsolutePath().toString();
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(5000); // longer delay to focus dialog
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        uploadPage.submit();
        Assert.assertTrue(uploadPage.isFileUploaded("testfile.txt"));
    }


}
