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

public class C04_CheckBoxClassWork {

        // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
        // Checkbox1 ve checkbox2 elementlerini locate edin.
        // Checkbox1 seçili değilse secin
        // Checkbox2 seçili değilse secin


    WebDriver driver;
//Artik main method calsitirmiyoruz ve Chrome ayarlarimizi @Before annotation'li method icinde olustururuz. Bu nedenle
    //once generate'den SetUp'i secip @Before methodunu olusturduk.
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void checkBox() throws InterruptedException {

        // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(2000);


        // Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));//Burada
        //once [1] 1. indexi secmistik, ancak HTML kodu alt cubukta bu sekilde alinca web sayfasinda ustteki
        //checkbox2 degil checkbox1 butonunun secili oldugunu gorduk. Bu nedenle 2. indexi aldik

        Thread.sleep(2000);


        // Checkbox1 seçili değilse secin
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        Thread.sleep(2000);


        // Checkbox2 seçili değilse secin
        if(!checkBox2.isSelected()){ //Biz bu kisimda degil anlamina gelen ! isaretini koymasaydik ve run edince websayfasinda checkbox1'e click
            //yapilarak secili oldugunu ancak checkbox'da click yapilmadigini goruruduk. Cunku secili degildi ve biz secili ise tikla demis oldugumuzdan
            //orada bir degisiklik olmayacakti
            checkBox2.click();
        }

        Thread.sleep(2000);



    }

        /*
            @Test @Ignore  Bu testin calismasini istemezsek @Test yanina @Ignore yazariz. Class seviyesinde run edince
            //bu test calismadi. Diger test calisti.
            public void ignor() {

                driver.get("https://amazon.com");

            }

      Console'un ust tarafinda Tests passed:1, ignored 1 of 2 tests yazildi. Console icinde ise Test ignored yazildi
         */

}