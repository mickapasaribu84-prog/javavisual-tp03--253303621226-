package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.service.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private CharacterManager manager;
    private JPanel characterPanel;
    private JLabel lblAvgLevel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        // Pengaturan Jendela Utama (JFrame)
        setTitle("Character Manager — Sprint #3 (TP8)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout utama menggunakan BorderLayout
        setLayout(new BorderLayout());

        // Header Title
        JLabel lblTitle = new JLabel("Daftar Karakter Game", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        // Panel tengah untuk menampung daftar karakter secara dinamis
        characterPanel = new JPanel();
        characterPanel.setLayout(new BoxLayout(characterPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk statistik (Mini-Challenge: Rata-rata Level)
        lblAvgLevel = new JLabel();
        lblAvgLevel.setFont(new Font("Arial", Font.BOLD, 12));
        lblAvgLevel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblAvgLevel, BorderLayout.SOUTH);

        // Muat data karakter ke dalam GUI
        refreshData();
    }

    // Method untuk menampilkan data karakter secara dinamis (Looping) dan statistik
    public void refreshData() {
        characterPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();
        for (Character c : characters) {
            JPanel card = new JPanel(new FlowLayout(FlowLayout.LEFT));
            card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            card.add(new JLabel("• " + c.toString()));
            characterPanel.add(card);
        }

        // Update nilai statistik rata-rata level
        lblAvgLevel.setText("Rata-rata Level Karakter: " + manager.getAverageLevel());

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}