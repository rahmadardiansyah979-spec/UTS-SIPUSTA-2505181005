
package pembanding;

import java.util.Comparator;
import model.Koleksi;

//menyusun comparator pengurutan koleksi.

public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {
        int hasilKelayakan = Boolean.compare(
                b.layakDipinjam(),
                a.layakDipinjam()
        );

        if (hasilKelayakan != 0) {
            return hasilKelayakan;
        }

        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}
