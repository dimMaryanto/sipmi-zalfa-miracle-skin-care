/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jul 2, 2016
 */

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
FROM barang b JOIN kategori_brg k ON (b.id_kategori = k.id)