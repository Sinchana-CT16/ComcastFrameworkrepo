package Practice;
//
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class Demo {
//    public static void main(String[] args) throws Exception {
//
//        // 1. Create a small file to upload
////        File file = File.createTempFile("robot-demo", ".txt");
////        Files.writeString(file.toPath(), "Hello Robot");
////        String path = file.getAbsolutePath();
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://the-internet.herokuapp.com/upload");
//
//        // 2. Click "Choose File" using Actions (real mouse click) -> OS dialog opens
//        WebElement upload = driver.findElement(By.id("file-upload"));
//        new Actions(driver).moveToElement(upload).click().perform();
//
//		 // 3. Copy the file path to the clipboard
//       Toolkit
//         .getDefaultToolkit().getSystemClipboard()
//               .setContents(new StringSelection("C:\\Users\\User\\Downloads\\Petstore.postman_globals.json"), null);
//Thread.sleep(2000);
//        Robot robot = new Robot();
//        robot.delay(2000);                       // wait for dialog to open
//
//        // 4. Ctrl + V (paste the path)
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        Thread.sleep(2000);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.delay(2000);
//
//        // 5. Enter (confirm the file)
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(2000);
//
//        // 6. Submit and verify
//        driver.findElement(By.id("file-submit")).click();
//        String result = driver.findElement(By.tagName("h3")).getText();
//        System.out.println(result); 
//        // File Uploaded!
//       
//
//        driver.quit();
//    }
//}

public class Demo {
	
}






























