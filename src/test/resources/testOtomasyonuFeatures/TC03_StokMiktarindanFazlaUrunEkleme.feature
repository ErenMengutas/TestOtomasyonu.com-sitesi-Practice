Feature: Sepete stok miktarından fazla ürün ekleme

  Scenario: Kullanıcı ürünü stok miktarından fazla sepete ekleyemediğini doğrular

    Given Kullanıcı TO sitesine gier
    When Siteye gittiğini doğrular
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    And  Arama sonucunda urun bulunabildiğini test eder
    Then Bulunan ürünleri fiyata göre yüksekten düşüğe göre sıralar
    And  Ürünlerin sıralandığını test eder
    Then İlk ürüne tıklar
    When Stok miktarı butonuna "3000" yazar ve enter tuşuna basar
    When Ürünü sepete ekleyemediğini test eder
    And Sayfayı kapatır