# NetworkChecker

`NetworkChecker` Minecraft sunucusu için bir eklentidir. Bu eklenti, sunucu oyuncularının ping verilerini düzenli aralıklarla bir Python botuna gönderir ve botun çalışıp çalışmadığını kontrol eder. Ayrıca, eklenti çeşitli yapılandırma ayarları ve özelleştirilebilir mesajlar sağlar.

## Özellikler

- **Ping Verisi Gönderme**: Oyuncu ping verilerini düzenli aralıklarla belirlenen bir IP adresine ve portuna gönderir.
- **Yeniden Yükleme Komutu**: Sunucuyu yeniden başlatmadan konfigürasyon ayarlarını yeniden yüklemek için `/networkchecker reload` komutu.
- **Mesaj Özelleştirme**: Özelleştirilebilir mesajlar için `messages.yml` dosyası desteği.

## Kurulum

1. `NetworkChecker` eklentisini [buradan](https://github.com/Reyretee/NetworkChecker/releases/tag/NEW) indirin.
2. İndirdiğiniz `.jar` dosyasını Minecraft sunucunuzun `plugins` dizinine yükleyin.
3. Sunucunuzu başlatın veya yeniden başlatın.

## Konfigürasyon

### `config.yml`

Aşağıda `config.yml` dosyasında yapılandırılabilecek ayarlar bulunmaktadır:

```yaml
bot:
  ip: "127.0.0.1"         # Bot'un IP adresi
  port: 25567             # Bot'un portu
  interval: 300           # Ping verisinin gönderileceği aralık (saniye cinsinden)
   ```

### `messages.yml`
Aşağıda `messages.yml` dosyasında yapılandırılabilecek mesajlar bulunmaktadır:
```yaml
messages:
reload_success: "&aAyarlar başarıyla yeniden yüklendi!"
reload_fail: "&cAyarlar yeniden yüklenirken bir hata oluştu!"
   ```

## Komutlar

`/networkchecker reload`

Bu komut, `config.yml` ve `messages.yml` dosyalarını yeniden yükler ve eklentinin yapılandırmasını günceller.

## Örnek Kullanım
1. Sunucu başlatıldıktan sonra, yapılandırma dosyalarınızı `(config.yml ve messages.yml)` düzenleyin.
2. Ping verisinin gönderilme sıklığını değiştirmek için `config.yml` dosyasındaki interval değerini güncelleyin.
3. Değişikliklerinizi uygulamak için `/networkchecker reload` komutunu kullanın.

## Sorun Giderme
1. Bağlantı Sorunları: Eğer bot'a bağlanamıyorsanız, IP adresi ve port ayarlarının doğru olduğundan emin olun. Ayrıca, bot'un çalıştığından ve doğru portta dinlediğinden emin olun.
2. Konfigürasyon Hataları: Yapılandırma dosyalarınızı doğru formatta düzenlediğinizden emin olun. Hatalar, konsola yazdırılan log mesajlarıyla kontrol edilebilir.