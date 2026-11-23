package com.unpri.charactermanager.service;

import com.unpri.charactermanager.model.Character;
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
    }

    public List<Character> getAllCharacters() {
        return characters;
    }

    // Method untuk menghitung rata-rata level karakter (untuk statistik GUI)
    public double calculateAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }
        
        int totalLevel = 0;
        for (Character c : characters) {
            totalLevel += c.getLevel();
        }
        
        return (double) totalLevel / characters.size();
    }
}