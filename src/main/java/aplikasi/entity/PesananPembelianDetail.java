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
public class PesananPembelianDetail {

    private Integer id;
    private PesananPembelian pesananPembelian;
    private Barang barang;
    private Integer jumlah;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PesananPembelian getPesananPembelian() {
        return pesananPembelian;
    }

    public void setPesananPembelian(PesananPembelian pesananPembelian) {
        this.pesananPembelian = pesananPembelian;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}
