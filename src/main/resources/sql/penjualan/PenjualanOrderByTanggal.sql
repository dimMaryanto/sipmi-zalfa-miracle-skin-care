/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jul 12, 2016
 */

SELECT 
    j.kode as kode_penjualan,
    j.tgl as tanggal_penjualan,
    p.kode as kode_pelanggan,
    p.nama as nama_pelanggan,
    p.alamat as alamat_pelanggan,
    p.notlp as tlp_pelanggan,
    p.agen as pelanggan_agen
FROM penjualan j JOIN pelanggan p ON (j.kode_pelanggan = p.kode)
WHERE p.kode = 'PEL001'
ORDER BY j.tgl ASC