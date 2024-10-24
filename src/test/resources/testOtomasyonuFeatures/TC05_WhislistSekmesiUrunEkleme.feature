Feature:Istek listesine ürün ekleme

  Scenario:Kullanici whislish'e urun ekleyebildiğini test eder

    Given Kullanıcı TO sitesine gier
    When Siteye gittiğini doğrular
    Then Account Linkine tiklar
    When Sign up sekmesine tıklar
    When Formu doldurup kayıt olur
    When Basarili bir şekilde kayit oluşturulduğunu test eder
    When Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    Then Arama sonucunda urun bulunabildiğini test eder
    When İlk ürüne tıklar
    When Açılan sayfada Whislist butonuna tıklar
    When Ürünün istek lisesine eklendiğini test eder
    And Sayfayı kapatır