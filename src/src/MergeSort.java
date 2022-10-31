public class MergeSort {

    /* coding with john YouTube */

    static void mergeSort(int[] arr){
        int length = arr.length;
        if(length < 2){
            return;
        }

        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for(int i=0;i<mid;i++){
            left[i] = arr[i];
        }
        for(int i = mid;i<length;i++){
            right[i-mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);

    }

    private static void merge(int[] arr, int[] arr1, int[] arr2){
        int a = 0;
        int b = 0;
        int c = 0;
        while(a<arr1.length && b<arr2.length){
            if(arr1[a]<arr2[b]){
                arr[c++] = arr1[a++];
            }else{
                arr[c++] = arr2[b++];
            }
        }
        while(a<arr1.length){
            arr[c++] = arr1[a++];
        }
        while(b<arr2.length){
            arr[c++] = arr2[b++];
        }
    }
}
