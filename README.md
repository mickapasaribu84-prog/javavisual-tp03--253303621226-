# Character Manager â€” TP3 (Java Visual SIH-6406)

## Deskripsi Singkat
Aplikasi berbasis console Java berorientasi objek (OOP) ini dirancang untuk mengelola data karakter game (seperti Warrior, Mage, Archer, dan Rogue). Proyek ini mengimplementasikan konsep enkapsulasi, validasi state objek menggunakan exception, serta manajemen atribut lanjutan termasuk poin nyawa (`hitPoints`), kekuatan serangan (`attackPower`), dan energi sihir (`mana`).
![Screenshot](output_TP3.png)

## Struktur Folder Project
```text
CharacterManager/
â””â”€â”€ src/
    â”œâ”€â”€ Main.java
    â””â”€â”€ com/
        â””â”€â”€ unpri/
            â””â”€â”€ charactermanager/
                â””â”€â”€ model/
                    â”œâ”€â”€ Character.java
                    â””â”€â”€ CharacterType.java
```

## Informasi Mahasiswa & Link Laporan
- **Nama Lengkap:** [Micka Engelica Pasaribu]
- **NIM:** [253303621262]
- **Link Google Docs Analisis Desain:** (https://docs.google.com/document/d/1yrO1K-XPf3lqHpAszVR-DR-0uy27xzLEABE_1up2ERs/edit?usp=sharing)



# Character Manager â€” TP5 (CRUD & Fitur Analitik Rancangan Sendiri)

## Deskripsi Proyek & Fitur CRUD
- **Penjelasan Singkat:** Pada TP5 ini, aplikasi dikembangkan dengan menambahkan fungsionalitas lengkap operasi **CRUD (Create, Read, Update, Delete)** pada pengelolaan data karakter, serta penerapan eksperimen *reference* (acuan objek) dan validasi data.
![Screenshot](output_TP5.png)

## âš™ï¸ Bagian C â€” Fitur Analitik Rancangan Sendiri (`findStrongest`)
- **Nama Method Baru:** `findStrongest()`
- **Rasional & Penjelasan:** 
  Method ini ditambahkan ke dalam kelas `CharacterManager` untuk mencari dan mengembalikan objek karakter yang memiliki tingkat level atau kekuatan (`attackPower`) tertinggi di dalam daftar. Method ini dirancang dengan tetap menjaga prinsip *Encapsulation* (mengembalikan salinan atau data yang aman tanpa mengekspos referensi `ArrayList` asli secara langsung) dan dilengkapi dokumentasi Javadoc singkat.

## ðŸ”— Informasi Mahasiswa & Link Laporan
- **Nama Lengkap:** Micka Engelica Pasaribu
- **NIM:** 253303621262
- [Link Google Docs Analisis Desain](https://docs.google.com/document/d/1-GuGZEAAyOIBXSY1C3hpibQm1w-c5SSQMT14Mx1MH-o/edit?usp=sharing)



# Character Manager â€” Sprint #3 (TP8)

## ðŸ“Œ Deskripsi Proyek
Sprint #3 (TP8) ini merupakan transisi besar dari aplikasi berbasis console (TP1-TP5) menuju aplikasi berbasis **GUI (Graphical User Interface)** menggunakan **Java Swing** serta menerapkan standar arsitektur **MVC (Model-View-Controller)**.

## ðŸ–¼ï¸ Screenshot Aplikasi (`MainWindow`)
- **Kondisi Awal (5 Karakter):**
  ![Screenshot Awal](output_sebelum_diubah_TP8.png)
- **Kondisi Setelah Perubahan (6 Karakter & Statistik Berubah):**
  ![Screenshot Perubahan](output_setelah_diubah_TP8.png)

## ðŸ”„ Alur Aliran Data (MVC)
Aliran data dalam aplikasi ini berjalan secara terstruktur: 
1. `Main.java` menginisialisasi **Model** (`Character`) dan **Service/Controller** (`CharacterManager`).
2. `CharacterManager` mengelola kumpulan data karakter di dalam *ArrayList* dengan enkapsulasi yang aman.
3. `MainWindow` (**View**) meminta data dari `CharacterManager` melalui *looping* dinamis dan menampilkan antarmuka grafis ke pengguna secara aman di dalam *Event Dispatch Thread* (`SwingUtilities.invokeLater`).

## ðŸ“‹ Daftar Karakter
1. **Arjuna** â€” Type: `WARRIOR`, Level: 5 (Karakter pejuang utama)
2. **Merlin** â€” Type: `MAGE`, Level: 3 (Karakter penyihir pengendali mana)
3. **Robin** â€” Type: `ARCHER`, Level: 4 (Karakter pemanah jarak jauh)
4. **Gatotkaca** â€” Type: `WARRIOR`, Level: 7 (Karakter tank penahan serangan tinggi)
5. **Shadow** â€” Type: `ROGUE`, Level: 6 (Karakter assassin gesit)
6. **Zilong** â€” Type: `WARRIOR`, Level: 10 (Karakter pejuang tambahan level tinggi)

## ðŸ”— Tautan Analisis Desain (Google Docs)
Analisis mendalam mengenai GUI, *Event-Driven*, dan prinsip arsitektur MVC dapat diakses melalui tautan berikut:
[Google Docs - Analisis GUI & MVC TP8](https://docs.google.com/document/d/15R7Eg3ea84QBOFNA2BMvkpym7Gk6FiCPGKG7yd8zrJ8/edit?usp=sharing)



## TP10: Character Manager Sprint #4 (Theming & MVC Analysis)

- **Screenshot Sebelum (v0.3):**  
  <img src="./output_sebelum_diubah_TP8.png" width="500" alt="Screenshot Sebelum v0.3">

- **Screenshot Sesudah (v0.4 / AppTheme):**  
  <img src="./output_TP10.png" width="500" alt="Screenshot Sesudah v0.4"> 

- **Penjelasan Singkat:**
  Seluruh properti visual seperti warna, font, dan border dipindahkan secara terpusat ke kelas `AppTheme` pada layer **View**. Hal ini memastikan bahwa layer **Model** (`Character.java`) tetap murni tanpa terikat pustaka GUI (`java.awt`).

- **Properti Tambahan (Mini-Challenge & Bonus):**
  1. *Highlight Level Tinggi:* Karakter dengan level $\ge 5$ otomatis tampil dengan teks tebal berwarna emas (`AppTheme.GOLD_HIGHLIGHT`).
  2. *Warna Role Dinamis:* Kartu karakter memiliki warna latar belakang berbeda berdasarkan *role* (Warrior, Mage, Archer) menggunakan `AppTheme.colorFor()`.

- **[Link Google Docs Analisis](https://docs.google.com/document/d/1RxpGbGyFrAPlwNqKqCyKHcAZr1LCiqrgrbmHHJVzlfQ/edit?usp=sharing)



# TP12 â€” Layout Management & Panel Bersarang (Sprint #5)

## ðŸ“ Section TP12: Wireframe / Diagram Struktur Layout

    +-------------------------------------------------------------------+
    |                        NORTH: Header Panel                        |
    +---------------------------------------------------+---------------+
    |                                                   |               |
    |                                                   |  EAST:        |
    |                  CENTER:                          |  Legenda      |
    |              JScrollPane                          |  Role         |
    |         (Panel Daftar Karakter)                   |  (BoxLayout   |
    |                                                   |   Y_AXIS)     |
    |                                                   |               |
    +---------------------------------------------------+---------------+
    |                  SOUTH: Action Panel (FlowLayout)                 |
    |             [Tambah Karakter] [Refresh Data] [Filter Role]        |
    +---------------------------------------------------+---------------+
    |  SOUTH: Status Bar (BorderLayout)                                 |
    |  Status: Berjalan Normal | Total Karakter: 14                v0.5 |
    +---------------------------------------------------+---------------+

---

## ðŸ“¸ Dokumentasi 3 Screenshot Kondisi Jendela

* **Ukuran Awal (*Initial State*):**  
  ![Ukuran Awal](output_tp12_awal.png)

* **Jendela Dilebarkan (*Expanded Window*):**  
  ![Jendela Dilebarkan](output_tp12_lebar.png)

* **Jendela Dikecilkan (*Minimized Window / Scrollbar Tampak*):**  
  ![Jendela Dikecilkan](output_tp12_kecil.png)

---

## ðŸ“Š Tabel Pengamatan Resize (Prediksi vs Hasil)

| Kondisi Jendela | Prediksi Perilaku Layout | Hasil Pengamatan Aktual |
| :--- | :--- | :--- |
| **Ukuran Awal** | Header di `NORTH`, daftar kartu karakter di `CENTER`, legenda di `EAST`, panel tombol aksi dan status bar di `SOUTH` tampil proporsional. | Sesuai prediksi, seluruh komponen tertata rapi pada wilayah *BorderLayout* masing-masing. |
| **Dilebarkan** | Area daftar karakter dan header meregang secara horizontal, sementara panel legenda di `EAST` mempertahankan lebar tetapnya. | Sesuai prediksi, layout responsif secara konsisten tanpa ada komponen yang rusak. |
| **Dikecilkan** | Area daftar menyempit dan `JScrollPane` otomatis mengaktifkan bilah gulir (*scrollbar*) vertikal dan horizontal. | Sesuai prediksi, *scrollbar* aktif dengan sempurna sehingga seluruh konten data tetap dapat diakses. |

---

## ðŸ—ï¸ Penjelasan Struktur Panel Bersarang
Aplikasi ini menerapkan arsitektur panel bersarang (*nested panels*) berbasis **`BorderLayout`** sebagai kerangka utama kontainer `JFrame`. Pada wilayah `CENTER`, daftar kartu karakter dibungkus oleh `JPanel` berorientasi vertikal (`BoxLayout`) yang dimasukkan ke dalam **`JScrollPane`** untuk menyediakan fitur pengguliran otomatis. Wilayah `EAST` menampung panel legenda tipe karakter menggunakan `BoxLayout` (sumbu `Y_AXIS`), sedangkan wilayah `SOUTH` mengintegrasikan panel tombol kontrol ber-layout **`FlowLayout`** dan bar status ber-layout **`BorderLayout`**. Desain hirarki ini memastikan setiap bagian antarmuka mengelola tata letaknya secara terisolasi, rapi, dan fleksibel.

---

## âš™ï¸ Alasan Panel Tambahan & Layout yang Ditolak

* **Panel Tambahan & Layout Dipilih (`FlowLayout`):**  
  Saya menambahkan panel tombol aksi (*placeholder*) di wilayah `SOUTH` tepat di atas bar status menggunakan **`FlowLayout`**. Layout ini dipilih karena sangat ideal untuk menyusun tombol kontrol secara horizontal di tengah secara alami tanpa memaksakan ukuran tombol menjadi melar secara kaku.
* **Layout yang Ditolak (`GridLayout`):**  
  Saya menolak penggunaan `GridLayout` untuk panel tombol aksi ini karena `GridLayout` akan memaksa setiap tombol memiliki ukuran lebar dan tinggi yang seragam serta meregang penuh memenuhi area kontainer, sehingga tampilannya terlihat tidak proporsional dan kurang natural.

---

## ðŸ”— Link Google Docs (Analisis Bagian D)

Tautan dokumentasi analisis lengkap (Bagian D â€” minimal 500 kata):  
ðŸ‘‰ **[Link Google Docs Analisis Layout & MVC TP12](https://docs.google.com/document/d/1PG-sFx65DJDcDHFUAvyF3hKqsU9fOQjgY-5h5yJhGjA/edit?usp=sharing)**



## TP14 Manajer Karakter Sprint #6

### Screenshot Pengujian Form

1. **Error Nama Kosong:** ![Error Nama Kosong](tp14-error-kosong.png)
2. **Error Nama Duplikat:** ![Error Nama Duplikat](tp14-error-duplikat.png)
3. **Sukses dengan Kartu Baru:** ![Sukses Kartu Baru](tp14-suksestersimpan-kartu.png)

### Tabel Uji Validasi (Bagian B)
| No | Input | Hasil Diharapkan | Hasil Nyata | Lapisan yang Menangkap |
| :--- | :--- | :--- | :--- | :--- |
| 1 | Nama: `""`, Role: `WARRIOR`, Level: `1` | Ditolak: `"Nama wajib diisi"` | *(sesuai hasil uji)* | View (`validateName`) |
| 2 | Nama: `"   "`, Role: `WARRIOR`, Level: `1` | Ditolak: `"Nama wajib diisi"` | *(sesuai hasil uji)* | View (`validateName`) |
| 3 | Nama: `"Li"`, Role: `WARRIOR`, Level: `1` | Ditolak: `"Nama harus 3-20 karakter"` | *(sesuai hasil uji)* | View (`validateName`) |
| 4 | Nama: `"Gandalf  Putih"`, Role: `MAGE`, Level: `10` | Ditolak: `"Nama tidak boleh mengandung spasi ganda"` | *(sesuai hasil uji)* | View (`validateName`) |
| 5 | Nama: `"Hero123"`, Role: `WARRIOR`, Level: `1` | Ditolak: `"Nama hanya huruf dan spasi"` | *(sesuai hasil uji)* | View (`validateName`) |
| 6 | Nama duplikat (misal `"Arjuna"`), Role: `WARRIOR`, Level: `1` | Ditolak: `"Nama sudah dipakai"` | *(sesuai hasil uji)* | View (`validateName` / `isNameTaken`) |
| 7 | Nama: `"Merlin"`, Role: `MAGE`, Level: `65` | Ditolak: `"MAGE maksimal level 60"` | *(sesuai hasil uji)* | Model (`Character`) |
| 8 | Tambah karakter ke-21 saat sudah ada 20 karakter | Ditolak: `"Kapasitas karakter penuh (maksimal 20)"` | *(sesuai hasil uji)* | Model (`CharacterManager`) |

**Catatan Perbedaan & Perbaikan:**
* Jika ada baris dengan hasil nyata berbeda dari harapan, tulis di sini kasusnya, penyebabnya, dan perbaikan yang dilakukan (misalnya `[]` jika seluruh 8 kasus sudah sesuai harapan).

### Kompromi Sementara
Pada tahap ini, handler tombol simpan dan `Enter` pada `nameField` masih menggunakan `ActionListener` minimal yang memanggil `onSave()` secara langsung. Pemanggilan `manager.addCharacter(...)` juga masih dilakukan langsung dari `CharacterFormPanel` melalui objek `CharacterManager` yang diinjeksikan agar alur validasi dan pembaruan daftar cepat terhubung. Kompromi ini dipilih supaya fokus utama tetap pada kejelasan pemisahan aturan View vs. Model sebelum diperhalus pada iterasi berikutnya.

### Esai Bagian D (Google Docs)
[Link Google Docs Bagian D](https://docs.google.com/document/d/12qTgE9cTWLQBbtKdTEHmTZvPOyBmdu66WxyBiQsy-0Y/edit?usp=sharing)