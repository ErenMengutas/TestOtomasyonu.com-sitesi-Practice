Feature:WhisList urun kaldırma

  Scenario: Kullanıcı WhisList sekmesinden ürün kaldırabildiğini test eder

    Given Kullanıcı TO sitesine gier
    When Siteye gittiğini doğrular
    Then Account Linkine tiklar
    When Sign up sekmesine tıklar
    When Formu doldurup kayıt olur
    When Basarili bir şekilde kayit oluşturulduğunu test eder
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    Then İlk ürüne tıklar
    Then Urun sayfasindaki ismi kaydeder
    Then Açılan sayfada Whislist butonuna tıklar
    When Ürünün istek lisesine eklendiğini test eder
    When İstek listesi sayfasındaki Buy Now Sekmesine tıklar
    When Ürün sayfasına yönlendirildiğini test eder
    When Ürünü istek lisesinden kaldırmak için Whislist sekmesine tekrar tıklar
    When Ürünün istek lisesinden kaldırıldığını test eder
    And Sayfayı kapatır
