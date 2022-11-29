package educative.arrays;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(4);

        Stack<Integer> s2 = new Stack<>();
        System.out.println(s);
        System.out.println(s2);

        while(!s.isEmpty()){
            int temp = s.pop();
            while(!s2.isEmpty() && temp < s2.peek()){
                s.push(s2.pop());
            }
            s2.push(temp);
        }
        while(!s2.isEmpty()){
            s.push(s2.pop());
        }
        System.out.println(s);
        System.out.println(s.peek());
    }
    public static String[] findBin(int number) {
        String[] result = new String[number];
        // 1 , 2, 3
        // Write -- Your -- Code
        int index = number-1;
        Queue<Integer> q = new ArrayDeque<>();
        while(number > 0){
            int local = number;
            String s = "";
            while(local > 0){
                q.add(local%2);
                local = local/2;
            }
            while(!q.isEmpty()){
                s = q.poll() + s;
            }
            result[index--] = s;
            s = "";
            number--;
        }
        return result; //For number = 3 , result = {"1","10","11"};
    }

    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        // Input: [2, 1, 5, 2, 3, 2], S=7
        ArrayDeque<Integer> a = new ArrayDeque<>();
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int i : arr){
            a.add(i);
            sum+=i;
            while(sum >= S){
                result = Math.min(result, a.size());
                sum = sum - a.poll();

            }
        }
        return result;
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums){
            for(int i=0;i<subsets.size();i++){
                List<Integer> l = new ArrayList<>(subsets.get(i));
                l.add(num);
                subsets.add(l);
            }
        }
        // TODO: Write your code here
        return subsets;
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        String reversed = "";
        int a = 0;
        int b = arr.length-1;
        while(a<b){
            String temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        for(String i : arr){
            reversed+=i;
        }
        return reversed;
    }



}
