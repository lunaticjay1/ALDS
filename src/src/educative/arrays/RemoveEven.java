package educative.arrays;


// Challenge 1: Remove Even Integers from an Array
public class RemoveEven {

    static int[] removeEve(int[] arr){
        int odd = 0;
        for(int i : arr){
            if(i%2!=0){
                odd++;
            }
        }
        int[] returnArr = new int[odd];
        odd = 0;
        for(int i : arr){
            if(i%2!=0){
                returnArr[odd++] = i;
            }
        }
        return returnArr;
    }
}
