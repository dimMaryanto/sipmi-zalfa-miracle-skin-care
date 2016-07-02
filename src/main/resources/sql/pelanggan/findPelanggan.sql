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
    p.kode as kode_pelanggan, 
    p.nama as nama_pelanggan, 
    p.alamat as alamat_pelanggan, 
    p.notlp as no_telepone, 
    p.agen as sebagai_agen
FROM pelanggan p;