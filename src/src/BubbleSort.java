public class BubbleSort {

    // using while loop
    static void bubbleSort(int[] arr){
        boolean notSorted = true;
        while(notSorted){
            for(int i=0;i<arr.length-1;i++){
                notSorted = false;
                if(arr[i] > arr[i+1]){
                    notSorted = true;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
    // Same as above method, but using for loop instead of while loop
    static void bubbleSort2(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

/*
     1. coding with john YouTube for reference
 */
