package Matura.LaufzeitKomplexitaet;

public class Sortieren {
    public static void main(String[] args) {

    }

    private static void bubble_sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    private static void insertion_sort(int[] array) {

    }

    private static void selection_sort(int[] array) {

    }
}
