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
public class Barang {

    private String kode;
    private String nama;
    private KategoriBarang kategori;
    private Double hargaJual;
    private Double hargaBeli;
    private Integer jumlah;
    private Boolean paket;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public KategoriBarang getKategori() {
        return kategori;
    }

    public void setKategori(KategoriBarang kategori) {
        this.kategori = kategori;
    }

    public Double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Boolean getPaket() {
        return paket;
    }

    public void setPaket(Boolean paket) {
        this.paket = paket;
    }

}
