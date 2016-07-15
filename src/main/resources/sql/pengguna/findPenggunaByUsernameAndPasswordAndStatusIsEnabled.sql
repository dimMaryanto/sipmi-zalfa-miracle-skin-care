/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimmaryanto
 * Created: Jul 15, 2016
 */

SELECT u.id, u.username, u.password, u.nama, u.jabatan, u.status
FROM `user` u 
WHERE u.username = 'admin' AND u.password = 'admin' AND u.status = 1;