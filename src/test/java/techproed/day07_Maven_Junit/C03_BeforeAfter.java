package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {
    //Javadaki gibi yukaridan asagiya dogru bir calisma sistemi vardir. Once yukaridaki calisir, ancak burada oncelikli olma durumlari
    //dikkate alinir. Ornegin, after once before sonra yazilmis olsun. Yukarida after'i gorur ve asagiya inmeye devam edip before var mi
    //diye bakar. Befor'u gorurse once onu calistirir.

    //JUnit framework'unda testlerimizi siralamak icin extra bir notasyon yoktur. Eger belli bir siralamada calistirmak
    //istersek method isimlerini alfabetik veya sayisal olarak belirtmemiz gerekir. Ornegin Test01 Test02 methodlarindan
    //asagida da kalsa Test01'i calistirilir.

    @Before
    public void setUp() throws Exception {  //Genarete'den setup methodu secince bu method otomatik olarak yazildi
        System.out.println("Her test methodu öncesi bir kez calısır");
    }

    @After
    public void tearDown() throws Exception { //Genarate'den TearDown Methodu sectik ve bu method otomatik olarak yazildi

        System.out.println("Her test methodu sonrası bir kez calısır");
    }
     //Biz @After methodunu @Before'un ustunde olusturabilirdik.
    @Test
    public void test01() {//test methodu olusturmak istersek Genarate'den test'i seceriz.

        System.out.println("ilk test");

    }


    @Test
    public void test02() {

        System.out.println("ikinci test");

    }

    // Methodlari yukaridan asagiya dogru once @After, sonra iki @Before methodu ve iki Test methodunu siraladigimizda
    //once Before methodlari, sonra Test methodlari ve sonra @After methodu calisir. Concole'da cikan yazilardan bu sekilde
    //calistigini anlariz.

    //Class seviyesinde calistirma yaparsak tum methodlarimiz calisir. Test seviyesinde yani test methodunun yanindaki run
    //tusuna basarak calistirmayi yaparsak sadece o test calisir.

    /* Interview sorusu:
    Diyelimki bir class'da bir tane @BeforeClass bir tane @AfterClass, bir tane @Before, bir tane @After
    uc @Test var.Bu class'da kac method calisir?

    Clasimizi calistirdik. Uc test methodumuz var. Once bakilacak @BeforeClass varsa @BeforeClass methodu bir kere calisir.
    Sonra ilk test methodumuzun ilk satiri @Before methodu ile calisacak. Daha sonra System.out.print() kismi yani test
    methodumuz calisacak ve test methodumuzun body'si icinde System.out.print() altindaki kisim @After methodu ile
    calisacak. Kalan iki test methodu birinci test methodundaki gibi uc kez calisacak yani uc method calismis olacak.
    Bu durumda uc testimizde toplamda 9 method calismis olur. Ayrica son olarak @AfterClass methodu bir kere calisir.
    9 methodumuz calismisti, bir tane @BeforeClass ve bir tane @AfterClass methodu da eklenince toplam 11 method calisir.




     */

}