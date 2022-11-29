package educative.arrays;

import java.util.Arrays;

public class QuickSort1 {

    static void quickSort(int[] nums) {
        quick(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    static void quick(int[] nums, int a, int b){
        if(a>=b){
            return;
        }
        int pivot = nums[b];
        int start = a;
        int end = b;
        while(start<end){
            while(nums[start] <= pivot && start<end){
                start++;
            }
            while(nums[end] >= pivot && start<end){
                end--;
            }

            swap(nums, start, end);
        }
        swap(nums, start, b);
        quick(nums, a, start-1);
        quick(nums,start+1,b);
    }
    static void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
