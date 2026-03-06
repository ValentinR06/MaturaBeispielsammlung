package Matura.DecoratorFactory.Factory;

import Matura.DecoratorFactory.Decorator.Kebap;
import Matura.DecoratorFactory.Decorator.SchafskäseDecorator;
import Matura.DecoratorFactory.Decorator.SimpleDueruem;

public class SchafskäseDueruemFactory implements KebapFactory{

    @Override
    public Kebap createKebap() {
        return new SchafskäseDecorator(new SimpleDueruem());
    }
}


