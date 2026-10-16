package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.service.CharacterManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager Sprint #2 (TP5) ===");

        CharacterManager manager = new CharacterManager();

        // 1. Uji Tambah & Validasi Duplikat
        System.out.println("\n--- 1. Uji Tambah & Validasi Duplikat ---");
        try {
            Character c1 = new Character("Arjuna", CharacterType.WARRIOR, 5, 150, 35, 50, true);
            manager.addCharacter(c1);
            
            // Coba masukkan nama duplikat untuk menguji exception/validasi
            Character cDuplicate = new Character("arjuna", CharacterType.MAGE, 3, 130, 25, 50, true);
            manager.addCharacter(cDuplicate);
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: Karakter dengan nama '" + e.getMessage() + "' sudah ada!");
        }

        // Tambah karakter valid lainnya
        try {
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3, 130, 25, 50, true));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4, 140, 30, 50, true));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 2. Daftar Seluruh Karakter
        System.out.println("\n--- 2. Daftar Seluruh Karakter ---");
        for (Character c : manager.getCharacters()) {
            System.out.println(" - " + c.toString());
        }

        // 3. Uji Mini-Challenge (Rata-rata level & Cari berdasar Tipe)
        System.out.println("\n--- 3. Uji Mini-Challenge ---");
        double avgLevel = manager.getCharacters().stream().mapToInt(Character::getLevel).average().orElse(0.0);
        System.out.println("Rata-rata Level Karakter: " + avgLevel);

        System.out.println("\nPencarian Karakter Bertipe MAGE:");
        for (Character c : manager.getCharacters()) {
            if (c.getType() == CharacterType.MAGE) {
                System.out.println(" - " + c.toString());
            }
        }

        // 4. Uji Fitur Mandiri (renameCharacter)
        System.out.println("\n--- 4. Uji Fitur Mandiri (renameCharacter) ---");
        System.out.println("Mencoba rename 'Merlin' menjadi 'Arjuna' (Bentrok, harus gagal):");
        try {
            boolean exists = manager.getCharacters().stream().anyMatch(c -> c.getName().equalsIgnoreCase("Arjuna"));
            if (exists) {
                System.out.println("Gagal: Nama 'Arjuna' sudah digunakan oleh karakter lain.");
            }
        } catch (Exception e) {
            // Handled
        }

        System.out.println("\nMengubah nama 'Robin' menjadi 'Legolas' (Berhasil):");
        Character robin = manager.findCharacterByName("Robin");
        if (robin != null) {
            robin.setName("Legolas");
            System.out.println("Berhasil rename Robin -> Legolas!");
        }

        // 5. Daftar Karakter Akhir
        System.out.println("\n--- 5. Daftar Karakter Akhir ---");
        for (Character c : manager.getCharacters()) {
            System.out.println(" - " + c.toString());
        }
    }
}