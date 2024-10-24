Feature:İstek listesindeki ürünleri sepete ekleme

  Scenario: Kullanıcı istek listesineki ürünleri sepete ekleyebildiğini test eder

    Given Kullanıcı TO sitesine gier
    Then Account Linkine tiklar
    When Sign up sekmesine tıklar
    When Formu doldurup kayıt olur
    When Basarili bir şekilde kayit oluşturulduğunu test eder
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    Then Arama sonucunda urun bulunabildiğini test eder
    Then İlk ürünün ismini kaydeder
    Then İlk ürüne tıklar
    Then Açılan sayfada Whislist butonuna tıklar
    Then Ürünün istek lisesine eklendiğini test eder
    When İstek listesi sayfasındaki Buy Now Sekmesine tıklar
    When Ürün sayfasına yönlendirildiğini test eder ve tekrar Buy Now sekmesine tıklar
    Then Sepete yönlendirildiğini test eder
    And Sayfayı kapatır
