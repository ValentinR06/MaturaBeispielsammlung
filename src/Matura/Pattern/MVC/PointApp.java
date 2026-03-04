package Matura.Pattern.MVC;

import javax.swing.*;
import java.awt.*;

public class PointApp {
    private final JFrame frame;
    private final Model model;
    private final PointView view1;
    private final PointView view2;
    private final PointView view3;

    PointApp(final Model model) {
        this.model = model;
        frame = new JFrame("Selection");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(1,3));
        view1 = new PointView(model);
        view2 = new PointView(model);
        view3 = new PointView(model);
        view1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        view2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        view3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(view1, BorderLayout.WEST);
        contentPane.add(view2, BorderLayout.CENTER);
        contentPane.add(view3, BorderLayout.EAST);
        frame.setLocation(100, 100);
        frame.setSize(300, 320);
        frame.setVisible(true);
    }

    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PointApp(new Model());
        });
    }
}
