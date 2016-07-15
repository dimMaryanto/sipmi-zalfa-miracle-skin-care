/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity;

/**
 *
 * @author dimmaryanto
 */
public class Pengguna {

    public enum Role {
        ADMIN, GUDANG, KASIR
    }

    private Integer id;
    private String username;
    private String password;
    private String nama;
    private Role jabatan;
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Role getJabatan() {
        return jabatan;
    }

    public void setJabatan(Role jabatan) {
        this.jabatan = jabatan;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
