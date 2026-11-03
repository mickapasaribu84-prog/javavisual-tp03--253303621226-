package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {
    // 1. Minimum 3 Warna Utama
    public static final Color COLOR_WARRIOR = new Color(152, 251, 152); // Hijau terang
    public static final Color COLOR_MAGE = new Color(135, 206, 250);    // Biru terang
    public static final Color COLOR_ROGUE = new Color(255, 182, 193);   // Pink terang
    public static final Color COLOR_ARCHER = new Color(238, 232, 170);  // Krem terang
    public static final Color COLOR_GOLD = new Color(218, 165, 32);     // Warna Emas Mini-Challenge

    // 2. Minimum 3 Font (Menggunakan Logical Font)
    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 16);
    public static final Font FONT_REGULAR = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    public static final Font FONT_HIGH_LEVEL = new Font(Font.MONOSPACED, Font.BOLD, 12); // Teks Emas & Tebal

    // 3. Minimum 1 Border
    public static final Border PADDING_BORDER = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    // 4. Method colorFor(CharacterType)
    public static Color colorFor(CharacterType type) {
        if (type == null) return Color.WHITE;
        switch (type) {
            case WARRIOR: return COLOR_WARRIOR;
            case MAGE: return COLOR_MAGE;
            case ROGUE: return COLOR_ROGUE;
            case ARCHER: return COLOR_ARCHER;
            default: return Color.WHITE;
        }
    }
}