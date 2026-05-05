package Matura.Java;

public class Main {
     static void main(String[] args) {
        Beef beef = new Beef();
        Food food = new Beef();

        Meat meat = beef;
        Meat meat2 = (Beef) food;
    }
}
