package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPages {
    public TestOtomasyonuPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='product-box my-2  py-1']")
    public List<WebElement> aramaSonucundaBulunanUrunlerList;

    @FindBy(xpath = "//select[@class='px-2 orderby']")
    public WebElement fiyatSiralamaButonuDropDown;

    @FindBy(xpath = "//div[@class='price']")
    public List<WebElement> fiyatListesi;

    @FindBy(xpath = "(//div[@class='price'])[1]")
    public WebElement aramaSonucuBulunanIlkElemanfiyati;

    @FindBy(xpath = "(//a[@class='prod-title mb-3 '])[1]")
    public WebElement aramaSonucuBulunanIlkEleman;

    @FindBy(id = "priceproduct")
    public WebElement urunSayfasiFiyatElementi;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement urunMiktarKutucugu;

    @FindBy(xpath = "//div[@class='retro-notify-header']")
    public WebElement urunMiktarErrorYazisi;

    @FindBy(xpath = "(//a[@class='prod-title mb-3 '])[1]")
    public WebElement aramaSonucuBulunanIlkElemanIsmi;

    @FindBy(xpath = "(//a[@class='quickviewtext'])[1]")
    public WebElement quickWievElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4 modal-product-title']")
    public WebElement quickWievAcilirPencereYaziElementi;

    @FindBy(xpath = "(//div[@class='cart-bar'])[1]")
    public WebElement accountLinki;

    @FindBy(xpath = "//a[@class='sign-up ']")
    public WebElement signUpButonu;

    @FindBy(id = "firstName")
    public WebElement kayitSayfasiNameButonu;

    @FindBy (xpath = "//button[@id='btn-submit-form']")
    public WebElement signInButonu;

    @FindBy(xpath = "(//p)[1]")
    public WebElement accountSekmesiEmailYazisi;

    @FindBy(xpath = "//button[@onclick=\"addToWish(this,'34',1)\"]")
    public WebElement urunSayfasiWishListSekmesi;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[2]")
    public WebElement anaSayfaWishlistSekmesi;

    @FindBy(xpath = "//div[@class='flex-column mx-3 ']")
    public List<WebElement> wishListeEklenenUrunler;

    @FindBy(xpath = " //div[@class=' heading-sm mb-4']")
    public WebElement urunSayfasiIsimYaziElementi;

    @FindBy(xpath = "//a[@class='button-purple btn-sm ']")
    public WebElement wishListBuyNowButonu;

    @FindBy(xpath = "//h4[@class='p-5 text-center text-black']")
    public WebElement wishListBosYaziElementi;

    @FindBy(xpath = "//button[@class='add-to-cart buy-now']")
    public WebElement urunSayfasindakiBuyNowButonu;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement loginSayfasiEmailButonu;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement loginSayfasiPasswordButonu;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement loginSayfasiSignInButonu;

    @FindBy(xpath = "//a[@class='product-title text-center']")
    public WebElement sepettekiUrunElementi;

    @FindBy(xpath = "//a[@class='button-block button-place']")
    public WebElement checkoutButonu;

    @FindBy(xpath = "(//*[@class='btn-add-address'])[1]")
    public WebElement sepetSayfasiAddAdressButonu;

    @FindBy(xpath = "//select[@id='country_id']")
    public WebElement selectCountryDdm;

    @FindBy(xpath = "//select[@id='add_address_state']")
    public WebElement selectStateDdm;

    @FindBy(xpath = "//input[@placeholder='Enter city']")
    public WebElement addAddressCityButonu;

    @FindBy(xpath = "//input[@placeholder='Enter postcode']")
    public WebElement addAddressPostCode;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    public WebElement addAddressAddAdress;

    @FindBy(xpath = "//h2[@class='notfoundtxt mt-3 mb-3 text-black']")
    public WebElement orderYazisi;


    @FindBy(xpath = "(//span[@class='checkmark'])[1]")
    public WebElement bilingAdresCheckbox;

    @FindBy(xpath = "(//span[@class='checkmark'])[2]")
    public WebElement deliveryAddressCheckbox;

    @FindBy(xpath = "(//span[@class='checkmark'])[3]")
    public WebElement shippingMethodsCheckbox;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement termAndConditionCheckBox;

    @FindBy(xpath = "//div[@class='col-md-4 p-3 col-sm-12 col-xl-4 col-lg-3 cod-box payment-box']")
    public WebElement cashButonu;

    @FindBy(xpath = "//button[@class='button-block button-place mt-3']")
    public WebElement placeOrderNowButonu;

    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement indirumKuponuSekmesi;

    @FindBy(xpath = "//input[@id='coupon_submit']")
    public WebElement indirimKoduApplyButonu;

    @FindBy(xpath = "//div[@class='summary-price discountAmt']")
    public WebElement indirimBolumuTextYazisi;

    @FindBy(xpath = " (//span[@class='item'])[2]")
    public WebElement myOrdersButonu;

    @FindBy(xpath = "//h3[@class='m-3  text-left heading-xs']")
    public WebElement myOrderYaziElementi;

    @FindBy(xpath = "//a[@class='button-block btn-block-rate btn-sm ']")
    public WebElement downloadPdfButonu;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement adresFormuNameBolumu;

    @FindBy(xpath = "(//textarea[@class='form-control mt-3 mb-3'])[1]")
    public WebElement adresFormuAdressBolumu;
    @FindBy(xpath = "(//textarea[@class='form-control mt-3 mb-3'])[2]")
    public WebElement adresFormuAdressBolumuOptinal;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement adresFormuSehirBolumu;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement adresFormPostaKoduBolumu;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement invoiceNo;













}
