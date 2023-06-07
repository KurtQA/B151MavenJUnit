package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C04_BeforeAfter {
   //Erol Hoca'nin 05-06-2023 tarihli C03_BeforeAfter Class'indan



        WebDriver driver; //Once class level'inda objemizi olusturduk.
        @Before
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }    //Bu kisimda ise son olarak @After calisacak

        @Test
        public void test1() {  //Bu kismda once @Before calisacak. @Before methodu icinde yaptigimiz ayarlarla baslayacak
            driver.get("https://amazon.com"); //Bu kisimda Test methodumuz calisacak
        }
        @Test
        public void test2() {
            driver.get("https://techproeducation.com");
        }
        //Test methodularimizin isimleri a ve b iken once a olan, methodlarimiz test1 test2 iken once test1 calisti.

        @After
        public void tearDown() throws Exception {
            driver.close();
        }

        @BeforeClass
        public static void beforeClass() throws Exception {
            System.out.println("Her classtan önce bir kez çalışır");
        }

        @AfterClass
        public static void afterClass() throws Exception {
            System.out.println("Her classtan sonra bir kez çalışır");
        } //@AfterClass ile raporlama yapacagiz, ancak onu sonra gorecegiz.
    }
