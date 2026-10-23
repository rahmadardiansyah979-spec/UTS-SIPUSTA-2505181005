
package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

//menyusun layanan katalog dan proses peminjaman.

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void cetakStatus() {
        System.out.println("\n=== STATUS KATALOG SIPUSTA ===");

        for (Koleksi koleksi : daftarKoleksi) {
            System.out.println(koleksi.deskripsi());

            if (koleksi.isSedangDipinjam()) {
                System.out.println("Status: Sedang dipinjam");
            } else if (koleksi.layakDipinjam()) {
                System.out.println("Status: Layak dipinjam");
            } else {
                System.out.println("Status: Tidak layak dipinjam");
            }

            System.out.println("--------------------------------");
        }
    }

    public void urut(Comparator<Koleksi> pembanding) {
        daftarKoleksi.sort(pembanding);
    }

    public void pinjam(String kodeKoleksi)
            throws KoleksiSedangDipinjamException,
                   KoleksiTidakLayakException {

        for (Koleksi koleksi : daftarKoleksi) {
            if (koleksi.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {

                if (koleksi.isSedangDipinjam()) {
                    throw new KoleksiSedangDipinjamException(
                            "Koleksi sedang dipinjam dan belum dikembalikan.");
                }

                if (!koleksi.layakDipinjam()) {
                    throw new KoleksiTidakLayakException(
                            "Koleksi belum dapat dipinjam karena tidak memenuhi syarat.");
                }

                koleksi.setSedangDipinjam(true);
                System.out.println(
                        "Peminjaman berhasil: " + koleksi.getJudul());
                return;
            }
        }

        System.out.println("Kode koleksi tidak ditemukan: " + kodeKoleksi);
    }
}
