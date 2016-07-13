/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jul 13, 2016
 */

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
    JOIN kategori_brg kbrg ON (kbrg.id = brg.id_kategori)
WHERE b.tgl < '2016-07-14'