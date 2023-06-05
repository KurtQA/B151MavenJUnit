package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        Thread.sleep(2000);
        //Once manual olarak tek tek adimlari gerceklestirdik. Bir websitesinde elimizle nasil
        //veri giryor ve butonlara tikliyorsak onu yaptik. Daha sonra kodlarimizla yani otomasyon
        //ile ilerledik.

        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        Thread.sleep(2000);

        // Login alanina  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");

        Thread.sleep(2000);

        // Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        Thread.sleep(2000);

        //hatirlatma: css'de // ve @ isaretleri kullanilmaz

        // Sign in buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();

        Thread.sleep(2000);
        //Kodu calistirinca web sayfasinda Bu site guvenli baglanti saglamiyor yazisi ile karsilastik.

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();

        Thread.sleep(2000);

        // Online Banking bölümüne tıklayin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();//Kodu calistirinca Pay
        //Bills basligini basliklar arasinda gorduk.

        //hatirlatma:text css'de kullanilmaz. Bu nedenle xpath ile locate aliriz.

        Thread.sleep(2000);

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        Thread.sleep(2000);


        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //Amount butonu uzerinde inspect yaptik ve locate aldik
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("100");

        Thread.sleep(2000);

        // Date kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        Thread.sleep(2000);

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        Thread.sleep(2000);


        // “The payment was successfully submitted.” mesajinin ciktigini test edin. Yukaridaki kodu calistirinca web sayfasinda
        //test edilecek mesajin yazildigini gorduk. Bu mesaj i=uzerine gelip locate'ini aldik
        WebElement mesaj = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        //xpath ile aldigimiz locate'i mesaj isimli WebElement'e asagidaki if blogunda kullanmak icin assign ettik. Bu bir
        //webelement. Dolayisiyla bunu bir Webelement'e assig edebiliriz.

        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);
        // Sayfayi kapatın
        driver.close();

    }


}