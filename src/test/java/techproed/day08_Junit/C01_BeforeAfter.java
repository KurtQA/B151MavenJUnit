package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*

    @BeforeClass ve @AfterClass methodlari sadece static methodlarla calisir.


     */

public class C01_BeforeAfter {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir.
     */
    //Bir web sayfasina gittik ve sayfa uzerinde neredeyse tam sayfa reklam vardi. Bu reklami kapatmamiz gerekti. Web sayfasinda iken reklami manual
    //olarak x isareti uzerine basip kapatabilcegimizi bildigimizden o x isareti uzerine geldik ve onun bir webelement oldugunu bilerek
    //uzerinde inspect yapip locate'ini xpath ile aldik ve findlement xpath devaminda .click() ekledik. Boylece manual olarak yaptigimiz
    //reklam kapatma islemini otomasyon ile yapabildik.

    //@BeforeClass icine chrome ayarlarini driver=new chromedriver().setup(); dahil olarak alinca class seviyesindeki WebDriver driver; ' a ragmen
    //driver yazilari @BeforeClass icinde kirmizi yazili oldu. Cunku @BeforeClass static oldugundan icindeki driver gorulmedi. Bunun uzerine
    //class seviyesinde tanimladigimiz WebDriver'a static keyword'unu ekledik. static WebDriver driver;
    //Daha once chrome ayarlarini bu sekilde @Before methodu icinde yazdigimizda sorun olmamisti. Cunku statik degildi ve static olmayan class
    // seviyesinde tanimlanan WebDriver'i kullanabilmistik. chrome ayarlarini @BeforeClass icine almak yanlis olur. Birden fazla testimiz varsa hata aliriz
    //@BeforeClass bir kere claisir. Birinci testte bir kere calisacak ve sorun olmayacak. Ancak ikinci testte calsimayacagindan hata alacagiz.
    //Bu nedenle chrome ayaralarini birden fazla testimiz varsa @Before icinde yazmak gerekir ve class seviyesindeki WebDriver'i static yapmaya gerek olmaz

    //driver.close() @After icine yazilir. Eger biz bunu @AfterClass icine alirsak bu en son ve bir kez calisacagindan iki testimiz varsa birinci test
    //calistiktan sonra acik kalacak ve sadece ikinci son testi kapatacak. @After ise her methoddan sonra calistigindan driver.close() onun icinde
    //olursa tum testler calsitiktan sonra kapanabilir.


    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();  //driver objesini @Before icinde olusturdugumuz icin burada yazinca driver kirmizi renkle yazildi. Bunun icin Webdriver driver objemizi class
        //seviyesinde tanimladik. @Before icinde Webdriver driver olarak yazmisken WEbdriver kismini oradan aldik ve @Before uzerinde class seviyesinde
        //Webdriver driver; yazdik

    }

    @Test
    public void test01() {
        //Buradan @Before annotationli methoda gidip onu claistiracak
        driver.get("https://techproeducation.com"); //@Test annotation'li method calisacak
        //Buradan en son @After annotation method calisacak ve ona bagli olarak web sayfasini kapatacak
    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
    }
    //Her test'de uc method calismis olur. Ne kadar testimiz varsa ve hepsini class seviyesinde calistirirsak ucer ucer calisan
    //methodlari toplariz ve son olarak bir @BeforeClass bir de @AfterClass methodlari yani calisan iki method eklenir
}