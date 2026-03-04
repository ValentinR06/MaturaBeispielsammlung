package Matura.Pattern.MVC;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<PointListener> listeners;
    private final List<Point> points;

    public Model() {
        this.listeners = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public void addPoint(int x, int y) {
        addPoint(new Point(x, y));
    }

    public void addPoint(Point point) {
        points.add(point);
        notifyListeners(point);
    }

    public void addListener(PointListener listener) {
        listeners.add(listener);
    }

    public void removeListener(PointListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(Point point) {
        for (PointListener l : listeners) {
            l.pointAdded(new PointEvent(this, point));
        }
    }

}
