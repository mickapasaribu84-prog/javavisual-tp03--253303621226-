package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hp;
    private int atk;
    private int mana;
    private boolean isAlive;

    public Character(String name, CharacterType type, int level) {
        if (level < 0) {
            throw new IllegalArgumentException("Level tidak boleh negatif");
        }
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = 100 + (level * 10);
        this.atk = 20 + (level * 3);
        this.mana = 50;
        this.isAlive = true;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return name.equalsIgnoreCase(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "Character{name='" + name + "', type=" + type + ", level=" + level + ", hp=" + hp + ", atk=" + atk + ", mana=" + mana + ", isAlive=" + isAlive + "}";
    }
}