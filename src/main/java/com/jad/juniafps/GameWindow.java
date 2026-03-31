package com.jad.juniafps;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GameWindow extends JFrame {
    private static final InputStream FONT_FILE = GameWindow.class.getResourceAsStream("/CascadiaMono.ttf");
    private final JTextArea textArea = new JTextArea("");

    public GameWindow(final String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        final Font font;
        try {
            assert GameWindow.FONT_FILE != null;
            font = Font.createFont(Font.TRUETYPE_FONT, GameWindow.FONT_FILE).deriveFont(RenderUtils.FONT_SIZE);
        } catch (final FontFormatException | IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setLayout(new BorderLayout());
        this.textArea.setFont(font);
        this.textArea.setEditable(false);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.GREEN);
        final JPanel panel = new JPanel();
        this.add(panel, BorderLayout.CENTER);
        panel.add(this.textArea);
        this.setVisible(true);
    }

    public void display(final String text) {
        this.textArea.setText(text);
    }
}
