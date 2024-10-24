package stepdefinitions;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestOtomasyonuPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestOtomasyonuStepDefinitions {

    String ilkUrunFiyatStr="";
    String ilkUrunIsimStr="";
    String urunSayfasiIlkUrunIsimStr="";
    TestOtomasyonuPages testOtomasyonuPages=new TestOtomasyonuPages();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Actions actions=new Actions(Driver.getDriver());


    Faker faker=new Faker();
    String fakeEmail=faker.internet().emailAddress();
    String fakePass=faker.internet().password();

    @Given("Kullanıcı TO sitesine gier")
    public void kullanıcı_to_sitesine_gier() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }
    @Then("Siteye gittiğini doğrular")
    public void siteye_gittiğini_doğrular() {

        String expectedUrl=ConfigReader.getProperty("expectedUrl");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Then("Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar")
    public void arama_kutusuna_istenilen_kelimeyi_yazar_ve_enter_tuşuna_basar() {
        testOtomasyonuPages.aramaKutusu.sendKeys(ConfigReader.getProperty("istenilenKelime")+ Keys.ENTER);

    }
    @Then("Arama sonucunda urun bulunabildiğini test eder")
    public void arama_sonucunda_urun_bulunabildiğini_test_eder() {
        Assert.assertTrue(testOtomasyonuPages.aramaSonucundaBulunanUrunlerList.size()>0);

    }
    @Then("Bulunan ürünleri fiyata göre yüksekten düşüğe göre sıralar")
    public void bulunan_ürünleri_fiyata_göre_yüksekten_düşüğe_göre_sıralar() {
        Select selectFiyat=new Select(testOtomasyonuPages.fiyatSiralamaButonuDropDown);
        selectFiyat.selectByVisibleText("High to Low");
    }
    @Then("Ürünlerin sıralandığını test eder")
    public void ürünlerin_sıralandığını_test_eder() {
        List<String> bulunanUrunlerStrList=new ArrayList<>();
        for (WebElement each:testOtomasyonuPages.fiyatListesi)
        {
            bulunanUrunlerStrList.add(each.getText());
        }
        Collections.sort(bulunanUrunlerStrList);

        Assert.assertEquals(bulunanUrunlerStrList.get(bulunanUrunlerStrList.size()-1)
                ,testOtomasyonuPages.aramaSonucuBulunanIlkElemanfiyati.getText());
    }
    @Then("Sayfayı kapatır")
    public void sayfayı_kapatır() {
        Driver.quitDriver();
    }

    @Then("İlk ürünün fiyatını kaydeder")
    public void ilkÜrününFiyatınıKaydeder() {
        ilkUrunFiyatStr=testOtomasyonuPages.aramaSonucuBulunanIlkElemanfiyati.getText();
    }

    @Then("İlk ürüne tıklar")
    public void ilkÜrüneTıklar() {
        testOtomasyonuPages.aramaSonucuBulunanIlkEleman.click();
    }

    @Then("Açılan sayfadaki fiyat ve liste fiyatının aynı olduğunu doğrular")
    public void açılanSayfadakiFiyatVeListeFiyatınınAynıOlduğunuDoğrular() {
        Assert.assertEquals(ilkUrunFiyatStr,testOtomasyonuPages.urunSayfasiFiyatElementi.getText());
    }

    @When("Stok miktarı butonuna {string} yazar ve enter tuşuna basar")
    public void stokMiktarıButonunaYazarVeEnterTuşunaBasar(String maxMiktar) {
        testOtomasyonuPages.urunMiktarKutucugu.clear();
        testOtomasyonuPages.urunMiktarKutucugu.sendKeys(maxMiktar+Keys.ENTER);
    }

    @When("Ürünü sepete ekleyemediğini test eder")
    public void ürünSepeteEkleyemediğiniTestEder() {
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuPages.urunMiktarErrorYazisi));
        Assert.assertTrue(testOtomasyonuPages.urunMiktarErrorYazisi.isDisplayed());
    }

    @Then("İlk ürünün ismini kaydeder")
    public void ilkÜrününIsminiKaydeder() {
        ilkUrunIsimStr=testOtomasyonuPages.aramaSonucuBulunanIlkElemanIsmi.getText();
    }

    @Then("İlk ürünün üzerine gelir Quick View sekmesine tıklar")
    public void ilkÜrününÜzerineGelirQuickViewSekmesineTıklar() {
        actions.moveToElement(testOtomasyonuPages.aramaSonucuBulunanIlkEleman).perform();
        testOtomasyonuPages.quickWievElementi.click();
    }

    @Then("Açılan sayfada ki ürün adıyla listedeki ürün adının aynı olduğunu test eder")
    public void açılanSayfadaKiÜrünAdıylaListedekiÜrünAdınınAynıOlduğunuTestEder() {
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuPages.quickWievAcilirPencereYaziElementi));
        Assert.assertEquals(ilkUrunIsimStr,testOtomasyonuPages.quickWievAcilirPencereYaziElementi.getText());
    }

    @Then("Account Linkine tiklar")
    public void accountLinkineTiklar() {
        testOtomasyonuPages.accountLinki.click();
    }


    @When("Sign up sekmesine tıklar")
    public void signUpSekmesineTıklar() {
        testOtomasyonuPages.signUpButonu.click();
    }

    @When("Formu doldurup kayıt olur")
    public void formuDoldurupKayıtOlur() {
        testOtomasyonuPages.kayitSayfasiNameButonu.click();


        testOtomasyonuPages.kayitSayfasiNameButonu.sendKeys(faker.name().firstName()+
                Keys.TAB+faker.name().lastName()+
                Keys.TAB+fakeEmail+
                Keys.TAB+fakePass+
                Keys.TAB+fakePass
        );

        testOtomasyonuPages.signInButonu.click();


    }

    @When("Basarili bir şekilde kayit oluşturulduğunu test eder")
    public void basariliBirŞekildeKayitOluşturulduğunuTestEder() {
        testOtomasyonuPages.accountLinki.click();
        Assert.assertEquals(fakeEmail,testOtomasyonuPages.accountSekmesiEmailYazisi.getText());

    }

    @When("Açılan sayfada Whislist butonuna tıklar")
    public void açılanSayfadaWhislistButonunaTıklar() {
        testOtomasyonuPages.urunSayfasiWishListSekmesi.click();
    }

    @When("Ürünün istek lisesine eklendiğini test eder")
    public void ürününIstekLisesineEklendiğiniTestEder() {
        testOtomasyonuPages.anaSayfaWishlistSekmesi.click();
        Assert.assertTrue(testOtomasyonuPages.wishListeEklenenUrunler.get(0).isDisplayed());


    }

    @Then("Urun sayfasindaki ismi kaydeder")
    public void urunSayfasindakiIsmiKaydeder() {
        urunSayfasiIlkUrunIsimStr=testOtomasyonuPages.urunSayfasiIsimYaziElementi.getText();


    }

    @When("İstek listesi sayfasındaki Buy Now Sekmesine tıklar")
    public void istekListesiSayfasındakiBuyNowSekmesineTıklar() {
        testOtomasyonuPages.wishListBuyNowButonu.click();
    }

    @When("Ürün sayfasına yönlendirildiğini test eder")
    public void ürünSayfasınaYönlendirildiğiniTestEder() {
        Assert.assertEquals(urunSayfasiIlkUrunIsimStr,testOtomasyonuPages.urunSayfasiIsimYaziElementi.getText());

    }

    @When("Ürünü istek lisesinden kaldırmak için Whislist sekmesine tekrar tıklar")
    public void ürünüIstekLisesindenKaldırmakIçinWhislistSekmesineTekrarTıklar() {
        testOtomasyonuPages.urunSayfasiWishListSekmesi.click();
    }

    @When("Ürünün istek lisesinden kaldırıldığını test eder")
    public void ürününIstekLisesindenKaldırıldığınıTestEder() {

        testOtomasyonuPages.anaSayfaWishlistSekmesi.click();
        Assert.assertTrue(testOtomasyonuPages.wishListBosYaziElementi.isDisplayed());

    }

    @When("Ürün sayfasına yönlendirildiğini test eder ve tekrar Buy Now sekmesine tıklar")
    public void ürünSayfasınaYönlendirildiğiniTestEderVeTekrarBuyNowSekmesineTıklar() {

        Assert.assertEquals(ilkUrunIsimStr,testOtomasyonuPages.urunSayfasiIsimYaziElementi.getText());

        testOtomasyonuPages.urunSayfasindakiBuyNowButonu.click();

    }

    @Then("Sepete yönlendirildiğini test eder")
    public void sepeteYönlendirildiğiniTestEder()
    {

        String expectedSepetUrl="https://www.testotomasyonu.com/shoppingCart";
        ReusableMethods.bekle(1);
        String actualSepetUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedSepetUrl,actualSepetUrl);
    }

    @Then("Geçerli kullanıcı adı ve şifre ile sisteme giriş yapar")
    public void geçerliKullanıcıAdıVeŞifreIleSistemeGirişYapar() {
        testOtomasyonuPages.loginSayfasiEmailButonu.sendKeys(ConfigReader.getProperty("gecerliKullanici"));
        testOtomasyonuPages.loginSayfasiPasswordButonu.sendKeys(ConfigReader.getProperty("gecerliSifre"));
        testOtomasyonuPages.loginSayfasiSignInButonu.click();
    }

    @Then("Açılan sayfada Buy Now butonuna tıklar")
    public void açılanSayfadaBuyNowButonunaTıklar() {
        testOtomasyonuPages.urunSayfasindakiBuyNowButonu.click();
    }

    @Then("Ürünün Sepete eklendiğini test eder")
    public void ürününSepeteEklendiğiniTestEder() {
        Assert.assertTrue(testOtomasyonuPages.sepettekiUrunElementi.isDisplayed());
    }

    @Then("Açılan sayfada Check Out butonuna tiklar")
    public void açılanSayfadaCheckOutButonunaTiklar() {
        testOtomasyonuPages.checkoutButonu.click();

    }

    @Then("Açılan sayfada Address bilgilerini doldurarak Place Order Now Butonuna tıklar")
    public void açılanSayfadaAddressBilgileriniDoldurarakPlaceOrderNowButonunaTıklar() {

        testOtomasyonuPages.sepetSayfasiAddAdressButonu.click();
        testOtomasyonuPages.adresFormuNameBolumu.sendKeys("Fatura Ismi");
        testOtomasyonuPages.adresFormuAdressBolumu.sendKeys("Istanbul");
        testOtomasyonuPages.adresFormuAdressBolumuOptinal.sendKeys("Istanbul");
        testOtomasyonuPages.adresFormuSehirBolumu.sendKeys("Istanbul");
        Select selectCountry=new Select(testOtomasyonuPages.selectCountryDdm);
        selectCountry.selectByVisibleText("Turkey");

        Select selectState=new Select(testOtomasyonuPages.selectStateDdm);
        selectState.selectByVisibleText("Istanbul Province");
        testOtomasyonuPages.addAddressCityButonu.sendKeys("Istanbul");
        testOtomasyonuPages.adresFormPostaKoduBolumu.sendKeys("34000");
        ReusableMethods.bekle(1);//Hızlı bir şekilde form doldurulduğunda adres bilgileri hatası yanlıs hatası
                                         //alınmakta o yüzden 1 saniye bekledildi
        testOtomasyonuPages.addAddressAddAdress.click();

        ReusableMethods.bekle(1);
        testOtomasyonuPages.bilingAdresCheckbox.click();
        testOtomasyonuPages.deliveryAddressCheckbox.click();
        testOtomasyonuPages.shippingMethodsCheckbox.click();
        testOtomasyonuPages.cashButonu.click();
        testOtomasyonuPages.termAndConditionCheckBox.click();
        testOtomasyonuPages.placeOrderNowButonu.click();

    }

    @When("Sipariş verildiğini doğrular")
    public void siparişVerildiğiniDoğrular() {
        Assert.assertTrue(testOtomasyonuPages.orderYazisi.isDisplayed());
    }

    @Then("Order SUMMARY bölümünde bulunan indirim kuponu bölümüne kupon kodu girer")
    public void orderSUMMARYBölümündeBulunanIndirimKuponuBölümüneKuponKoduGirer() {
        int randomNumber=faker.number().numberBetween(100,250);
        String randomNumStr= String.valueOf(randomNumber);
        testOtomasyonuPages.indirumKuponuSekmesi.sendKeys(randomNumStr);
        testOtomasyonuPages.indirimKoduApplyButonu.click();
        
    }

    @When("Fiyatta bir değişiklik olmadığını doğrular")
    public void fiyattaBirDeğişiklikOlmadığınıDoğrular() {
        String expectedTutar=testOtomasyonuPages.indirimBolumuTextYazisi.getText().replace("$","");
        String actualTutar="0.00";
        Assert.assertEquals(expectedTutar,actualTutar);

    }

    @When("My Orders seçeneğine tıklar")
    public void myOrdersSeçeneğineTıklar() {
        testOtomasyonuPages.myOrdersButonu.click();
    }

    @When("Sipariş geçmişinin görüntülendiğini test eder")
    public void siparişGeçmişininGörüntülendiğiniTestEder() {
        Assert.assertTrue(testOtomasyonuPages.myOrderYaziElementi.isDisplayed());
    }

    @When("En son verilen siparişin faturasını indirir")
    public void enSonVerilenSiparişinFaturasınıIndirir() {

        testOtomasyonuPages.downloadPdfButonu.click();
    }

    @When("Faturanın indirildiğini test eder")
    public void faturanınIndirildiğiniTestEder() {
        ReusableMethods.bekle(2);//Dosya indirme süresi
        String faturaNoStr=testOtomasyonuPages.invoiceNo.getText().replace("#","");
        int faturaNo= Integer.parseInt(faturaNoStr);
        //invoiceNo sepetteki fatura numarasıdır.her faturada,fatura No değiştiği için fatura ismine aşağıdaki gibi eklenmiştir

        String dosyaYolu=System.getProperty("user.home")+"/"+"Downloads//invoice-INV"+(faturaNo-1)+".pdf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @When("Olusturulmus olan kullanici adi ve sifre ile giriş yapar")
    public void olusturulmusOlanKullaniciAdiVeSifreIleGirişYapar() {
        testOtomasyonuPages.loginSayfasiEmailButonu.sendKeys(fakeEmail);
        testOtomasyonuPages.loginSayfasiPasswordButonu.sendKeys(fakePass);
        testOtomasyonuPages.loginSayfasiSignInButonu.click();

    }
}
