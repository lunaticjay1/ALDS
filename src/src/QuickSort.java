public class QuickSort {

    /* coding with john YouTube */

    static void quickSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int a = low;
        int b = high;
        int pivot = arr[b];
        while(a<b){
            while(arr[a] <=pivot && a<b){
                a++;
            }
            while(arr[b]>=pivot && a<b){
                b--;
            }
            swap(arr, a, b);
        }
        swap(arr,a,high);
        quickSort(arr,low,a-1);
        quickSort(arr,a+1,high);
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
