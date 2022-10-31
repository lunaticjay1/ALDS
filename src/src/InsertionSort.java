public class InsertionSort {

    /* coding with john YouTube */

    static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > currentValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
    }
}
