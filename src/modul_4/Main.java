package modul_4;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.println("------------------------------------------------------------");
            System.out.println("           SISTEM KARTU RENCANA STUDI (KRS)                ");
            System.out.println("------------------------------------------------------------");

            // Input data mahasiswa
            System.out.print("Nama Mahasiswa: ");
            String nama = input.nextLine();

            System.out.print("NIM: ");
            String nim = input.nextLine();

            System.out.print("Jurusan: ");
            String jurusan = input.nextLine();

            // Membuat object mahasiswa
            MahaSiswa mhs = new MahaSiswa(nama, nim, jurusan, 0.0);

            // Membuat object KRS (maksimal 10 mata kuliah)
            RencanaKartuStudi krs = new RencanaKartuStudi(mhs, 10);

            // Menu KRS
            boolean running = true;

            while (running) {
                System.out.println("------------------------------------------------------------");
                System.out.println("                        MENU KRS                            ");
                System.out.println("------------------------------------------------------------");
                System.out.println("| 1. Tambah Mata Kuliah                                   |");
                System.out.println("| 2. Input Nilai Mata Kuliah                              |");
                System.out.println("| 3. Tampilkan KRS                                        |");
                System.out.println("| 4. Keluar                                               |");
                System.out.println("| 5. Hapus Mata Kuliah                                    |");
                System.out.println("| 6. Tampilkan Nilai Terbaik & Terburuk                   |");
                System.out.println("------------------------------------------------------------");
                System.out.print("Pilih menu: ");

                int pilihan = input.nextInt();
                input.nextLine(); // consume newline

                switch (pilihan) {
                    case 1:
                        // Tambah mata kuliah
                        System.out.println("\nTAMBAH MATA KULIAH");
                        System.out.println("--------------------");
                        System.out.print("Kode Mata Kuliah: ");
                        String kode = input.nextLine();

                        System.out.print("Nama Mata Kuliah: ");
                        String namaMK = input.nextLine();

                        System.out.print("Jumlah SKS: ");
                        int sks = input.nextInt();
                        input.nextLine();

                        MataKuliah mk = new MataKuliah(kode, namaMK, sks);
                        krs.tambahMatakuliah(mk);
                        break;

                    case 2:
                        // Input nilai
                        System.out.println("\nINPUT NILAI");
                        System.out.println("--------------------");
                        System.out.print("Kode Mata Kuliah: ");
                        String kodeCari = input.nextLine();

                        MataKuliah mkCari = krs.cariMatakuliah(kodeCari);
                        if (mkCari != null) {
                            System.out.print("Nilai (0-100): ");
                            double nilai = input.nextDouble();
                            mkCari.setNilai(nilai);
                            System.out.println("Nilai berhasil diinput!");
                        } else {
                            System.out.println("Mata kuliah tidak ditemukan!");
                        }
                        break;

                    case 3:
                        // Tampilkan KRS
                        krs.tampilkanKRS();
                        break;

                    case 4:
                        // Keluar
                        System.out.println("Terima kasih!");
                        running = false;
                        break;

                    case 5:
                        System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
                        String kodeHapus = input.nextLine();
                        krs.hapusMatakuliah(kodeHapus);
                        break;

                    case 6:
                        krs.tampilkanNilaiTerbaik();
                        krs.tampilkanNilaiTerburuk();
                        break;


                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }

