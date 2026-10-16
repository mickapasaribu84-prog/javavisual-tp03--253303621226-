package com.unpri.charactermanager.service;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characters;

    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Karakter tidak boleh null.");
        }
        characters.add(character);
        System.out.println("Karakter " + character.getName() + " berhasil ditambahkan.");
    }

    public void displayAllCharacters() {
        if (characters.isEmpty()) {
            System.out.println("Belum ada karakter yang terdaftar.");
            return;
        }
        System.out.println("\n=== DAFTAR KARAKTER GAME ===");
        for (Character c : characters) {
            System.out.println(c.toString());
        }
    }

    public Character findCharacterByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}