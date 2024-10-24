Feature: Siparis verme testi

  Scenario: Kullanici urunu sepete ekleyebildiğini ve sipariş verebildiğini test eder

    Given Kullanıcı TO sitesine gier
    Then Account Linkine tiklar
    When Sign up sekmesine tıklar
    When Formu doldurup kayıt olur
    When Basarili bir şekilde kayit oluşturulduğunu test eder
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    Then Arama sonucunda urun bulunabildiğini test eder
    When İlk ürüne tıklar
    Then Açılan sayfada Buy Now butonuna tıklar
    Then Ürünün Sepete eklendiğini test eder
    Then Açılan sayfada Check Out butonuna tiklar
    Then Açılan sayfada Address bilgilerini doldurarak Place Order Now Butonuna tıklar
    When Sipariş verildiğini doğrular
    And Sayfayı kapatır
