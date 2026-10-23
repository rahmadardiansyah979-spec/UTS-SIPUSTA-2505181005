
package eksepsi;

//contoh exception saat koleksi sudah dipinjam.

public class KoleksiSedangDipinjamException extends PustakaException {

    public KoleksiSedangDipinjamException(String pesan) {
        super(pesan);
    }
}
