# Zalfa Miracle Skin Care Bandung

![Zalfa miracle skin cara bandung](/imgs/sipmi.png)

## Hal yang harus dilakukan

* Install Java Runtime Environment
* Install Database [MySQL](http://dev.mysql.com/downloads/installer/) atau [MariaDB](https://mariadb.org/download/)
* [Download jar ```sipmi-zalfa-miracle-skin-care-x.x.jar```](https://github.com/dimMaryanto/sipmi-zalfa-miracle-skin-care/releases)
* Membuat launcher
* Jalankan aplikasi

## Install Java Runtime Environment (JRE)

* [Download disini](http://www.oracle.com/technetwork/java/javase/downloads/) pilih yang JRE ya!!!
* Install seperti bisa tinggal Next -> Next -> Finish

## Install Database MariaDB

* [Download disini](https://mariadb.org/download/)
* Pilih yang stable edition
  * Windows -> .msi
  * Linux -> .tar.gz atau via repository (apt-get, dnf, dll)
* Jalankan setup.msi
* Setting Password root ```admin```
* Setting Port default MySQL ```3306```

## Membuat koneksi database & user schema

* Login sebagai root

```bash
mysql -u root -p
```

* Ubah password root

```sql
grant all privileges on *.* to 'root'@'localhost' identified by 'admin';
flush privileges;
```

* Membuat database dengan nama ```sipmi```

```sql
create database sipmi;

use sipmi;
```

* Download SQL file [disini]() -> save as -> ```sipmi.sql``` -> simpan di Downloads

* Arahkan command prompt ke Downloas

```bash
cd C:\Users\nama-user-anda\Downloads
```

klo saya jadi gini

```bash
cd C:\Users\softw\Downloads
```

* Cek dulu apakah ada filenya

```bash
dir
```

hasilnya seperti berikut

```bash
C:\Users\softw\Downloads>dir
 Volume in drive C has no label.
 Volume Serial Number is DEE3-0EB1

 Directory of C:\Users\softw\Downloads

07/21/2016  12:19 PM    <DIR>          .
07/21/2016  12:19 PM    <DIR>          ..
07/21/2016  12:15 PM             9,845 sipmi.sql
               1 File(s)          9,845 bytes
               2 Dir(s)  927,020,216,320 bytes free

C:\Users\softw\Downloads>
```

## Import SQL file ke MySQL database

* kemudian kita import filenya ke database sipmi dalam MySQL

```sql
mysqldump -u root -p sipmi < sipmi.sql
```

* atau cara lain kita login dulu ke user ```root``` dan database ```sipmi```

```sql
mysql -u root -p sipmi

source C:/User/softw/Downloads/simpi.sql
```

* kemudian kita Cek hasilnya, login sebagai root dan masuk ke schema ```sipmi```

```bash
mysql -u root -p sipmi
```

* Setelah itu kita check sql yg telah dibuat dengan perintah sebagai berikut:

```sql
show tables
```

maka hasilnya seperti berikut

```bash
MariaDB [sipmi]> show tables;
+----------------------------+
| Tables_in_sipmi            |
+----------------------------+
| barang                     |
| kategori_brg               |
| pelanggan                  |
| pemasok                    |
| pembelian                  |
| pembelian_detail           |
| penjualan                  |
| penjualan_detail           |
| pesanan_pembelian          |
| pesanan_pembelian_detail   |
| user                       |
| v_barang                   |
| v_pembelian                |
| v_pembelian_detail         |
| v_penjualan                |
| v_penjualan_detail         |
| v_pesanan_pembelian        |
| v_pesanan_pembelian_detail |
+----------------------------+
18 rows in set (0.00 sec)
```

## Download jar archive

* Download [aplikasi zalfa-miracle-skin-care-x.x.jar](https://github.com/dimMaryanto/sipmi-zalfa-miracle-skin-care/releases)
* Untuk menjalankan sebenarnya ada banyak cara yaitu menggunakan terminal atau command prompt dan menggunakan cara biasa yaitu double klik (klik 2x)

### Menggunakan terminal atau command promnt

* peraintah dasar

```bash
java -jar sipmi-zalfa-miracle-skin-care-x.x.jar
```

### Menggunakan double click (klik 2x)

* Klik kanan ```sipmi-zalfa-miracle-skin-care-x.x.jar``` -> Open with -> Java (TM) Platform SE Binary
