Feature: Fiyat Kontrolü

  Scenario: Kullanıcı ürünün liste fiyatı ve sepetteki fiyatının aynı olduğunu doğrular

    Given Kullanıcı TO sitesine gier
    Then Siteye gittiğini doğrular
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    And  Arama sonucunda urun bulunabildiğini test eder
    Then Bulunan ürünleri fiyata göre yüksekten düşüğe göre sıralar
    And  Ürünlerin sıralandığını test eder
    Then İlk ürünün fiyatını kaydeder
    Then İlk ürüne tıklar
    Then Açılan sayfadaki fiyat ve liste fiyatının aynı olduğunu doğrular
    And Sayfayı kapatır