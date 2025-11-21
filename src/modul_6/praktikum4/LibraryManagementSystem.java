package modul_6.praktikum4;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static ArrayList<LibraryItem> libraryItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSampleData();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayAllItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    borrowItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
                    return;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- SISTEM MANAJEMEN PERPUSTAKAAN ---");
        System.out.println("1. Tampilkan Semua Item");
        System.out.println("2. Pinjam Item");
        System.out.println("3. Kembalikan Item");
        System.out.println("4. Tambah Item Baru");
        System.out.println("5. Cari Item");
        System.out.println("6. Keluar");
        System.out.println("Pilih menu: ");
    }

    // Perhatikan: Method initializeSampleData() ada di gambar pertama,
    // tetapi pemanggilan method addItem() dan returnItem() di main() sepertinya ada kesalahan nomor di gambar.
    // Berdasarkan menu yang ditampilkan:
    // 2. Pinjam Item -> borrowItem()
    // 3. Kembalikan Item -> returnItem()
    // 4. Tambah Item Baru -> addItem()
    //
    // Saya akan menyalin implementasi di gambar sesuai urutan (meski urutan di main() tidak sesuai dengan displayMenu):
    // Kasus 2: displayAllItems() -> seharusnya borrowItem()
    // Kasus 3: borrowItem() -> seharusnya returnItem()
    // Kasus 4: returnItem() -> seharusnya addItem()
    // Kasus 5: searchItem() -> sudah benar

    private static void initializeSampleData() {
        libraryItems.add(new Book("B001", "Pemrograman Java", 2023, "Budi Santoso", "978-1234567890", 350));
        libraryItems.add(new Book("B002", "Struktur Data", 2022, "Hari Bask", "978-0987654321", 280));
        libraryItems.add(new Magazine("M001", "National Geographic", 2023, "PT Majalah", 244, "Sains"));
        libraryItems.add(new DVD("D001", "The Java Documentary", 2023, "John Programmer", 120, "Edukasi"));
    }

    private static void displayAllItems() {
        System.out.println("\n--- DAFTAR SEMUA ITEM PERPUSTAKAAN ---");
        for (LibraryItem item : libraryItems) {
            item.displayInfo();
        }
    }

    private static void borrowItem() {
        System.out.print("Masukkan ID item yang ingin dipinjam: ");
        String itemId = scanner.nextLine();

        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                item.borrowItem();
                return;
            }
        }

        System.out.println("Item dengan ID " + itemId + " tidak ditemukan!");
    }

    private static void returnItem() {
        System.out.print("Masukkan ID item yang ingin dikembalikan: ");
        String itemId = scanner.nextLine();

        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                item.returnItem();
                return;
            }
        }

        System.out.println("Item dengan ID " + itemId + " tidak ditemukan!");
    }

    // --- Bagian dari Gambar Kedua ---

    private static void addItem() {
        System.out.println("\n--- TAMBAH ITEM BARU ---");
        System.out.println("1. Buku");
        System.out.println("2. Majalah");
        System.out.println("3. DVD");
        System.out.print("Pilih Jenis Item: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("ID Item: ");
        String itemId = scanner.nextLine();
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("Tahun: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (type) {
            case 1:
                System.out.print("Penulis: ");
                String author = scanner.nextLine();
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Jumlah Halaman: ");
                int pages = scanner.nextInt();
                scanner.nextLine();
                libraryItems.add(new Book(itemId, title, year, author, isbn, pages));
                break;
            case 2:
                System.out.print("Penerbit: ");
                String publisher = scanner.nextLine();
                System.out.print("Edisi: ");
                int issue = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Kategori: ");
                String category = scanner.nextLine();
                libraryItems.add(new Magazine(itemId, title, year, publisher, issue, category));
                break;
            case 3:
                System.out.print("Sutradara: ");
                String director = scanner.nextLine();
                System.out.print("Durasi (menit): ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                libraryItems.add(new DVD(itemId, title, year, director, duration, genre));
                break;
            default:
                System.out.println("Jenis Item tidak valid!");
                return;
        }

        System.out.println("Item Berhasil ditambahkan!");
    }

    private static void searchItem() {
        System.out.print("Masukkan kata kunci pencarian (judul/penulis): ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n--- HASIL PENCARIAN ---");
        boolean found = false;

        for (LibraryItem item : libraryItems) {
            String titleLower = item.getTitle().toLowerCase();

                        String searchString = titleLower;
            if (item instanceof Book) {
                                if (titleLower.contains(keyword)) {
                    item.displayInfo();
                    found = true;
                }
            } else {
                if (titleLower.contains(keyword)) {
                    item.displayInfo();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Tidak ada item yang sesuai dengan pencarian.");
        }
    }
}