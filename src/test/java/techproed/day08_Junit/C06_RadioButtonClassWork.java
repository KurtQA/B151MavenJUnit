package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtonClassWork {
    /*
       https://www.facebook.com adresine gidin
       Cookies’i kabul edin
       “Create an Account” button’una basin
       “radio buttons” elementlerini locate edin
       Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void radioButton() {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com"); //sayfaya girmemizi engelleyen ornegin acceotence yapilmasi gerekli bir sey varsa onun da locate'i alinir ve click
        //yapilir. Ya da bekledigimiz bir giris bolumu cikmaksa herhangi bir alana tiklayip incele yapip locate aliriz

        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //“radio buttons” elementlerini locate edin
           WebElement female = driver.findElement(By.xpath("(//*[@type='radio'])[1]")); //once id ile locate almaya calistik By.id("")
        //locate'i aldik ancak click yapmadi. Bu defa ixpath ile locate aldik
           WebElement male = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
           WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!male.isSelected()){
            male.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
    //manual olarak inceledigimiz bir formda butonlara kac kez tab'a basarsak gidiliyorsa otomasyonda da ayni sekilde o kadar kez tab'a basma
    //islemi yapariz. Formda diiyelim ki email'i gir ve yeni emaili bir daha gir seklinde iki kutucuk varsa once girdigimiz email'i locate'i bir
    //string'e assign eder ikinci yerde bir daha onu kullaniriz.
}