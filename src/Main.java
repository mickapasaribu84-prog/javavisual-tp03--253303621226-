import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Character Manager v0.1 & Mini-Challenge ===\n");

        // Membuat karakter dasar
        Character hero = new Character("Arjuna", CharacterType.WARRIOR, 5);
        System.out.println(hero);

        // Demo level up
        hero.setLevel(hero.getLevel() + 1);
        System.out.println("Setelah level up: " + hero);

        System.out.println("\n--- Pengujian Ekstensi Fitur Mandiri (Mana & isAlive) ---");
        // Membuat karakter baru dengan constructor atau set mana
        Character wizard = new Character(2, "Merlin", CharacterType.MAGE, 3, 120, 30, 80);
        System.out.println(wizard);
        System.out.println("Status Hidup (" + wizard.getName() + "): " + wizard.isAlive());

        // Menguji validasi exception mana negatif
        try {
            wizard.setMana(-20);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi Berhasil Menangkap Error: " + e.getMessage());
        }
    }
}