Feature: Geçersiz indirim kuponu testi

  Scenario: Kullanıcı gerçeriz kupon kodu girdiğinde üründe indirim olmadığını doğrular

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
    Then Order SUMMARY bölümünde bulunan indirim kuponu bölümüne kupon kodu girer
    When Fiyatta bir değişiklik olmadığını doğrular
    And  Sayfayı kapatır