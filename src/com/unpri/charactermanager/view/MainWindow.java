package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.service.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JList<Character> listKarakter;
    private DefaultListModel<Character> listModel;
    private JLabel lblRataRataLevel;

    // Konstanta bernama untuk Mini-Challenge
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public MainWindow(CharacterManager characterManager) {
        this.characterManager = characterManager;
        
        setTitle("Character Manager — Sprint #4 (TP10)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Judul Jendela
        JLabel lblJudul = new JLabel("Daftar Karakter Game", JLabel.CENTER);
        lblJudul.setFont(AppTheme.FONT_TITLE);
        lblJudul.setBorder(AppTheme.PADDING_BORDER);
        add(lblJudul, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        listKarakter = new JList<>(listModel);
        listKarakter.setFixedCellHeight(38);
        listKarakter.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Custom Cell Renderer dengan AppTheme
        listKarakter.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if (value instanceof Character) {
                    Character ch = (Character) value;
                    
                    setText(String.format(" Character{name='%s', type=%s, level=%d, hp=%d, atk=%d, mana=%d, isAlive=%b}",
                            ch.getName(), ch.getType(), ch.getLevel(), ch.getHp(), ch.getAtk(), ch.getMana(), ch.isAlive()));
                    
                    // PROPERTI TAMBAHAN 1: Tooltip detail HP dan ATK saat kursor diarahkan ke baris
                    setToolTipText(String.format("Karakter: %s | Total HP: %d | Total ATK: %d", ch.getName(), ch.getHp(), ch.getAtk()));

                    if (!isSelected) {
                        // Memanggil warna dari AppTheme.colorFor()
                        setBackground(AppTheme.colorFor(ch.getType()));
                        
                        // MINI-CHALLENGE: Level >= 5 teks warna EMAS dan TEBAL
                        if (ch.getLevel() >= HIGH_LEVEL_THRESHOLD) {
                            setForeground(AppTheme.COLOR_GOLD);
                            setFont(AppTheme.FONT_HIGH_LEVEL);
                        } else {
                            setForeground(Color.BLACK);
                            setFont(AppTheme.FONT_REGULAR);
                        }
                    } else {
                        setBackground(new Color(70, 130, 180));
                        setForeground(Color.WHITE);
                    }

                    // PROPERTI TAMBAHAN 2: Menambahkan border garis bawah tipis antar baris
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(listKarakter);
        scrollPane.setBorder(AppTheme.PADDING_BORDER);
        add(scrollPane, BorderLayout.CENTER);

        lblRataRataLevel = new JLabel(" Rata-rata Level Karakter: 0.0");
        lblRataRataLevel.setFont(AppTheme.FONT_REGULAR);
        lblRataRataLevel.setBorder(AppTheme.PADDING_BORDER);
        add(lblRataRataLevel, BorderLayout.SOUTH);

        muatDataList();
        
        // Memakai pack() sesuai instruksi Bagian A
        pack();
        setLocationRelativeTo(null);
    }

    public void muatDataList() {
        listModel.clear();
        double totalLevel = 0;
        java.util.List<Character> listKarakterData = characterManager.getAllCharacters();

        for (Character ch : listKarakterData) {
            listModel.addElement(ch);
            totalLevel += ch.getLevel();
        }

        double rataRata = listKarakterData.isEmpty() ? 0 : totalLevel / listKarakterData.size();
        lblRataRataLevel.setText(String.format(" Rata-rata Level Karakter: %.2f", rataRata));
    }
}