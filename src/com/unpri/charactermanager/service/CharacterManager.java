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
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(character.getName())) {
                throw new IllegalArgumentException(character.getName());
            }
        }
        characters.add(character);
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