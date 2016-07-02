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

CREATE OR REPLACE VIEW v_barang_detail as
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


