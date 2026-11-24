package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.service.CharacterManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JPanel characterListPanel;
    private JLabel avgLevelLabel;

    public MainWindow(CharacterManager characterManager) {
        this.characterManager = characterManager;
        setTitle("Character Manager - Sprint #3 (TP8)");
        setSize(640, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel();
        headerPanel.setBorder(new EmptyBorder(10, 10, 5, 10));
        JLabel titleLabel = new JLabel("Daftar Karakter Game");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));
        characterListPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statsPanel.setBorder(new EmptyBorder(5, 10, 10, 10));
        avgLevelLabel = new JLabel();
        avgLevelLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        statsPanel.add(avgLevelLabel);
        add(statsPanel, BorderLayout.SOUTH);

        refreshData();
    }

    public void refreshData() {
        characterListPanel.removeAll();
        List<Character> characters = characterManager.getAllCharacters();

        for (Character c : characters) {
            JLabel itemLabel = new JLabel(
                c.getName() + " [" + c.getType() + "] - Level " + c.getLevel()
            );
            itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
            itemLabel.setBorder(new EmptyBorder(4, 6, 4, 6));
            characterListPanel.add(itemLabel);
        }

        avgLevelLabel.setText(
            "Rata-rata Level: " + String.format("%.2f", characterManager.getAverageLevel())
        );

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}
