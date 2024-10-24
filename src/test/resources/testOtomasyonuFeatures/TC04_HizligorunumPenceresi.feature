Feature:Hızlı görünüm penceresi

  Scenario:Kullanıcı Listedeki urun adıyla hızlı görünüm sekmesinde ki urun adının aynı oldugunu doğrular

    Given Kullanıcı TO sitesine gier
    When Siteye gittiğini doğrular
    Then Arama kutusuna istenilen Kelimeyi yazar ve enter tuşuna basar
    And  Arama sonucunda urun bulunabildiğini test eder
    Then Bulunan ürünleri fiyata göre yüksekten düşüğe göre sıralar
    And  Ürünlerin sıralandığını test eder
    Then İlk ürünün ismini kaydeder
    Then İlk ürünün üzerine gelir Quick View sekmesine tıklar
    Then Açılan sayfada ki ürün adıyla listedeki ürün adının aynı olduğunu test eder
    And Sayfayı kapatır