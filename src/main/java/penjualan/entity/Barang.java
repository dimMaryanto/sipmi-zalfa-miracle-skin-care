package penjualan.entity;

import penjualan.config.StringConverter;

/**
 *
 * @author Lani
 */
@Deprecated
public class Barang {

    private String kode;
    private String kodeKategori;
    private KategoriBarang kategori;
    private String nama;
    private Double hargaJual;
    private Double hargaBeli;
    private Integer jumlah;
    private Boolean paket;

    public Boolean getPaket() {
        return paket;
    }

    public void setPaket(Boolean paket) {
        this.paket = paket;
    }

    @Deprecated
    public String getKodeBarang() {
        return kode;
    }

    @Deprecated
    public void setKodeBarang(String kodeBarang) {
        this.kode = kodeBarang;
    }

    @Deprecated
    public String getKodeKategori() {
        return kodeKategori;
    }

    @Deprecated
    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    @Deprecated
    public String getNamaBarang() {
        return nama;
    }

    @Deprecated
    public void setNamaBarang(String namaBarang) {
        this.nama = namaBarang;
    }

    @Deprecated
    public double getHarga() {
        return hargaJual;
    }

    @Deprecated
    public void setHarga(double harga) {
        this.hargaJual = harga;
    }

    public String getHargaJualAsCurrency() {
        return StringConverter.getCurrency(hargaJual);
    }

    public String getHargaBeliAsCurrency() {
        return StringConverter.getCurrency(hargaBeli);
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public KategoriBarang getKategori() {
        return kategori;
    }

    public void setKategori(KategoriBarang kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

}
