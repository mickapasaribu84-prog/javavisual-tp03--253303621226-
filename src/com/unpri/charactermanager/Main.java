package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.service.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager Sprint #3 (TP8 - GUI) ===");

        // 1. Inisialisasi Service Manager
        CharacterManager manager = new CharacterManager();

        // 2. Menambahkan Karakter (Total minimal 5 karakter sesuai instruksi TP8)
        try {
            manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
            // Tambahan 2 karakter baru untuk TP8:
            manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7)); // Tank/Warrior level tinggi
            manager.addCharacter(new Character("Shadow", CharacterType.ROGUE, 6));     // Rogue gesit
            manager.addCharacter(new Character("Zilong", CharacterType.WARRIOR, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambah karakter: " + e.getMessage());
        }

        // 3. Menjalankan GUI MainWindow menggunakan SwingUtilities.invokeLater (Aman untuk EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow window = new MainWindow(manager);
                window.setVisible(true);
            }
        });
    }
}