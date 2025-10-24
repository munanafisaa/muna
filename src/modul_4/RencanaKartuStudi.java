package modul_4;

public class RencanaKartuStudi {
    private MahaSiswa mahasiswa;
    private MataKuliah[] daftarMatakuliah;
    private int jumlahMatkul;
    private int maxMatkul;
    private final int BATAS_SKS = 24; // 🔹 Batas total SKS

    public RencanaKartuStudi(MahaSiswa mahasiswa, int maxMatkul) {
        this.mahasiswa = mahasiswa;
        this.maxMatkul = maxMatkul;
        this.daftarMatakuliah = new MataKuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    // 🔹 Menambah mata kuliah ke KRS (dengan validasi total SKS)
    public void tambahMatakuliah(MataKuliah matkul) {
        int totalBaru = getTotalSKS() + matkul.getSks();

        if (jumlahMatkul >= maxMatkul) {
            System.out.println("KRS sudah penuh! Maksimal " + maxMatkul + " mata kuliah.");
        } else if (totalBaru > BATAS_SKS) {
            System.out.println(" Gagal menambah. Total SKS melebihi batas " + BATAS_SKS + ".");
        } else {
            daftarMatakuliah[jumlahMatkul] = matkul;
            jumlahMatkul++;
            System.out.println(" Mata kuliah " + matkul.getNama() + " berhasil ditambahkan.");
        }
    }

    // 🔹 Menghapus mata kuliah berdasarkan kode
    public void hapusMatakuliah(String kode) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                ditemukan = true;
                System.out.println(" Mata kuliah " + daftarMatakuliah[i].getNama() + " dihapus dari KRS.");
                // Geser elemen ke kiri untuk menutup celah
                for (int j = i; j < jumlahMatkul - 1; j++) {
                    daftarMatakuliah[j] = daftarMatakuliah[j + 1];
                }
                daftarMatakuliah[jumlahMatkul - 1] = null;
                jumlahMatkul--;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println(" Mata kuliah dengan kode " + kode + " tidak ditemukan.");
        }
    }

    // 🔹 Menghitung total SKS
    public int getTotalSKS() {
        int total = 0;
        for (int i = 0; i < jumlahMatkul; i++) {
            total += daftarMatakuliah[i].getSks();
        }
        return total;
    }

    // 🔹 Menghitung IPS sementara
    public double hitungIPS() {
        double totalBobot = 0.0;
        double totalSKS = getTotalSKS();

        if (jumlahMatkul == 0) return 0.0;

        for (int i = 0; i < jumlahMatkul; i++) {
            totalBobot += daftarMatakuliah[i].getBobotNilai() * daftarMatakuliah[i].getSks();
        }

        return totalSKS > 0 ? totalBobot / totalSKS : 0.0;
    }

    // 🔹 Menampilkan data KRS
    public void tampilkanKRS() {
        System.out.println("============================================");
        System.out.println("           KARTU RENCANA STUDI (KRS)");
        System.out.println("============================================");
        System.out.println("NIM   : " + mahasiswa.getNim());
        System.out.println("Nama  : " + mahasiswa.getNama());
        System.out.println("Jurusan : " + mahasiswa.getJurusan());
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s %-30s %s\n", "Kode", "Nama Mata Kuliah", "SKS NILAI");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < jumlahMatkul; i++) {
            daftarMatakuliah[i].tampilkanInfo();
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total SKS: " + getTotalSKS());
        System.out.printf("IPS Semester Ini: %.2f\n", hitungIPS());
        System.out.println("============================================\n");
    }

    // 🔹 Mencari mata kuliah berdasarkan kode
    public MataKuliah cariMatakuliah(String kode) {
        for (int i = 0; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getKode().equalsIgnoreCase(kode)) {
                return daftarMatakuliah[i];
            }
        }
        return null;
    }

    // 🔹 Menampilkan mata kuliah dengan nilai terbaik
    public void tampilkanNilaiTerbaik() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah dalam KRS.");
            return;
        }

        MataKuliah terbaik = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() > terbaik.getNilai()) {
                terbaik = daftarMatakuliah[i];
            }
        }
        System.out.println(" Mata kuliah dengan nilai terbaik: " + terbaik.getNama() +
                " (" + terbaik.getNilai() + " - " + terbaik.getNilaiHuruf() + ")");
    }

    // 🔹 Menampilkan mata kuliah dengan nilai terburuk
    public void tampilkanNilaiTerburuk() {
        if (jumlahMatkul == 0) {
            System.out.println("Belum ada mata kuliah dalam KRS.");
            return;
        }

        MataKuliah terburuk = daftarMatakuliah[0];
        for (int i = 1; i < jumlahMatkul; i++) {
            if (daftarMatakuliah[i].getNilai() < terburuk.getNilai()) {
                terburuk = daftarMatakuliah[i];
            }
        }
        System.out.println(" Mata kuliah dengan nilai terburuk: " + terburuk.getNama() +
                " (" + terburuk.getNilai() + " - " + terburuk.getNilaiHuruf() + ")");
    }
}