İlk olarak kullanıcıdan girmek istediği şehir sayısı istenir. Ardından kullanıcıdan girmek istediği şehir bilgileri alınır.
Dijkstra fonksiyonu bir kere çalıştırılır ve Kocaelinden tüm şehirlere uzaklık hesaplaması yapılır ve bu uzaklıklar tutulur.
Kullanıcıdan alınan şehirler arasından başlangıç noktası Kocaeline, olan uzaklıklarına bakılarak en yakın şehir seçilir. Böylece Kocaelinden ilk ulaşılacak ana şehir belirlenmiş olur. Ardından bu ana şehir dijkstra fonksiyonuna gönderilir.
 Dijkstra fonksiyonunda Koceliden bu gönderilen ana şehre gitmek için çalıştırılır. Bu fonksiyonda yollar matrisi yardımıyla komşular kullanılmak şartıyla kocaeliden belirlenen ana şehre ulaşmak için uğranılacak şehirler bilgisi tutulur. 
Ve bu şehirlerarası uzaklık komşuluk matrisine bakılarak hesaplanır.
Kocaelinden başlayarak gidilebilecek komşular arasından rastgele şehir seçilir. 
Ve bu şehrin komşularından devam edilerek ilk ana şehre ulaşana kadar komşular üzerinden devam edilir. 
 Daha sonra yeni başlangıç noktası bu ilk ana şehir olur. 
Dijkstra algoritması kullanıcının gitmek istediği son şehre ulaşana kadar bu şekilde tekrar tekrar çağrılır.
Son ana şehre gelip Kocaeline döndüğünde toplam mesafe hesaplanır. Ve çıktıda bu işlemler tekrarlanıp alternatif 5 tane yol üretilir.
Bu uzaklıklara bakılarak projede istenen en kısa yola karar verilip kullanıcıya bilgi aktarılır. Ve bu çıktılar sonuç isimli output dosyasına yazdırılır.
(Yani kullanıcı izmir adiyamana gitmek istediğinde kocaeline daha yakın olduğu için önce izmire kocaelinden başlayarak komşular üzerinden gidilir
. Artık başlangıç noktam izmir ve anı şekilde komşular üzerinden adiyaman gidilir.
 Kullanıcı kaç şehir girerse girsin bu işlem gerçekleşir.Ve donus yolu ise adiyamandan başlayıp kocaelinde biter.)


Proje çalışmasında proje indirilerek kullanılan ide ye import edilip derlenir ve çalıştırılır. Kullanıcıdan önce bir sayı istenir ve ardından bu sayıda baş harfleri büyük( aksi halde şehirleri bulamaz ve işlemi gerçekleştiremez.) olacak şekilde şehir ismi girmesi istenir.
 Bu bilgiler ile algoritma çalışır.

