package Matura.Pattern.MVC;

import java.util.EventObject;

public class PointEvent extends EventObject {
    private final Point point;

    public PointEvent(Model source, Point point) {
        super(source);
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }
}
