package POBusiness;

import PO.login;
import org.openqa.selenium.WebDriver;

public class LoginBusiness {
    public static void loginPO(WebDriver driver,String email,String pwd){
        driver.switchTo().frame("m-container");
        driver.findElement(login.emailInput).sendKeys(email);
        driver.findElement(login.pwdInput).sendKeys(pwd);
        driver.findElement(login.loginbotton).click();
    }
}
