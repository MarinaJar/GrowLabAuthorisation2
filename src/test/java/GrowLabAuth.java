import jdk.internal.icu.impl.BMPSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static org.testng.Assert.assertEquals;

public class GrowLabAuth extends TestBase {



    @Test
    //manager login positiv test: correct email, correct pass
    public void mngLoginTest() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailInput = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("billye@example.com");
        Thread.sleep(2000);

        WebElement passInput = wd.findElement(By.id("sw-form-password-input"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("123456");
        Thread.sleep(2000);

        WebElement signInButton = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signInButton.click();
        Thread.sleep(2000);

        logoutMngAccount();
        returnLoginPage();

    }


    @Test
    //manager login negativ test: incorrect email, correct pass
    public void mngLoginTest1() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailInput = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("bllye@example.com");
        Thread.sleep(2000);

        WebElement passInput = wd.findElement(By.id("sw-form-password-input"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("123456");
        Thread.sleep(2000);

        WebElement signInButton = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signInButton.click();
        Thread.sleep(2000);


        wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[1]")).click();
        Thread.sleep(2000);
        String source = wd.getPageSource();
        String bugReport = "Invalid email or password";
        System.out.println(source.contains(bugReport));
        Assert.assertEquals(source.contains(bugReport),Boolean.FALSE);


    }

    @Test
    //manager login negativ test: correct email, incorrect pass
    public void mngLoginTest2() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailInput = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("billye@example.com");
        Thread.sleep(2000);

        WebElement passInput = wd.findElement(By.id("sw-form-password-input"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("12345");
        Thread.sleep(2000);

        WebElement signInButton = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signInButton.click();
        Thread.sleep(2000);


        wd.findElement (By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[1]/text()")).click();
        Thread.sleep(2000);
        String source = wd.getPageSource();
        String bugReport = "Invalid email or password";
        System.out.println(source.contains(bugReport));
        assertEquals(source.contains(bugReport), Boolean.FALSE);


    }

    @Test
    //client login positive test: correct client email, correct pass

    public void clientsLoginTest() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailInput = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("lucie@example.com");
        Thread.sleep(2000);

        WebElement passInput = wd.findElement(By.id("sw-form-password-input"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("123456");
        Thread.sleep(2000);

        WebElement signInButton = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signInButton.click();
        Thread.sleep(2000);

        logoutClientAccount();
        returnLoginPage();
    }





}