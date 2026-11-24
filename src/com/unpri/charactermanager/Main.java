package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.service.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();
        try {
            manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
            manager.addCharacter(new Character("Srikandi", CharacterType.WARRIOR, 6));
            manager.addCharacter(new Character("Zephyr", CharacterType.MAGE, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error tambah karakter: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
