package Matura.Java;

public abstract class Meat implements Food {
    private boolean cooked = false;

    @Override
    public Integer getPrice() {
        return 5;
    }

    @Override
    public String getName() {
        return "Meat";
    }

    public void cook() {
        cooked = true;
    }
}
