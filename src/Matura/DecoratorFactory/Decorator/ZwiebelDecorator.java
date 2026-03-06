package Matura.DecoratorFactory.Decorator;

public class ZwiebelDecorator extends KebapDecorator{

    public ZwiebelDecorator(Kebap kebap) {
        super(kebap);
    }

    @Override
    public String getName() {
        return kebap.getName() + "mit Zwiebel";
    }

    @Override
    public int getPrice() {
        return kebap.getPrice();
    }
}
