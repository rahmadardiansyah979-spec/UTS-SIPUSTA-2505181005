
import model.BukuCetak;
import model.Majalah;
import model.BerkasDigital;
import model.Koleksi;

import layanan.KatalogPerpustakaan;
import pembanding.UrutLayakLaluJudul;
import ekspor.EksporKatalog;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        //menyusun data uji dan alur pengujian fitur UTS.

        katalog.tambahKoleksi(new BukuCetak(
                "BK-001", "Java How to Program", 2022,
                620, "A-12", "Lantai 1", false));

        katalog.tambahKoleksi(new BukuCetak(
                "BK-002", "Basis Data Relasional", 2021,
                410, "B-04", "Lantai 1", true));

        katalog.tambahKoleksi(new Majalah(
                "MJ-001", "Info Teknologi Edisi 88", 2026,
                88, "Agustus", true, "C-01", "Lantai 2"));

        katalog.tambahKoleksi(new Majalah(
                "MJ-002", "Info Teknologi Edisi 87", 2026,
                87, "Juli", false, "C-02", "Lantai 2"));

        katalog.tambahKoleksi(new BerkasDigital(
                "BD-001", "Panduan Pemrograman Java", 2024,
                15, "https://unduh.polmed.ac.id/bd001"));

        katalog.tambahKoleksi(new BerkasDigital(
                "BD-002", "Jurnal Rekayasa Perangkat", 2025,
                8, "https://unduh.polmed.ac.id/bd002"));

        // Menampilkan semua koleksi.
        katalog.cetakStatus();

        // Mengurutkan koleksi berdasarkan kelayakan lalu judul.
        katalog.urut(new UrutLayakLaluJudul());

        System.out.println("\n=== KATALOG SETELAH DIURUTKAN ===");
        katalog.cetakStatus();

        // Menguji peminjaman yang berhasil.
        try {
            katalog.pinjam("BK-001");
        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }
        
        //menguji peminjaman ulang koleksi yang sedang dipinjam.
        try {
             katalog.pinjam("BK-001");
        } catch (KoleksiSedangDipinjamException
               | KoleksiTidakLayakException e) {
         System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        // Menguji koleksi yang tidak layak dipinjam.
        try {
            katalog.pinjam("BK-002");
        } catch (KoleksiSedangDipinjamException
                | KoleksiTidakLayakException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }

        // Mengekspor katalog ke katalog.txt.
        try {
            EksporKatalog ekspor = new EksporKatalog();
            ekspor.ekspor(katalog, "katalog.txt");
            System.out.println("\nKatalog berhasil diekspor ke katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal mengekspor katalog: " + e.getMessage());
        }

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}
