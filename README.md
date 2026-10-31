# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi Singkat
Aplikasi berbasis console Java berorientasi objek (OOP) ini dirancang untuk mengelola data karakter game (seperti Warrior, Mage, Archer, dan Rogue). Proyek ini mengimplementasikan konsep enkapsulasi, validasi state objek menggunakan exception, serta manajemen atribut lanjutan termasuk poin nyawa (`hitPoints`), kekuatan serangan (`attackPower`), dan energi sihir (`mana`).
**[Screenshot] (output_tp3.png)

## Struktur Folder Project
```text
CharacterManager/
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    └── CharacterType.java
```

## Informasi Mahasiswa & Link Laporan
- **Nama Lengkap:** [Micka Engelica Pasaribu]
- **NIM:** [253303621262]
- **Link Google Docs Analisis Desain:** (https://docs.google.com/document/d/1yrO1K-XPf3lqHpAszVR-DR-0uy27xzLEABE_1up2ERs/edit?usp=sharing)



# Character Manager — TP5 (CRUD & Fitur Analitik Rancangan Sendiri)

## Deskripsi Proyek & Fitur CRUD
- **Penjelasan Singkat:** Pada TP5 ini, aplikasi dikembangkan dengan menambahkan fungsionalitas lengkap operasi **CRUD (Create, Read, Update, Delete)** pada pengelolaan data karakter, serta penerapan eksperimen *reference* (acuan objek) dan validasi data.
**[Screenshot](output_tp5.png)

## ⚙️ Bagian C — Fitur Analitik Rancangan Sendiri (`findStrongest`)
- **Nama Method Baru:** `findStrongest()`
- **Rasional & Penjelasan:** 
  Method ini ditambahkan ke dalam kelas `CharacterManager` untuk mencari dan mengembalikan objek karakter yang memiliki tingkat level atau kekuatan (`attackPower`) tertinggi di dalam daftar. Method ini dirancang dengan tetap menjaga prinsip *Encapsulation* (mengembalikan salinan atau data yang aman tanpa mengekspos referensi `ArrayList` asli secara langsung) dan dilengkapi dokumentasi Javadoc singkat.

## 🔗 Informasi Mahasiswa & Link Laporan
- **Nama Lengkap:** Micka Engelica Pasaribu
- **NIM:** 253303621262
- [Link Google Docs Analisis Desain](https://docs.google.com/document/d/1-GuGZEAAyOIBXSY1C3hpibQm1w-c5SSQMT14Mx1MH-o/edit?usp=sharing)



# Character Manager — Sprint #3 (TP8)

## 📌 Deskripsi Proyek
Sprint #3 (TP8) ini merupakan transisi besar dari aplikasi berbasis console (TP1-TP5) menuju aplikasi berbasis **GUI (Graphical User Interface)** menggunakan **Java Swing** serta menerapkan standar arsitektur **MVC (Model-View-Controller)**.

## 🖼️ Screenshot Aplikasi (`MainWindow`)
- **Kondisi Awal (5 Karakter):**
  ![Screenshot Awal](output_sebelum_ubah_TP8.png)
- **Kondisi Setelah Perubahan (6 Karakter & Statistik Berubah):**
  ![Screenshot Perubahan](output_setelah_ubah_TP8.png)

## 🔄 Alur Aliran Data (MVC)
Aliran data dalam aplikasi ini berjalan secara terstruktur: 
1. `Main.java` menginisialisasi **Model** (`Character`) dan **Service/Controller** (`CharacterManager`).
2. `CharacterManager` mengelola kumpulan data karakter di dalam *ArrayList* dengan enkapsulasi yang aman.
3. `MainWindow` (**View**) meminta data dari `CharacterManager` melalui *looping* dinamis dan menampilkan antarmuka grafis ke pengguna secara aman di dalam *Event Dispatch Thread* (`SwingUtilities.invokeLater`).

## 📋 Daftar Karakter
1. **Arjuna** — Type: `WARRIOR`, Level: 5 (Karakter pejuang utama)
2. **Merlin** — Type: `MAGE`, Level: 3 (Karakter penyihir pengendali mana)
3. **Robin** — Type: `ARCHER`, Level: 4 (Karakter pemanah jarak jauh)
4. **Gatotkaca** — Type: `WARRIOR`, Level: 7 (Karakter tank penahan serangan tinggi)
5. **Shadow** — Type: `ROGUE`, Level: 6 (Karakter assassin gesit)
6. **Zilong** — Type: `WARRIOR`, Level: 10 (Karakter pejuang tambahan level tinggi)

## 🔗 Tautan Analisis Desain (Google Docs)
Analisis mendalam mengenai GUI, *Event-Driven*, dan prinsip arsitektur MVC dapat diakses melalui tautan berikut:
[Google Docs - Analisis GUI & MVC TP8](https://docs.google.com/document/d/15R7Eg3ea84QBOFNA2BMvkpym7Gk6FiCPGKG7yd8zrJ8/edit?usp=sharing)



## TP10: Character Manager Sprint #4 (Theming & MVC Analysis)

- **Screenshot Sesudah (v0.4 - AppTheme):** 
  *(screenshot hasil tampilan aplikasi yang terbaru sudah disimpan di folder project dengan nama `output_TP10.png`)*

- **Penjelasan Singkat:**
  Seluruh properti visual seperti warna, font, dan border dipindahkan secara terpusat ke kelas `AppTheme` pada layer **View**. Hal ini memastikan bahwa layer **Model** (`Character.java`) tetap murni tanpa terikat pustaka GUI (`java.awt`).

- **Properti Tambahan (Mini-Challenge & Bonus):**
  1. *Highlight Level Tinggi:* Karakter dengan level $\ge 5$ otomatis tampil dengan teks tebal berwarna emas (`AppTheme.GOLD_HIGHLIGHT`).
  2. *Warna Role Dinamis:* Kartu karakter memiliki warna latar belakang berbeda berdasarkan *role* (Warrior, Mage, Archer) menggunakan `AppTheme.colorFor()`.

- **[Link Google Docs Analisis](https://docs.google.com/document/d/1RxpGbGyFrAPlwNqKqCyKHcAZr1LCiqrgrbmHHJVzlfQ/edit?usp=sharing)