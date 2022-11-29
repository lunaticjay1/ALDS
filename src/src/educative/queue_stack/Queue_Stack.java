package educative.queue_stack;

import java.util.*;

public class Queue_Stack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(100);
        s.add(40);
        s.add(60);
        s.add(20);
        System.out.println(s);

        //challenge 1
        System.out.println(Arrays.toString(binary(7)));

        //challenge 3-1
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        System.out.println(q);
        Queue<Integer> a = reverseFirstNElements(q,3);
        System.out.println(a);

        //challenge 3-2
        q = new ArrayDeque<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        System.out.println(reverseFirstNElements2(q,3));

        //challenge 5
        System.out.println(sortStack(s));

        //challenge 6
        System.out.println(evaluatePostfixExpression("921*-8-4+"));

        //challenge 7
        System.out.println(Arrays.toString(nextGreater(new int[]{4,6,3,2,8,1})));
        System.out.println(Arrays.toString(new int[]{4,7,3,4,8,1}));
        System.out.println(Arrays.toString(nextGreater(new int[]{4,7,3,4,8,1})));
        System.out.println(Arrays.toString(nextGreater2(new int[]{4,6,3,2,8,1})));
    }

    // challenge 1: generate binary numbers from 1 to n using a queue
    // https://www.youtube.com/watch?v=osF7tb10cUA&t=314s
    public static String[] binary(int n) {
        String[] result = new String[n];
        Queue<String> q = new ArrayDeque<>();
        q.offer("1");
        for(int i=0;i<n;i++){
            String temp = q.poll();
            result[i] = temp;
            String s1 = temp+"0";
            String s2 = temp+"1";
            q.offer(s1);
            q.offer(s2);
        }
        return result;
    }

    // Challenge 3: Reversing the First k Elements of a Queue
    // This solution is using extra queue, there is another one down below using input queue
    public static Queue<Integer> reverseFirstNElements(Queue<Integer> q, int n){
        Stack<Integer> s = new Stack<>();

        while(n > 0){
            s.push(q.poll());
            n--;
        }
        Queue<Integer> result = new ArrayDeque<>();
        while(!s.isEmpty()){
            result.offer(s.pop());
        }
        while(!q.isEmpty()){
            result.offer(q.poll());
        }
        return result;
    }

    // Challenge 3: Reversing the First k Elements of a Queue
    // This solution does not use extra queue
    public static Queue<Integer> reverseFirstNElements2(Queue<Integer> q, int n){
        Stack<Integer> s = new Stack<>();
        int temp = n;
        while(temp > 0){
            s.push(q.poll());
            temp--;
        }
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        for(int i=0;i<q.size()-n;i++){
            q.offer(q.poll());
        }
        return q;
    }


    // Challenge 5: Sort the Values in a Stack
    // https://www.youtube.com/watch?v=K0XXVSL4wUo&t=448s
    public static Stack<Integer> sortStack(Stack<Integer> s){
        // s = {23,60,12,42,4,97,2}
        // stack = {2,4,12,23,42,60,97}
        // [23]
        Stack<Integer> stack = new Stack<>();
        while(!s.isEmpty()){
            int temp = s.pop();
            while(!stack.isEmpty() && stack.peek() > temp){
                s.push(stack.pop());
            }
            stack.push(temp);
        }

        return stack;
    }

    // Challenge 6: Evaluate Postfix Expressions using Stacks
    // https://www.youtube.com/watch?v=P5YWUXrPEyw
    // input = "921*-8-4+"; # 9 - 2 * 1 - 8 + 4
    // output = 3
    public static int evaluatePostfixExpression(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }else {
                int x = stack.pop();
                int y = stack.pop();
                switch (c) {
                    case '+' -> stack.push(y + x);
                    case '-' -> stack.push(y - x);
                    case '*' -> stack.push(y * x);
                    case '/' -> stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }

    // Challenge 7: Next Greater Element using Stack
    // In this approach, we iterate through rest of array from that value to get next highest value
    public static int[] nextGreater(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(i == arr.length-1){
                arr[i] = -1;
            }else{
                for(int j =i+1;j<arr.length;j++){
                    if(arr[j] > arr[i]){
                        arr[i] = arr[j];
                        break;
                    }else if(j == arr.length-1 && arr[j] < arr[i]){
                        arr[i] = -1;
                    }
                }
            }
        }
        return arr;
        //Time complexity (n*n); // we have better solution using hashmap and stack;
    }

    // Challenge 7: Next Greater Element using Stack
    // https://www.youtube.com/watch?v=8BDKB2yuGyg (similar-nick white)
    // In the above YouTube video, they use two arrays, here we are using one array
    // https://www.youtube.com/watch?v=uFso48YRRao
    public static int[] nextGreater2(int[] arr){
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : arr){
            while(!s.isEmpty() && s.peek() < i){
                m.put(s.pop() , i);
            }
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = m.getOrDefault(arr[i], -1);
        }
        return arr;
        //Time complexity (n); // But this only works if array is distinct;
    }

    // Challenge 7: Next Greater Element using Stack
    // https://www.youtube.com/watch?v=JUDNrDg-LhQ&t=754s
    public static int[] nextGreater3(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(!s.isEmpty()){
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
            }
            if(s.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = s.peek();
            }
            s.push(i);
        }
        return arr;
        //Time complexity (n); // This works for arrays with duplicates also;
    }



}


