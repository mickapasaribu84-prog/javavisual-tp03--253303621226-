package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {
    // 3 Warna Utama
    public static final Color BG_DARK = Color.decode("#daf416");
    public static final Color ACCENT_BLUE = Color.decode("#e6a2e0");
    public static final Color GOLD_HIGHLIGHT = Color.decode("#21201e");
    
    // 3 Font (Menggunakan Logical Font untuk keamanan lintas platform)
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 14);
    public static final Font FONT_MONO = new Font("Monospaced", Font.PLAIN, 12);
    
    // 1 Border Standar
    public static final Border PADDING_BORDER = BorderFactory.createEmptyBorder(8, 12, 8, 12);
    
    // Konstanta untuk Mini-Challenge Level
    public static final int MIN_LEVEL_HIGHLIGHT = 5;

    // Method colorFor untuk memetakan role ke warna (View responsibility)
    public static Color colorFor(String role) {
        if (role == null) return ACCENT_BLUE;
        switch (role.toUpperCase()) {
            case "WARRIOR": return Color.decode("#9eee78");
            case "MAGE": return Color.decode("#8ebbf7");
            case "ARCHER": return Color.decode("#548bde");
            default: return ACCENT_BLUE;
        }
    }
}