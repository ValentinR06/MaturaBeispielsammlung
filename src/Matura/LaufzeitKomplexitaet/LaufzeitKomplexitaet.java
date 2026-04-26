package Matura.LaufzeitKomplexitaet;

public class LaufzeitKomplexitaet {
    public static void main() {

    }

    public static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    //best O(1)
    //average O(n)
    //worst O(n)

    public static boolean contains(int[][] arr, int value) {
        for (int[] a : arr) {
            for (int i : a) {
                if (i == value) {
                    return true;
                }
            }
        }
        return false;
    }
    //best O(1)
    //average O(n²)
    //worst O(n²)

    public static boolean containsBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                return true;
            }
            if (arr[mid] > value) {
                high = mid - 1;
            }
            if (arr[mid] < value) {
                low = mid + 1;
            }
        }
        return false;
    }

    //best O(1)
    //average O(log(n))
    //worst O(log(n))
}
