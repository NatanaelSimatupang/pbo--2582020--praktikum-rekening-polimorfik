public class Tabungan extends Rekening implements BerBunga {

    private double bunga;

    public Tabungan(String nomor, String pemilik,
                    int saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        if (getSaldo() >= 1000000) {
            return 0;
        }
        return 5000;
    }

    @Override
    public int tambahBunga() {
        int jumlahBunga = (int) (
                getSaldo() * bunga / 100
        );

        tambahSaldo(jumlahBunga);
        return jumlahBunga;
    }

    @Override
    protected String keterangan() {
        return "Tabungan, bunga " + bunga + "% per bulan";
    }
}