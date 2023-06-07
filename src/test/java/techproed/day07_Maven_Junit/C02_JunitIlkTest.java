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

Test method’u ve Test farkli yapilardir.
Test dedigimizde tek bir method veya icinde bircok class ve package barindiran
bir yapi olabilir. Regression test, smoke test vb..
Test method’u ise @Test notasyonu kullanilarak olusturulan ve bagimsiz olarak
calistirabilecegimiz en kucuk test yapisidir
BeforeClass notasyonu, bir class’daki tüm testlerden once yapılması gereken bir islem
işlem varsa kullanılır (precondition).
Örneğin test metotlarımız çalışmadan driver olusturup tum methodlarda kullanabilirim.
❖ AfterClass notasyonu da, bir class’daki tüm testler tamamlandıktan sonra yapılması
gereken işlemlerde kullanılır.
Örneğin actigimiz sayfayi kapatmak veya elde ettigimiz test sonuclarini raporlamak gibi.
❖ @BeforeClass ve @AfterClass notasyonları test sürecinde bir kere çalışırken, @Before
ve
@After notasyonları her test method’unun başında ve sonunda çalışmaktadır.

 */

public class C02_JunitIlkTest {


    @Test
    public void test01() {  //manual olarak yazabiliriz ya da sag click yapin, Generate'den Test Method'u seceriz
        //bu hazir bir test methodu olusturur.

        //her test methodumuz icine Chrome ayarlarimizi yaziyoruz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com");

        driver.close();

    }
    //Biz her testimizi ayri ayri calistirabiliriz. Test02'yi calistirmak istersek, o methodun yanindaki run butonuna
    //basariz. Yani test seviyesinde calistiririz. Boylece test01 calismaz, test02 calisir. Test01'i claistirmak istersek
    //yanindaki run butonuna tiklayinca run test01'i seceriz.
    //Tum testleri calistirmak istersek class seviyesinde run yapariz. Bu durumda once yukaridakinden baslayarak
    //calistirma yapar. Biz alttaki method ismini test01, usttekini test02 yapsaydik o zaman once altta olmasina ragmen
    //test01'i calistirir. Cunku rakam olarak daha onde
    @Test
    public void test02() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        driver.close();

    }
}