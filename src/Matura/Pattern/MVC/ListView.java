package Matura.Pattern.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListView extends JPanel {
    private final Model model;

    public ListView(Model model) {
        this.model = model;
        model.addListener(e -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
