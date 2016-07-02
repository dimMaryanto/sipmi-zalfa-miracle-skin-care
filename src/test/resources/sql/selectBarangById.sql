/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jun 27, 2016
 */

select 
    b.kode as kode_barang, 
    b.nama as nama_barang, 
    b.harga_jual as harga_jual,
    b.harga_beli as harga_beli,
    b.jumlah as jumlah_barang,
    b.paket as barang_paketan, 
    k.id as id_kategori,
    k.kode kode_kategori,
    k.nama as nama_kategori_barang
from barang b JOIN kategori_brg k ON (b.id_kategori = k.id)
WHERE b.kode = 'PB01'