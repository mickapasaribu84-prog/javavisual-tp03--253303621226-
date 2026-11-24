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
        setTitle("Character Manager - Sprint #4 (v0.4)");
        setSize(660, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(AppTheme.PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(10, 12, 10, 12));

        JLabel titleLabel = new JLabel("Character Manager - Sprint #4 (Theming)");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(new BoxLayout(characterListPanel, BoxLayout.Y_AXIS));
        characterListPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setBorder(AppTheme.DEFAULT_BORDER);
        add(scrollPane, BorderLayout.CENTER);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statsPanel.setBorder(new EmptyBorder(6, 12, 10, 12));
        avgLevelLabel = new JLabel();
        avgLevelLabel.setFont(AppTheme.GOLD_BOLD_FONT);
        statsPanel.add(avgLevelLabel);
        add(statsPanel, BorderLayout.SOUTH);

        refreshData();
    }

    public void refreshData() {
        characterListPanel.removeAll();
        List<Character> characters = characterManager.getAllCharacters();

        for (Character c : characters) {
            JPanel card = new JPanel(new BorderLayout(8, 4));
            card.setBackground(AppTheme.colorFor(c.getType()));
            card.setBorder(BorderFactory.createCompoundBorder(
                AppTheme.DEFAULT_BORDER,
                new EmptyBorder(8, 10, 8, 10)
            ));

            JLabel nameLabel = new JLabel(c.getName() + " [" + c.getType() + "]");
            if (c.getLevel() >= 5) {
                nameLabel.setFont(AppTheme.GOLD_BOLD_FONT);
            } else {
                nameLabel.setFont(AppTheme.REGULAR_FONT);
            }

            JLabel levelLabel = new JLabel("Level " + c.getLevel());
            levelLabel.setFont(AppTheme.REGULAR_FONT);

            card.add(nameLabel, BorderLayout.CENTER);
            card.add(levelLabel, BorderLayout.EAST);
            characterListPanel.add(card);
            characterListPanel.add(Box.createVerticalStrut(6));
        }

        avgLevelLabel.setText(
            "Rata-rata Level: " + String.format("%.2f", characterManager.getAverageLevel())
        );

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}