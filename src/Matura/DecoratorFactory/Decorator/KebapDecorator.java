package Matura.DecoratorFactory.Decorator;

public abstract class KebapDecorator implements Kebap{
    protected Kebap kebap;

    public KebapDecorator(Kebap kebap) {
        this.kebap = kebap;
    }
}
