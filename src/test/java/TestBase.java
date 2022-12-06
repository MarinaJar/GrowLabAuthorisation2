import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    WebDriver wd;

    @BeforeTest
    public void before() {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();

    }

    public void logoutClientAccount() {
        WebElement LCButton = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[3]/a"));
        LCButton.click();
        WebElement clientSignOutButton = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[3]/div"));
        clientSignOutButton.click();

    }

    public void logoutMngAccount() {
        WebElement buttonBH = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/a"));
        buttonBH.click();
        WebElement mngSignOutButton = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/div"));
        mngSignOutButton.click();


    }

    public void returnLoginPage() throws InterruptedException {
        WebElement loginButton = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a"));
        loginButton.click();
        Thread.sleep(2000);

    }
    @AfterTest



    public void after() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wd.close();
    }
}
