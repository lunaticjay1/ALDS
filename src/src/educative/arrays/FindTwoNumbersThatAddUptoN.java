package educative.arrays;
import java.util.HashMap;
import java.util.Map;

//Challenge 3: Find Two Numbers that Add up to "n"

public class FindTwoNumbersThatAddUptoN {
    static int[] find(int[] arr, int n){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(n-i)){
                return new int[]{i,n-i};
            }else{
                map.put(i,1);
            }
        }
        return new int[]{-1,-1};
    }
}
