public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    public int getBatasOverdraft() {
        return batasOverdraft;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo + batasOverdraft) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("      Giro, batas overdraft " + rupiah(batasOverdraft));
    }
}

