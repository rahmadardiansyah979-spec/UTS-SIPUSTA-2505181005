
package eksepsi;

//menyusun hierarki exception untuk kasus SIPUSTA.

public class PustakaException extends Exception {

    public PustakaException(String pesan) {
        super(pesan);
    }
}
