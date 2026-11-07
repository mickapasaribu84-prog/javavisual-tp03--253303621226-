package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.service.CharacterManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JPanel characterListPanel;
    private JLabel statusLabel;

    public MainWindow(CharacterManager characterManager) {
        this.characterManager = characterManager;
        setTitle("Character Manager - Sprint #5 (TP12)");
        setSize(750, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Root Layout menggunakan BorderLayout
        setLayout(new BorderLayout(10, 10));

        // --- WILAYAH NORTH: Header ---
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AppTheme.PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("Daftar Karakter Game (Layout v0.5)");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(AppTheme.TITLE_FONT);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // --- WILAYAH CENTER: Daftar Karakter (JScrollPane) ---
        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));
        characterListPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        loadCharacters(); // Memuat minimal 8 karakter

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setPreferredSize(new Dimension(450, 350));
        add(scrollPane, BorderLayout.CENTER);

        // --- WILAYAH EAST: Legenda (BoxLayout Y_AXIS) ---
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS));
        legendPanel.setBorder(BorderFactory.createTitledBorder("Legenda Role"));
        legendPanel.setPreferredSize(new Dimension(160, 0));

        legendPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        for (CharacterType type : CharacterType.values()) {
            JLabel typeLbl = new JLabel("• " + type.name());
            typeLbl.setFont(AppTheme.REGULAR_FONT);
            typeLbl.setBorder(new EmptyBorder(5, 10, 5, 10));
            legendPanel.add(typeLbl);
            legendPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        legendPanel.add(Box.createGlue());
        add(legendPanel, BorderLayout.EAST);

        // --- WILAYAH SOUTH: Container Pembungkus (Panel Aksi + Bar Status) ---
        JPanel southContainer = new JPanel();
        southContainer.setLayout(new BoxLayout(southContainer, BoxLayout.Y_AXIS));

        // 1. Panel Tambahan (Mini-Challenge: FlowLayout untuk Tombol Aksi/Placeholder)
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton btnAdd = new JButton("Tambah Karakter");
        JButton btnRefresh = new JButton("Refresh Data");
        JButton btnFilter = new JButton("Filter Role");
        
        actionPanel.add(btnAdd);
        actionPanel.add(btnRefresh);
        actionPanel.add(btnFilter);
        southContainer.add(actionPanel);

        // 2. Bar Status (BorderLayout)
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        
        statusLabel = new JLabel("Status: Berjalan Normal | Total Karakter: " + characterManager.getAllCharacters().size());
        JLabel versionLabel = new JLabel("v0.5");
        
        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);
        southContainer.add(statusPanel);

        add(southContainer, BorderLayout.SOUTH);
    }

    private void loadCharacters() {
        characterListPanel.removeAll();
        List<Character> characters = characterManager.getAllCharacters();

        if (characters.size() < 8) {
            characterManager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
            characterManager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
            characterManager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
            characterManager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7));
            characterManager.addCharacter(new Character("Shadow", CharacterType.ROGUE, 6));
            characterManager.addCharacter(new Character("Zilong", CharacterType.WARRIOR, 10));
            characterManager.addCharacter(new Character("Eudora", CharacterType.MAGE, 8));
            characterManager.addCharacter(new Character("Layla", CharacterType.ARCHER, 2));
            characters = characterManager.getAllCharacters();
        }

        for (Character c : characters) {
            JPanel card = new JPanel(new BorderLayout());
            card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
            card.setOpaque(true);
            card.setBackground(AppTheme.colorFor(c.getType()));
            card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 20)),
                new EmptyBorder(8, 12, 8, 12)
            ));

            JLabel leftLabel = new JLabel("<html><b>⚔️ " + c.getName() + "  •  [" + c.getType() + "]");
            if (c.getLevel() >= 5) {
                leftLabel.setFont(new Font("Arial", Font.BOLD, 13));
                leftLabel.setForeground(new Color(160, 100, 0));
            } else {
                leftLabel.setFont(new Font("Arial", Font.BOLD, 12));
                leftLabel.setForeground(new Color(50, 50, 50));
            }

            JLabel rightLabel = new JLabel("Level " + c.getLevel() + " ");
            rightLabel.setFont(new Font("Arial", Font.BOLD, 12));
            rightLabel.setForeground(c.getLevel() >= 5 ? new Color(160, 100, 0) : Color.DARK_GRAY);
            rightLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            card.add(leftLabel, BorderLayout.WEST);
            card.add(rightLabel, BorderLayout.EAST);

            characterListPanel.add(card);
            characterListPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        
        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}