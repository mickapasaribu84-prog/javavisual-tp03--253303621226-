# Character Manager — Sprint #3 (TP8)

## 📌 Deskripsi Proyek
Sprint #3 (TP8) ini merupakan transisi besar dari aplikasi berbasis console (TP1-TP5) menuju aplikasi berbasis **GUI (Graphical User Interface)** menggunakan **Java Swing** serta menerapkan standar arsitektur **MVC (Model-View-Controller)**.

## 🖼️ Screenshot Aplikasi (`MainWindow`)
* **Kondisi Awal (5 Karakter):**
  !output_sebelum_ubah.png
* **Kondisi Setelah Perubahan (6 Karakter & Statistik Berubah):**
  !output_setelah_ubah.png

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