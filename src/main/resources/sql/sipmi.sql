-- --------------------------------------------------------
--
-- Table structure for table kategori_brg
--

CREATE TABLE IF NOT EXISTS kategori_brg (
    id int(4) primary key NOT NULL AUTO_INCREMENT,
    kode varchar(3) NOT NULL UNIQUE,
    nama varchar(30) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table barang
--

CREATE TABLE IF NOT EXISTS barang (
    kode varchar(30) NOT NULL primary key,
    id_kategori int(4) NOT NULL,
    nama varchar(50) NOT NULL,
    harga_jual double NOT NULL default 0,
    harga_beli double NOT NULL default 0,
    jumlah int(8) NOT NULL default 0,
    paket boolean NOT NULL default 0
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table pelanggan
--

CREATE TABLE IF NOT EXISTS pelanggan (
    kode varchar(10) NOT NULL PRIMARY KEY,
    nama varchar(100) NOT NULL,
    alamat text NOT NULL,
    notlp varchar(100) NOT NULL,
    agen boolean not null default 0
) ENGINE=InnoDB;

----------------------------------------------------------
--
-- Table structure for table supplier
--

CREATE TABLE IF NOT EXISTS pemasok (
    id int(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nama varchar(30) NOT NULL,
    alamat text NOT NULL,
    tlp varchar(15) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table pembelian
--
CREATE TABLE IF NOT EXISTS pembelian (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    kode varchar(15) NOT NULL,
    tgl date NOT NULL,
    id_pemasok int(11) NOT NULL
) ENGINE=InnoDB;


-- --------------------------------------------------------
--
-- Table structure for table pembelian_detail
--
CREATE TABLE IF NOT EXISTS pembelian_detail (
    id int primary key not null auto_increment,
    id_pembelian int NOT NULL,
    kode_barang varchar(5) NOT NULL,
    harga double NOT NULL default 0,
    jumlah int NOT NULL default 0
) ENGINE=InnoDB ;

-- --------------------------------------------------------
--
-- Table structure for table pemesanan_pembelian
--
CREATE TABLE IF NOT EXISTS pesanan_pembelian (
    kode varchar(15) NOT NULL PRIMARY KEY,
    tgl date NOT NULL,
    id_pemasok int NOT NULL
) ENGINE=InnoDB ;

-- --------------------------------------------------------
--
-- Table structure for table pemesanan_pembelian_detail
--
CREATE TABLE IF NOT EXISTS pesanan_pembelian_detail (
    id int PRIMARY KEY not null auto_increment,
    kode_pesanan varchar(15) NOT NULL,
    kode_barang varchar(5) NOT NULL,
    jumlah int NOT NULL default 0
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table penjualan
--

CREATE TABLE IF NOT EXISTS penjualan (
    kode varchar(25) NOT NULL PRIMARY KEY,
    tgl date NOT NULL,
    kode_pelanggan varchar(10) NOT NULL
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table penjualan_detail
--
CREATE TABLE IF NOT EXISTS penjualan_detail (
    id int primary key not null auto_increment,
    kode_penjualan varchar(25) NOT NULL,
    kode_barang varchar(5) NOT NULL,
    harga double NOT NULL default 0,
    diskon double NOT NULL default 0,
    jumlah int NOT NULL default 0
) ENGINE=InnoDB;

-- --------------------------------------------------------
--
-- Table structure for table user
--

CREATE TABLE IF NOT EXISTS user (
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nama varchar(50) NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    jabatan varchar(20) NOT NULL,
    status boolean NOT NULL DEFAULT 0
) ENGINE=InnoDB;

--
-- Dumping data for table user
--

INSERT INTO user (id, nama, username, password, jabatan, status) VALUES
    (1, 'admin', 'admin', 'admin', 'Admin', 1),
    (2, 'lani ', 'lani', 'gudang', 'gudang', 1),
    (3, 'wulan', 'wulan', 'kasir', 'kasir', 0);

-- --------------------------------------------------------
--
-- constraints
--

ALTER TABLE barang
    ADD CONSTRAINT fk_barang_kategori 
    FOREIGN KEY (id_kategori) 
    REFERENCES kategori_brg(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE pembelian 
    ADD CONSTRAINT fk_beli_pemasok
    FOREIGN KEY (id_pemasok)
    REFERENCES pemasok(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE pembelian_detail
    ADD CONSTRAINT fk_beli_detail_beli
    FOREIGN KEY (id_pembelian) 
    REFERENCES pembelian(id) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD CONSTRAINT fk_beli_detail_barang
    FOREIGN KEY (kode_barang) 
    REFERENCES barang(kode) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE pesanan_pembelian
    ADD CONSTRAINT fk_pesan_beli_pemasok
    FOREIGN KEY (id_pemasok)
    REFERENCES pemasok(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE pesanan_pembelian_detail
    ADD CONSTRAINT fk_pesan_beli_detail_pesan_beli
    FOREIGN KEY (kode_pesanan)
    REFERENCES pesanan_pembelian(kode) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD CONSTRAINT fk_pesan_beli_detail_barang
    FOREIGN KEY (kode_barang)
    REFERENCES barang(kode) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE penjualan
    ADD CONSTRAINT fk_jual_pelanggan
    FOREIGN KEY (kode_pelanggan)
    REFERENCES pelanggan(kode) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE penjualan_detail
    ADD CONSTRAINT fk_jual_detail_jual
    FOREIGN KEY (kode_penjualan) 
    REFERENCES penjualan(kode) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD CONSTRAINT fk_jual_detail_barang
    FOREIGN KEY (kode_barang)
    REFERENCES barang(kode) ON UPDATE CASCADE ON DELETE CASCADE;

-- ----------------------------------------------------------------------
--
-- View statement
--

CREATE OR REPLACE VIEW v_barang AS
SELECT 
    b.kode as kode_barang,
    b.nama as nama_barang,
    b.harga_jual as harga_jual_barang,
    b.harga_beli as harga_beli_barang,
    b.jumlah as stok_barang,
    b.paket as barang_paketan,
    k.id as id_kategori,
    k.kode as kode_kategori,
    k.nama as nama_kategori_barang
FROM barang b JOIN kategori_brg k ON (b.id_kategori = k.id);

CREATE OR REPLACE VIEW v_pembelian AS
SELECT 
    b.id as id_pembelian, 
    b.kode as kode_pembelian,
    b.tgl as tanggal_pembelian,
    p.id as kode_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as telp_pemasok
FROM pembelian b JOIN pemasok p ON (b.id_pemasok = p.id);

CREATE OR REPLACE VIEW v_pembelian_detail AS
SELECT 
    b.id as id_pembelian, 
    b.kode as kode_pembelian,
    b.tgl as tanggal_pembelian,
    p.id as kode_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as telp_pemasok,
    bd.id as id_pembelian_detail,
    bd.harga as harga_pembelian,
    bd.jumlah as jumlah_pembelian,
    brg.kode as kode_barang,
    brg.nama as nama_barang,
    brg.harga_jual as harga_jual_barang,
    brg.harga_beli as harga_beli_barang,
    brg.jumlah as stok_barang,
    brg.paket as barang_paketan,
    kbrg.id as id_kategori_barang,
    kbrg.kode as kode_ketegori_barang,
    kbrg.nama as nama_kategori_barang
FROM pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)
    JOIN pembelian_detail bd ON (b.id = bd.id_pembelian)
    JOIN barang brg ON (bd.kode_barang = brg.kode)
    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori);

CREATE OR REPLACE VIEW v_pesanan_pembelian AS
SELECT     
    b.kode as kode_pesanan,
    b.tgl as tanggal_pesanan,
    p.id as kode_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as telp_pemasok
FROM pesanan_pembelian b JOIN pemasok p ON (b.id_pemasok = p.id); 

CREATE OR REPLACE VIEW v_pesanan_pembelian_detail AS
SELECT 
    b.kode as kode_pemesanan,
    b.tgl as tanggal_pemesanan,
    p.id as kode_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as telp_pemasok,
    bd.id as id_pemesanan_detail,
    bd.jumlah as jumlah_pemesanan,
    brg.kode as kode_barang,
    brg.nama as nama_barang,
    brg.harga_jual as harga_jual_barang,
    brg.harga_beli as harga_beli_barang,
    brg.jumlah as stok_barang,
    brg.paket as barang_paketan,
    kbrg.id as id_kategori_barang,
    kbrg.kode as kode_ketegori_barang,
    kbrg.nama as nama_kategori_barang
FROM pesanan_pembelian b JOIN pemasok p ON (b.id_pemasok = p.id)
    JOIN pesanan_pembelian_detail bd ON (b.kode = bd.kode_pesanan)
    JOIN barang brg ON (bd.kode_barang = brg.kode)
    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori);

CREATE OR REPLACE VIEW v_penjualan AS
SELECT 
    j.kode as kode_penjualan,
    j.tgl as tanggal_penjualan,
    p.kode as kode_pelanggan,
    p.nama as nama_pelanggan,
    p.alamat as alamat_pelanggan,
    p.notlp as tlp_pelanggan,
    p.agen as pelanggan_agen
FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode);

CREATE OR REPLACE VIEW v_penjualan_detail AS
SELECT 
    j.kode as kode_penjualan,
    j.tgl as tanggal_penjualan,
    p.kode as kode_pelanggan,
    p.nama as nama_pelanggan,
    p.alamat as alamat_pelanggan,
    p.notlp as tlp_pelanggan,
    p.agen as pelanggan_agen,
    jd.id as kode_penjualan_detail,
    jd.harga as harga_penjualan,
    jd.jumlah as jumlah_penjualan,
    jd.diskon as diskon_penjualan,
    brg.kode as kode_barang,
    brg.nama as nama_barang,
    brg.harga_jual as harga_jual_barang,
    brg.harga_beli as harga_beli_barang,
    brg.jumlah as stok_barang,
    brg.paket as barang_paketan,
    kbrg.id as id_kategori_barang,
    kbrg.kode as kode_kategori_barang,
    kbrg.nama as nama_kategori_barnag
FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)
    JOIN penjualan_detail jd ON (j.kode = jd.kode_penjualan)
    JOIN barang brg ON (brg.kode = jd.kode_barang)
    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori);