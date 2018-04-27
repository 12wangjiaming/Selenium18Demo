package com.jiamingDay01;


import POBusiness.LoginBusiness;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class POTest {
    WebDriver driver;
    @Test
    public void login(){
        driver = new FirefoxDriver();
        LoginBusiness.loginPO(driver,"38311467@qq.com","123456");
    }

}
