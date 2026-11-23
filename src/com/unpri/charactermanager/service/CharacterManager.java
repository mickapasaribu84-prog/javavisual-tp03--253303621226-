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

    // --- Bagian A: Core Methods ---
    public void addCharacter(Character c) {
        if (c == null) throw new IllegalArgumentException("Karakter tidak boleh null.");
        for (Character existing : characters) {
            if (existing.equals(c)) {
                throw new IllegalArgumentException("Karakter dengan nama '" + c.getName() + "' sudah ada!");
            }
        }
        characters.add(c);
    }

    public Character findByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characters.remove(c);
            return true;
        }
        return false;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    // Defensive copy: mengembalikan salinan list, bukan referensi asli
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // --- Bagian B: Mini-Challenge ---
    public double getAverageLevel() {
        if (characters.isEmpty()) return 0.0;
        int total = 0;
        for (Character c : characters) {
            total += c.getLevel();
        }
        return (double) total / characters.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    // --- Bagian C: Fitur Mandiri (renameCharacter dengan validasi bentrok) ---
    /**
     * Mengubah nama karakter dengan validasi agar tidak ada nama yang duplikat/bentrok.
     * @param oldName Nama karakter lama yang ingin diubah
     * @param newName Nama karakter baru
     * @return true jika berhasil, false jika gagal (nama lama tidak ketemu atau nama baru sudah dipakai)
     */
    public boolean renameCharacter(String oldName, String newName) {
        Character target = findByName(oldName);
        if (target == null) {
            System.out.println("Gagal: Karakter '" + oldName + "' tidak ditemukan.");
            return false;
        }
        if (findByName(newName) != null) {
            System.out.println("Gagal: Nama '" + newName + "' sudah digunakan oleh karakter lain.");
            return false;
        }
        target.setName(newName);
        return true;
    }
}