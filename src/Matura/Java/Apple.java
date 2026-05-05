package Matura.Java;

public class Apple implements Food {
    @Override
    public Integer getPrice() {
        return 2;
    }

    @Override
    public String getName() {
        return "Apple";
    }
}
