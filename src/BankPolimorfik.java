public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            r.tampilkanInfo();
        }

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        // 1) Potong biaya admin semua rekening lebih dulu
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.rupiah(biaya));
        }
        // 2) Lalu tambahkan bunga untuk rekening yang berbunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.println(b.getNomor() + " bunga        : " + Rekening.rupiah(bunga));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.tampilkanInfo();
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));

        // Percobaan: membuat object dari abstract class.
        // Baris berikut (Rekening r = new Rekening("999", "Eko", 0);) ditulis di main,
        // dijalankan, lalu dihapus supaya program bisa di-compile lagi.
        // Pesan error yang muncul:
        // BankPolimorfik.java:39: error: Rekening is abstract; cannot be instantiated
        //         Rekening r = new Rekening("999", "Eko", 0);
        //                      ^
        // 1 error
        // Penyebab: Rekening adalah abstract class (punya method abstract
        // biayaAdminBulanan()), sehingga tidak boleh dibuat object langsung dengan new.
    }
}
