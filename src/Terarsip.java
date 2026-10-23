
package model;

//menyusun interface informasi arsip.

public interface Terarsip {
    String nomorRak();

    String lokasiLantai();

    default String ringkasanArsip() {
        return "Rak: " + nomorRak()
                + " | Lantai: " + lokasiLantai();
    }
}
