Feature: Fature indirme testi

  Scenario: Kullanici sipariş verdiği ürünün faturasini indirebildiğini test eder

  Given Kullanıcı TO sitesine gier
  Then Account Linkine tiklar
  When Sign up sekmesine tıklar
  When Formu doldurup kayıt olur
  When Basarili bir şekilde kayit oluşturulduğunu test eder
  When Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
  When Arama sonucunda urun bulunabildiğini test eder
  Then İlk ürüne tıklar
  Then Açılan sayfada Buy Now butonuna tıklar
  Then Ürünün Sepete eklendiğini test eder
  Then Açılan sayfada Check Out butonuna tiklar
  Then Açılan sayfada Address bilgilerini doldurarak Place Order Now Butonuna tıklar
  When Sipariş verildiğini doğrular
  Then Account Linkine tiklar
  When My Orders seçeneğine tıklar
  When Sipariş geçmişinin görüntülendiğini test eder
  When En son verilen siparişin faturasını indirir
  When Faturanın indirildiğini test eder
  And Sayfayı kapatır
