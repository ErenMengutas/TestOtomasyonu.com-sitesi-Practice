Feature: İsme göre sıralama

  Scenario: Kullanıcı TO sitesinde istenilen ürünleri aratır ve aratılan ürünleri isme göre sıralar

    Given Kullanıcı TO sitesine gier
    Then Siteye gittiğini doğrular
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    And  Arama sonucunda urun bulunabildiğini test eder
    Then Bulunan ürünleri fiyata göre yüksekten düşüğe göre sıralar
    And  Ürünlerin sıralandığını test eder
    And  Sayfayı kapatır