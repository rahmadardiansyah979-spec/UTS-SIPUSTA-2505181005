
package model;

//menyusun kelas turunan dan contoh overriding.

public class Majalah extends Koleksi implements Terarsip {
    private int nomorEdisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;
    private String rak;
    private String lantai;

    public Majalah(
            String kodeKoleksi,
            String judul,
            int tahunTerbit,
            int nomorEdisi,
            String bulanTerbit,
            boolean edisiTerbaru,
            String rak,
            String lantai) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.nomorEdisi = nomorEdisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.rak = rak;
        this.lantai = lantai;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi()
                + " | Edisi: " + nomorEdisi
                + " | Bulan: " + bulanTerbit
                + " | Edisi terbaru: " + edisiTerbaru
                + " | " + ringkasanArsip();
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }
}
