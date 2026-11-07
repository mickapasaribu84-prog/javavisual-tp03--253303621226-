package com.unpri.charactermanager.view;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

public class AppTheme {
    public static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Biru
    public static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    public static final Font REGULAR_FONT = new Font("Arial", Font.PLAIN, 12);
    public static final Font GOLD_BOLD_FONT = new Font("Arial", Font.BOLD, 12);
    public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.LIGHT_GRAY);

    public static Color colorFor(com.unpri.charactermanager.model.CharacterType type) {
        switch (type) {
            case WARRIOR: return new Color(230, 255, 230); // Hijau muda
            case MAGE: return new Color(230, 242, 255);    // Biru muda
            case ARCHER: return new Color(255, 250, 230);  // Kuning muda
            case ROGUE: return new Color(255, 230, 230);   // Merah muda
            default: return Color.WHITE;
        }
    }
}