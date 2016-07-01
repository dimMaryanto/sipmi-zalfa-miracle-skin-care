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
    b.kode, 
    b.nama, 
    b.harga_jual,
    b.harga_beli,
    b.jumlah ,
    b.paket, 
    k.id,
    k.kode,
    k.nama
from barang b JOIN kategori_brg k ON (b.id_kategori = k.id)