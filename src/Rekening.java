public abstract class Rekening {

    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    protected void tambahSaldo(int jumlah) {
        saldo += jumlah;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    protected String keterangan() {
        return "";
    }

    protected String formatRupiah(int jumlah) {
        return "Rp" + String.format(
                java.util.Locale.forLanguageTag("id-ID"),
                "%,d", jumlah
        ).replace(',', '.');
    }

    public void cetakInfo() {
        System.out.printf(
                "%-3s | %-6s | %12s       %s%n",
                nomor,
                pemilik,
                formatRupiah(saldo),
                keterangan()
        );
    }
}