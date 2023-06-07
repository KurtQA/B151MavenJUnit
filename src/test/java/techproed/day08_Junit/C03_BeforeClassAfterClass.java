package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    WebDriver driver;  //driver objemizi her yerde calsitirmak icin bu seviyede bu sekilde tanimladik. @Before icinde
    //Webdriver'i onceden tanimladigimiz icin driver = new ChromeDriver(); olarak olusturduk.

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi Baslatıldı");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi Sonuclandı");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // driver.get("https://amazon.com");  Baslangicta her iki Test methodumuzda amazon sayfasina gitmeye calistik. Daha sonra driver.get
        //kismini @Before icine aldik. Hangi testi calistirirsak bastan amazon'a gidilmis olacak.
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung" + Keys.ENTER);
    }

    //Test methodu calistirilinca console'da once Amazon Testi Baslatildi yazisini, en sonda Amazon Testi Sonuclandi yazisini gorduk.

    @Test
    public void test02() {
        // driver.get("https://amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);
    }
    //Biz genelde @BeforeClass ve @AfterClass'i kullanmayiz. Daha cok @Before @Test ve @After'i kullaniriz
}