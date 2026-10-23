
package eksepsi;

//contoh exception saat koleksi belum boleh dipinjam.

public class KoleksiTidakLayakException extends PustakaException {

    public KoleksiTidakLayakException(String pesan) {
        super(pesan);
    }
}
