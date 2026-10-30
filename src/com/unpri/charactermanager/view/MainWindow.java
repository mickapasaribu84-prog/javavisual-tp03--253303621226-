package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.service.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private CharacterManager manager;
    private JPanel characterListPanel;
    private JLabel avgLevelLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager — Sprint #4 (TP10)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Judul Atas menggunakan AppTheme.FONT_TITLE
        JLabel titleLabel = new JLabel("Daftar Karakter Game", JLabel.CENTER);
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Panel untuk menampung list karakter
        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));

        // ScrollPane vertikal saja
        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Label Statistik di Bawah menggunakan AppTheme.FONT_BODY
        avgLevelLabel = new JLabel();
        avgLevelLabel.setFont(AppTheme.FONT_BODY);
        avgLevelLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(avgLevelLabel, BorderLayout.SOUTH);

        // Muat data awal ke GUI
        refreshData();
        
        // pack() agar ukuran jendela pas, lalu posisikan ke tengah
        pack();
        setLocationRelativeTo(null);
    }

    public void refreshData() {
        characterListPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();
        for (Character c : characters) {
            // Membuat panel kartu untuk tiap karakter
            JPanel card = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            card.setBorder(BorderFactory.createCompoundBorder(
                AppTheme.PADDING_BORDER,
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
            ));
            
            // Menggunakan setOpaque(true) agar background warna role muncul
            card.setOpaque(true);
            card.setBackground(AppTheme.colorFor(c.getType().toString()));

            // Label informasi karakter
            JLabel infoLabel = new JLabel(c.toString());
            infoLabel.setFont(AppTheme.FONT_MONO);
            infoLabel.setForeground(Color.WHITE); // Teks putih agar kontras dengan warna kartu

            // Mini-Challenge: Level >= 5 tampil dengan teks emas dan tebal
            if (c.getLevel() >= AppTheme.MIN_LEVEL_HIGHLIGHT) {
                infoLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
                infoLabel.setForeground(AppTheme.GOLD_HIGHLIGHT);
            }

            card.add(infoLabel);
            characterListPanel.add(card);
        }

        // Format angka rata-rata level menjadi 2 desimal
        double avg = manager.calculateAverageLevel();
        avgLevelLabel.setText(String.format("📊 Rata-rata Level Karakter: %.2f", avg));

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}