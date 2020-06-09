# pctoplama
Bilgisayar parçalarının seçilerek kasa toplama işleminin yapılması.

Proje ilk çalıştırıldığında Giriş ekranında kullanıcı ve admin girişi seçenekleri mevcuttur.Eğer parça eklemesi yapılacaksa admin girişi yapılmalı,
Oem toplama ve kampanya işlemleri için kullanıcı girişi yapılmalıdır.
Admin Girişi için ;
admin
123
Kullanıcı Girişi için;
kullanici
123

Bu kullanıcı adı ve şifreler veritabanındaki admin ve kullanıcı tablolarındaki verilerden kullanılabilir.
Projede 2 adet template kullanılmaktadır(admin ve kullanıcı) Bu template ler girişe göre örneğin;eğer admin girişiyse admin template'e yönlendirilmektedir.Ve buradaki linklere göre erişim sağlanmaktadır.

Bilgisayar Toplama işleminde oem parçaları mevcuttur.
Bu işlemde Oem Toplama sisteminde anakart,bellek,işlemci,ekran kartı ,kasa,monitör ,ssd ,harddisk,işletim sistemi seçerek
oem toplama işlemi gerçekleştirilmektedir.
Bu işlemde anakart,bellek,işlemci,ekran kartı ,kasa,monitör ,ssd ,harddisk,işletim sistemi ile oem sınıfları arasında one to many ilişkisi bulunmaktadır.
anakart,bellek,işlemci,ekran kartı ,kasa,monitör ,ssd ,harddisk,işletim sistemi sınıflarının converterleri yardımıyla oem sınıfı üzerinde seçilmektedir.

anakart,bellek,işlemci,ekran kartı ,kasa,monitör ,ssd ,harddisk,işletim sistemi için Crud işlemleri admin tarafından yapılmakta kullanıcıdan gizlenmektedir.
(parca klasörünü görebilmek için admin girişi yapmak gerek.(login Filter yardımıyla))

Oem toplama başlığı altındaki işlem kullanıcı tarafından yapılmaktadır.Bu işlemde herhangi bir kısıtlama yoktur.

Many to many ilişki olarak projede kullanıcı ve kampanya sınıfları arasındaki kullanicikampanya ilişkisi kurulmuştur.(Kullanıcı ve Kampanya Converteleri kullanılmıştır)
Bu ilişkide kullanıcı ve kampanya seçimini yaparak kullanıcılar için kampanya oluşturulmuştur.
Kullanıcı,Kampanya ve KullanıcıKampanya için kullanici tarafından erişim sağlanmıştır.

Ajax istekleri bütün xhtmllerde kontrol edilmiş eksiksiz şekilde gerçekleştirilmiştir.

Validatörler projedeki oem parçalarında ve kullanıcı login ekranında bilgilerin yanlış ve eksik girilmesinin önüne geçilmiş,istenilen kalıpta girilmesini sağlamışıtr.Buradaki oem parçalarının hepsinde örneğin anakart adı bellek adı 
kısmında ad validatör kullanılmış ve girilecek veri miktarı sınırlandırılmıştır.Toplam 15 adet validatör sınıfı oluşturulmuş bunlar Sınıflarda tanımlanacak nesneleri denetlemek amacıyla kullanılmıştır
Aynı şekilde login kısmındaki kullanıcı ve admin login xhtml leri üzerindede kontrol validatörler yardımıyla gerçekleştirilmiştir.

Sayfalama(Pagination) işlemi bütün xhtmller için gerçekleştirilmiştir.(anakart,bellek,işlemci,ekran kartı ,kasa,monitör ,ssd ,harddisk,işletim sistemi,oem,Kullanıcı,Kampanya ve KullanıcıKampanya)

Dosya işlemleri için kullanıcı sayfasında document xhtml içerisinde dosya işlemleri gerçekleştirilmiştir (zip,rar,png gibi formatlar yüklenebilir)
Veritabanında document tablosunda kayıtları tutulmaktadır.
Yükleme işleminin denetlenebilmesi adına dosya yolu kullanılan bilgisayara göre güncellenmelidir.

Proje Apache Netbeans 11.3,Glassfish 5.1,MariaDB 10.4 ile geliştirilmiştir.Veritabanı dosyası zip içerisine eklenmiştir.
Libraries:JSF 2.3,Java EE 8 API,mysql-connector.

Proje Github Linki : https://github.com/mziyasur/pctoplama

Grup üyeleri;
MEHMET ZİYA SÜRÜCÜ
EYYÜP SEZER
EŞREF YAĞAR 
ALİ CIRIK








