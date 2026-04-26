package Matura.DecoratorFactory.Decorator;

public class SchafskäseDecorator extends KebapDecorator{

    public SchafskäseDecorator(Kebap kebap) {
        super(kebap);
    }

    @Override
    public String getName() {
        return kebap.getName() + " mit Schafskäse";
    }

    @Override
    public int getPrice() {
        return kebap.getPrice() + 1;
    }
}
