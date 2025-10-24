package modul_4;

public class MahaSiswa {
        // Atribut/Field (private untuk encapsulation)
        private String nama;
        private String nim;
        private String jurusan;

        // Constructor dengan parameter
        public MahaSiswa(String nama, String npm, String jurusan, double ipk) {
            this.nama = nama;
            this.nim = npm;
            this.jurusan = jurusan;
        }

        // Getter methods
        public String getNama() {
            return nama;
        }

        public String getNim() {
            return nim;
        }

        public String getJurusan() {
            return jurusan;
        }
    }

