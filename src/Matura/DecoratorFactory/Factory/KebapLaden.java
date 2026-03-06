package Matura.DecoratorFactory.Factory;

import Matura.DecoratorFactory.Decorator.Kebap;

public class KebapLaden {
    private final KebapFactory kebapFactory;

    public KebapLaden(KebapFactory kebapFactory) {
        this.kebapFactory = kebapFactory;
    }

    public Kebap createKebap() {
        return kebapFactory.createKebap();
    }

    public static void main(String[] args) {
        KebapLaden laden = new KebapLaden(new SchafskäseDueruemFactory());
        Kebap kebap = laden.createKebap();
        System.out.println(kebap.getName());
        System.out.println(kebap.getPrice());
    }
}
