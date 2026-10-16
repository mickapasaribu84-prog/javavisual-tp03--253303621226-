package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hp;
    private int atk;
    private int mana;
    private boolean isAlive;

    // Constructor 3 parameter
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

    // Constructor lengkap (7 parameter)
    public Character(String name, CharacterType type, int level, int hp, int atk, int mana, boolean isAlive) {
        if (level < 0) {
            throw new IllegalArgumentException("Level tidak boleh negatif");
        }
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.atk = atk;
        this.mana = mana;
        this.isAlive = isAlive;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    @Override
    public String toString() {
        return "Character{id=0, name='" + name + "', type=" + type + ", level=" + level + ", hp=" + hp + ", atk=" + atk + ", mana=" + mana + ", isAlive=" + isAlive + "}";
    }
}