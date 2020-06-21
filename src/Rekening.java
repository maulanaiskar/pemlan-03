public class Rekening {
    int noRek;
    String nama;
    double saldo;
    Bank bank;

    public Rekening(int noRek, String nama, double saldo, Bank bank) {
        this.nama = nama;
        this.noRek = noRek;
        this.saldo = saldo;
        this.bank = bank;

    }

    public void cekSaldo() {
        System.out.println("Saldo Anda: " + saldo);
    }

    public boolean ambil(int saldo) {
        boolean keterangan = true;
        if ((this.saldo - saldo) <= 10000) {
            keterangan = false;
        } else {
            this.saldo -= saldo;
        }
        return keterangan;

    }

    public void transfer(Rekening rek, double jumlah) {
        if (this.bank.kode == rek.bank.kode) {
            if ((this.saldo - jumlah) < 25000) {
                System.out.println("Saldo tidak mencukupi");
            } else {
                this.saldo -= jumlah;
                rek.saldo += jumlah;
                System.out.println("Tansfer berhasil");
            }
        } else {
            if ((this.saldo - jumlah - 5000) < 25000) {
                System.out.println("Saldo tidak mencukupi");
            } else {
                this.saldo -= (jumlah + 5000);
                rek.saldo += jumlah;
                System.out.println("Tansfer berhasil");
            }

        }
    }
}
