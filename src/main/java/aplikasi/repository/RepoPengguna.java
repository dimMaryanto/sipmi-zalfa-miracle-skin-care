/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Pengguna;
import java.sql.SQLException;

/**
 *
 * @author dimmaryanto
 */
public interface RepoPengguna extends BaseRepository<Pengguna, Integer> {

    public Pengguna findByUsernameAndPasswordAndIsStatusEnabled(String username, String Password) throws SQLException;

    public void updatePasswordByUsername(String username, String password) throws SQLException;

}
