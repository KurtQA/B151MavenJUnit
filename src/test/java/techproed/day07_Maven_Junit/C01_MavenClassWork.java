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
        //By.cssSelector("input#user_login")); bu da css ile locate alinmis hali. id attribute'nun value'su user_login
        login.sendKeys("username");
        //Biz uc adimi su sekilde de yapabiliriz: login.sendKeys("username", Keys.TAB, "password", Keys.ENTER);
        //TAB, bir asagi butona password'a inmeye neden olacak. Bir locate ile 3 step atmis olduk.

        //Bir web sayfasinda manual olarak ne yapabiliyorsak otomasyonla da aynisini yapabiliriz. Enter yaptiktan
        //sonra sayfaya giris yapamayinca navigate back ile user olarak giris yapabildik.

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
        //soyle de olabilir: //*[text()=.][11] value kismina nokta koyunca tum text'ler anlamina geliyor. Biz hangi text'i
        //alacagimiza karar verince o siradaki text'i ornegin 11. texti aldigimizi [11] yanina ekleyerek soylemis oluruz.
        //Biz value kismini ne sekilde yaziyorsa alsaydik ve developer orada kucuk de olsa degisiklik yapsaydi artik bu locate
        //kullanilmaz olurdu. Ama text'in numarasini yazdigimiz icin isterse developer text'de bir harf ya da kelime degisikligi
        //yapsa dahi problem olmaz.

        //hatirlatma:text css'de kullanilmaz. Bu nedenle xpath ile locate aliriz.

        Thread.sleep(2000);

        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        //Sadece taglarla da locate alabiliriz. //h4 alt cubukta yazinca secili halde HTML
        //kodunda goruldu. h4 uzerine HTML kodu icinde gelince, sayfada Pay Bills kisminin secili oldugunu gorduk.
        // Yukaridaki locate alma islemi daha dinamik. Biz her iki halde de locate alabiliriz. Ancak h4 ile locate sonuc
        //vermedi web sayfasinda istenen yere gitmedi. Bunun uzerine soyle yaptik: (//h4)[4]//span yapinca istenilen sekilde
        //ilgili kisma gitti. Biz (//h4) [4]//span yaparak h4'un child'i olan spana gitmis olduk. Locati boyle alabildik.
        //HTML kodlarinda parent child iliskisini gormustuk. Yukaridakiler parent, asagidakiler child idi. Yukaridaki sola daha yakin
        //baslarken asagidaki child saga yakin biraz daha kayik bir vaziyette baslar. Alt alta ayni hizada yani biri birinden daha sola
        //daha saga yakin degil tam alt hizasinda baslama durumu varsa bu durumda olanlar sibling. HTML kodumuzda h4 span'in parent'i
        //ve biz bir tag'dan digerine gecerken // isaretini kullaniriz.

        Thread.sleep(2000);


        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //Amount butonu uzerinde inspect yaptik ve locate aldik
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("100");
        //soyle de yapabiliriz: driver.findElement(By.cssSelector("#sp_amaount")). Bu kisim bize webelement amount'u veriyor.
        //driver.findElement(By.cssSelector("#sp_amaount")).sendKeys("500", Keys.TAB, "2020-09-10");
        //Bu sekilde bir sonraki adimi da tamamlamis olduk. Ancak 500, Keys.TAB, 2020-09-10 sonrasinda enter yapmadi
        //bu nedenle ikinci Keys.TAB'i ekledik. sendKeys("500", Keys.TAB, "2020-09-10" Keys.TAB, Keys.TAB,Keys.ENTER);
        //cssSelector ile alinan kisim ile amount'un locate'i alindi ve sendKeys ile o bolume 500 yazildi
        //TAB'a basinca amount altindaki date butonuna geldi ve istenilen tarihi o butona yazdi. Bir TAB daha yapinca
        //ilgili sayfada Description butonuna geldi. Oraya bir sey yazmamiz istenmediginden bir TAB daha yaptik ve
        //alt alta siralanmis amount, date, Description butonlarinin altinda sag kosede Pay butonu uzerine geldi
        //pay butonuna tiklamamiz istenmisti. Iki TAB sonrasi bir de ENTER yaptigimiz icin pay butonuna click yapildi.
        //Bunlarin tek tek locate'lerini alabilirdik, ancak bu daha partik bir yontem. Manual yapabildigimiz bu islemleri
        //dusunursek ve websayfasina bakarsak bu kisa yolun olabilecegini anlayabiliriz.
        //Bazen karsimiza checkbox butonlarina Keys.SPACE ile mudahale ederiz. Bununla checkbox'i doldurur ve Keys.TAB ile
        // bir alta geceriz


        Thread.sleep(2000);

        //Bize amount bolumune bir miktar girin dendiginden amaunt yazisinin degil yanindaki butonun locate'ini
        //almak daha dogru olur. Cunku o butona rakam girecegiz. input ile baslayan yani icine metin gonderdigimiz tagi
        //aliriz.

        // Date kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");

        Thread.sleep(2000);

        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        //tag name yerine * yazilmasi tag name farketmeksizin denmis oluyor.


        Thread.sleep(2000);


        // “The payment was successfully submitted.” mesajinin ciktigini test edin.

        // Yukaridaki kodu calistirinca web sayfasinda test edilecek mesajin yazildigini gorduk.
        // Bu mesaj i=uzerine gelip locate'ini aldik
        WebElement mesaj = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        //Soyle de yazabilirdik: (//span)[1] Burada title ya da text kullanmadik. 1 of 1 oldu alt cubuk yaninda
        //xpath ile aldigimiz locate'i mesaj isimli WebElement'e asagidaki if blogunda kullanmak icin assign ettik. Bu bir
        //webelement. Dolayisiyla bunu bir Webelement'e assign edebiliriz.

        //Webelementin gorunur olup olmadigini dogrulamak icin
        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);

        //Soyle de yapabilirdik:
        //if(mesaj.getText().equals("The payment was successfully submitted.")){
        //System.out.println("Test PASSED);
        //}else System.out.println("Test FAILED");


        // Sayfayi kapatın
        driver.close();

    }


}