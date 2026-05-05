package Matura.Java;

public class Chicken extends Meat{
    @Override
    public Integer getPrice() {
        return 4;
    }

    @Override
    public String getName() {
        return "Chicken";
    }
}
