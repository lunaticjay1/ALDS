import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,1,3,9};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}