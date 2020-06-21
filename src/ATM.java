public class ATM {
    int noAtm, pass;
    Rekening rekening;

    public ATM(int noAtm, int pass, Rekening rekening) {
        this.noAtm = noAtm;
        this.pass = pass;
        this.rekening = rekening;
    }

    public boolean cekPassword(int pass) {
        boolean keterangan = true;
        if (this.pass != pass) {
            keterangan = false;
        }
        return keterangan;
    }

}
