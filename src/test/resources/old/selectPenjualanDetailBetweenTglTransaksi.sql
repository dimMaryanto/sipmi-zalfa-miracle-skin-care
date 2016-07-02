/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jun 28, 2016
 */

SELECT
    j.kode as kode_penjualan,
    j.tgl as tanggal_jual,
    p.kode as kode_pelanggan,
    p.nama as nama_pelanggan,
    p.alamat as alamat_pelanggan,
    p.notlp as tlp_pelanggan,
    p.agen as agen,
    jd.harga as harga_jual,
    jd.diskon as diskon_jual,
    jd.jumlah as jumlah_jual,
    brg.kode as kode_barang,
    brg.nama as nama_barang,
    brg.harga_jual as harga_jual_barang,
    brg.harga_beli as harga_beli_barang, 
    brg.jumlah as stok_barang,
    brg.paket as barang_paketan,
    kbrg.id as id_kategori_barang,
    kbrg.kode as kode_kategori_barang,
    kbrg.nama as nama_kategori
FROM penjualan j 
    JOIN penjualan_detail jd ON (j.kode = jd.kode_penjualan)
    JOIN pelanggan p ON (j.kode_pelanggan = p.kode)
    JOIN barang brg ON (brg.kode = jd.kode_barang)
    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)
WHERE j.tgl between '2016-06-01' AND '2016-06-31'
