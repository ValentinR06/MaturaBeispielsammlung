package Matura.DecoratorFactory.Decorator;

public class SimpleKebap implements Kebap{

    @Override
    public String getName() {
        return "Kebap";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
