package educative.arrays;

// Challenge 2: Merge Two Sorted Arrays
public class MergeTwoSortedArrays {

    static int[] mergeArrays(int[] arr1, int[] arr2){
        int a = 0;
        int b = 0;
        int[] arr3 = new int[arr1.length+arr2.length];
        int index = 0;
        while(a<arr1.length && b<arr2.length){
            if(arr1[a] < arr2[b]){
                arr3[index++] = arr1[a++];
            }else{
                arr3[index++] = arr2[b++];
            }
        }

        while(a<arr1.length){
            arr3[index++] = arr1[a++];
        }
        while(b<arr2.length){
            arr3[index++] = arr2[b++];
        }
        return arr3;
    }
}
