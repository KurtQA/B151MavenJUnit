package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
JUnit, TestNG ve Cucumber birer framework'durlar.

Junit maven projesi uzerinde calistigindan https://
mvnrepository.com/ sitesinden dependency’leri
projemize ekleriz.
❖ Test’lerimizi yaparken main method, if-else gibi
java kod bloklarini kullanmak yerine Junit
annotationlarini ve method’larine kullanabiliriz.

Annotations

Selenium’da kodlarimizi yazarken “@” işareti ile baslayan notasyonlar kullaniriz.
❖ Java Annotationlar ile derleyiciye (Compiler) talimatlar verebiliriz.
❖ Annotation, bir veri hakkında bilgi barındıran veriyi sağlayan basit bir yapıdır. Bu
sağladığı bilgiye de “metadata” denir.

En cok kullanilan Junit annotation’lari
@Test
@BeforeClass @AfterClass
@Before , @After
@Ignore

Yazdığımız bazı test metotları henüz tamamlanmamış veya değişikliklere
uğrayabileceğinden dolayı test sırasında çalıştırılmasını istemiyorsak @Ignore
notasyonu eklememiz yeterlidir.

Before notasyonu, her test method’undan önce çalışır. Örneğin bir sayfa ile test
yapiyorsak
ve her testten once o sayfaya gitmemiz gerekiyorsa @before kullanabiliriz.
@before notasyanunun kullanildigi method’a genelde setup( ) ismi verilir.
❖ After notasyonu, her test method’undan sonra çalışmaktadır. Örneğin test sirasinda
kullandigimiz sayfanin kapatilmasi gibi.
@after notasyanunun kullanildigi metoda genelde teardown() ismi verilir



 */

public class C02_BeforeAfter {


    @Test
    public void test02() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com");

        driver.close();

    }

    @Test
    public void test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        driver.close();

    }
}