import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MoveTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wjm\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public  void movePicture() throws InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        driver.get("http://www.baidu.com");
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    public void getText() throws InterruptedException {
        driver.get("http://www.baidu.com" );
        String title = driver.getTitle();
        String url  =  driver.getCurrentUrl();
        String text = driver.findElement(By.name("tj_trnews")).getText();
        String tagname = driver.findElement(By.id("kw")).getTagName();
        String attribute = driver.findElement(By.id("su")).getAttribute("value");
        Thread.sleep(5000);
        System.out.println(title+url+text+tagname+attribute);
    }

    @Test
    public void js_control() throws InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("selenium");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }

    @Test
    public void frame_test(){
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.xpath("//*[@id=\"link\"]/a")).click();
    }

    @Test
    public void pullDownList() throws InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"moreSelect\"]"));
        Select select = new Select(element);
        select.selectByValue("oppe");
        Thread.sleep(3000);
        select.selectByIndex(4);
        Thread.sleep(3000);
        select.selectByVisibleText("meizu");
        Thread.sleep(3000);
    }

    @Test
    public void actionTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("kw"))).perform();
        Thread.sleep(3000);
        action.doubleClick(driver.findElement(By.id("su"))).perform();
        Thread.sleep(3000);

    }

    @Test
    public void elementMove() throws InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        //把鼠标移动到某元素上
        WebElement element = driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(3000);
        //拖拽元素到某坐标XY轴
        action.dragAndDropBy(element,500,500).perform();
        Thread.sleep(3000);
        //拖拽元素到元素中,并定位需要被定位的元素2
        WebElement element1 = driver.findElement(By.xpath("/html/body/h1"));
        action.clickAndHold(element).moveToElement(element1).perform();
        Thread.sleep(3000);
    }


    @Test
    public void multiSelect() throws InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        //按住shift键多选
        List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.keyDown(Keys.SHIFT).click(options.get(3)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(3000);
        //按住control键取消多选中的某选项
        action.keyDown(Keys.CONTROL)
                .click(options.get(0))
                .click(options.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(3000);
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        driver.get("file:///E:/selenium/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
