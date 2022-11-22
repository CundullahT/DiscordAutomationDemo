package com.discord.automation;

import com.discord.automation.utilities.BrowserUtils;
import com.discord.automation.utilities.Driver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {

    WebDriver driver;

    String continueInBrowserMessageXPath;
    String username;
    String password;

    @BeforeMethod
    public void setUp() {

        driver = Driver.get();

        driver.get("https://discord.com/channels/@me");

        continueInBrowserMessageXPath = "/html//div[@id='app-mount']//div[@class='notDevTools-1zkgfK']//section[@class='authBox-1HR6Ha theme-dark']/div[@class='centeringWrapper-dGnJPQ']/button[2]/div[@class='contents-3ca1mk']";
        WebElement continueInBrowserButton = driver.findElement(By.xpath(continueInBrowserMessageXPath));
        BrowserUtils.waitForStaleElement(continueInBrowserButton);
        continueInBrowserButton.click();

        username = "cemilmeric23@gmail.com";
        password = "gjx9PDJ_vch-gwc0zkg";

    }

    @Test
    public void callMe() throws InterruptedException {

        String usernameInputCSSPath = "[name='email']";
        String passwordInputCSSPath = "[name='password']";
        String loginButtonXPath = "/html//div[@id='app-mount']/div[@class='appDevToolsWrapper-1QxdQf']/div[@class='notDevTools-1zkgfK']/div[@class='app-3xd6d0']//form/div[@class='centeringWrapper-dGnJPQ']/div//button[@type='submit']";

        WebElement usernameInput = driver.findElement(By.cssSelector(usernameInputCSSPath));
        WebElement passwordInput = driver.findElement(By.cssSelector(passwordInputCSSPath));
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));

        BrowserUtils.waitForStaleElement(usernameInput);
        BrowserUtils.waitForStaleElement(passwordInput);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        BrowserUtils.waitForClickability(loginButton, 2000);
        loginButton.click();

        try {
            String closeNitroNotificationCSSPath = "[class='closeButton-hi9Bxx close-1mLglB button-f2h6uQ lookBlank-21BCro colorBrand-I6CyqQ grow-2sR_-F'] [fill]";
            WebElement closeNitroNotification = driver.findElement(By.cssSelector(closeNitroNotificationCSSPath));
            closeNitroNotification.click();
        } catch (NoSuchElementException nsee) {
            System.out.println(nsee.getMessage());
        }

        BrowserUtils.waitFor(3);

        String ctCSSPath = "[href='\\/channels\\/\\@me\\/1002252811347710114']";

        WebElement ctDM = driver.findElement(By.cssSelector(ctCSSPath));
        BrowserUtils.waitForStaleElement(ctDM);
        ctDM.click();

        String callButtonCSSPath = "[class='toolbar-3_r2xA'] > [role='button']:nth-of-type(1) [fill]";

        WebElement callButton = driver.findElement(By.cssSelector(callButtonCSSPath));
        BrowserUtils.waitForStaleElement(callButton);
        callButton.click();

    }

}
