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
    b.id as id_pembelian,
    b.kode as kode_pembelian,
    b.tgl as tanggal_pembelian,
    p.id as id_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as tlp_pemasok,
    bd.harga as harga_pembelian,
    bd.jumlah as jumlah_pembelian,
    brg.kode as kode_barang,
    brg.nama as nama_barang,
    brg.harga_jual as harga_jual_barang,
    brg.harga_beli as harga_beli_barang,
    brg.jumlah as stok_barang,
    brg.paket as paket_barang,
    kbrg.id as id_kategori,
    kbrg.kode as kode_kategori,
    kbrg.nama as nama_kategori
FROM
    pembelian b JOIN pembelian_detail bd ON (b.id = bd.id_pembelian)
    JOIN barang brg ON (bd.kode_barang = brg.kode)
    JOIN kategori_brg kbrg ON (brg.id_kategori = kbrg.id)
    JOIN pemasok p ON (p.id = b.id_pemasok)
WHERE b.tgl BETWEEN '2016-06-01' AND '2016-06-30'