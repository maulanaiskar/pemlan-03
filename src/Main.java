import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bank BCA = new Bank(1, "BCA");
        Bank BRI = new Bank(2, "BRI");

        Rekening rek1 = new Rekening(1234, "Agus", 100000, BCA);
        Rekening rek2 = new Rekening(1235, "Bayu", 1500000, BCA);
        Rekening rek3 = new Rekening(1111, "Ade", 200000, BRI);

        ATM atm1 = new ATM(111, 12345, rek1);
        ATM atm2 = new ATM(222, 67890, rek2);
        ATM atm3 = new ATM(333, 10293, rek3);
        ATM myATM = null;

        System.out.print("Masukan no ATM: ");
        int noAtm = in.nextInt();
        if (noAtm == atm1.noAtm) {
            myATM = atm1;
        } else if (noAtm == atm2.noAtm) {
            myATM = atm2;
        } else if (noAtm == atm3.noAtm) {
            myATM = atm3;
        }

        System.out.println("Masukkan password: ");
        int pass = in.nextInt();
        if (myATM.cekPassword(pass)) {
            if(pass!=pass){
                System.out.println("Password Salah!");
            }
            int pilih = 0;
            while (pilih < 4) {
                System.out.println("Pilih Transaksi: ");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Ambil");
                System.out.println("3. Transfer");
                System.out.println("4. Keluar");
                System.out.print("Masukkan kode transaksi: ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        myATM.rekening.cekSaldo();
                        break;
                    case 2:
                        System.out.println("Masukkan jumlah uang yang diambil: ");
                        int jumlah = in.nextInt();
                        myATM.rekening.ambil(jumlah);
                        break;
                    case 3:
                        System.out.println("Masukkan no rek yang dituju: ");
                        int noRek = in.nextInt();
                        if (noRek == rek1.noRek) {
                            System.out.println("Masukkan nominal: ");
                            int nominal = in.nextInt();
                            myATM.rekening.transfer(rek1, nominal);
                        } else if (noRek == rek2.noRek) {
                            System.out.println("Masukkan nominal: ");
                            int nominal = in.nextInt();
                            myATM.rekening.transfer(rek2, nominal);
                        } else if (noRek == rek3.noRek) {
                            System.out.println("Masukkan nominal: ");
                            int nominal = in.nextInt();
                            myATM.rekening.transfer(rek3, nominal);
                        } else {
                            System.out.println("No. rekering salah");
                        }
                        break;
                }
            }
        } else {
            System.out.println("Password Salah");
        }

    }
}
