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
    p.id as kode_pemasok,
    p.nama as nama_pemasok,
    p.alamat as alamat_pemasok,
    p.tlp as tlp_pemasok
FROM pemasok p;