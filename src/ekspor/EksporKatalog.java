
package ekspor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import model.Koleksi;
import layanan.KatalogPerpustakaan;

//menyusun ekspor katalog dengan try-with-resources.

public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog, String namaFile)
            throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of(namaFile),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE)) {

            writer.write(String.format(
                    "%-10s | %-32s | %-12s | %-20s%n",
                    "KODE", "JUDUL", "TAHUN", "STATUS"
            ));

            writer.write(
                    "--------------------------------------------------------------------------"
                            + System.lineSeparator()
            );

            for (Koleksi koleksi : katalog.getDaftarKoleksi()) {
                String status;

                if (koleksi.isSedangDipinjam()) {
                    status = "Sedang dipinjam";
                } else if (koleksi.layakDipinjam()) {
                    status = "Layak dipinjam";
                } else {
                    status = "Tidak layak";
                }

                writer.write(String.format(
                        "%-10s | %-32s | %-12d | %-20s%n",
                        koleksi.getKodeKoleksi(),
                        koleksi.getJudul(),
                        koleksi.getTahunTerbit(),
                        status
                ));
            }
        }
    }
}
