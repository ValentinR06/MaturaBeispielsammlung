package Matura.Pattern.MVC;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PointView extends JComponent {
    private final Model model;
    private final List<Point> points;

    public PointView(Model model) {
        this.model = model;
        points = new ArrayList<>();

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.addPoint(e.getX(), e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                model.addPoint(e.getX(), e.getY());
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        model.addListener(new PointListener() {
            @Override
            public void pointAdded(PointEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int r = 3;
        for (Point point : points) {
            g.fillOval(point.x() - r, point.y() - r, r * 2, r * 2);
        }
    }
}
