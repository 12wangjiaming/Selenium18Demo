package com.jiamingDay01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @DataProvider(name = "data4")
    public Object [] [] test1(){
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if (browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }
        String url ="http://192.168.111.189:4445/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(url),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }

}
