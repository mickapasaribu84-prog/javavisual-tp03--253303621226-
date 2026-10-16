package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.service.CharacterManager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager Sprint #2 (TP5) ===");
        CharacterManager manager = new CharacterManager();

        // 1. Uji Tambah & Validasi Duplikat
        System.out.println("\n--- 1. Uji Tambah & Validasi Duplikat ---");
        try {
            manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
            
            // Coba duplikat
            manager.addCharacter(new Character("arjuna", CharacterType.ROGUE, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal (Tertolak dengan benar): " + e.getMessage());
        }

        // 2. Daftar Seluruh Karakter
        System.out.println("\n--- 2. Daftar Seluruh Karakter ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(" - " + c);
        }
        System.out.println("Total Karakter: " + manager.getTotalCharacters());

        // 3. Uji Mini-Challenge (getAverageLevel & findByType)
        System.out.println("\n--- 3. Uji Mini-Challenge ---");
        System.out.println("Rata-rata Level Karakter: " + manager.getAverageLevel());

        System.out.println("Pencarian Karakter Bertipe MAGE:");
        ArrayList<Character> mages = manager.findByType(CharacterType.MAGE);
        for (Character m : mages) {
            System.out.println(" - " + m);
        }

        // 4. Uji Fitur Mandiri (renameCharacter dengan Validasi Bentrok)
        System.out.println("\n--- 4. Uji Fitur Mandiri (renameCharacter) ---");
        System.out.println("Mencoba rename 'Merlin' menjadi 'Arjuna' (Bentrok, harus gagal):");
        manager.renameCharacter("Merlin", "Arjuna");

        System.out.println("\nMengubah nama 'Robin' menjadi 'Legolas' (Berhasil):");
        if (manager.renameCharacter("Robin", "Legolas")) {
            System.out.println("Berhasil rename Robin -> Legolas!");
        }

        // 5. Daftar Karakter Akhir
        System.out.println("\n--- 5. Daftar Karakter Akhir ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(" - " + c);
        }
    }
}