package Matura.Stack.CloneableStack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        Stack clone = stack.clone();

    }
}
