package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
/*
Maven bir Java derleme aracıdır (build tool). Maven proje otomasyon ve yönetim
aracıdır
(automation and management tool).
Maven ve pom arasındaki fark nedir? (interview sorusu)
Maven bir araç (tool), pom bir xml dosyasıdır. Pom.xml maven'in bir parçasıdır ve pom
dependencies’i yönetir.
✔ Projenizde pom'ı nasıl kullanırız? Neden kullanırız?
Dependencies’i yönetmek için . Tüm projeyi yönetmemize yardımcı olur. Pom ayrıca
artifact id, group id, ve version gibi proje bilgilerine de sahiptir.


1. https://www.amazon.com/ sayfasina gidelim
2. arama kutusunu locate edelim
3. “Samsung headphones” ile arama yapalim
4. Bulunan sonuc sayisini yazdiralim
5. Ilk urunu tiklayalim
6. Sayfadaki tum basliklari yazdiralim
 */

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        //1-16 of 201 results for "Samsung headphones"
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2//a)[1]")).click(); //(//h2)[1] olarak da yazabilirdik.Bununla tiklayamazsa, alamazsa diye a eklemesi de yaptik

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2")); //Biz tek seferde hem h1 hem h2'yi bu sekilde xpath yolu ile alabildik. Basta her iki basliktan
        //toplam 22 sonucunu gorduk. Parantez icine koyunca sonuc 1 oldu. Biz birden fazla baslik varsa onlari da alabilirdik. //h1 | //h2 | //h3 | //h5  Javadaki or isareti ile |  basliklari siralariz
        //Diyelimki bize oradaki tum link basliklarini istediler. h1, h2 ile alabilecegimiz gibi su sekilde de alabiliriz. (//*[class='nav-a'])[1] | (//*[@class=nav-a'])[2]
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        //sayfayı kapatınız
        driver.close();

    }
}


