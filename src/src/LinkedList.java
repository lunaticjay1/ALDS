public class LinkedList {
    private class Node{
        private int value;
        private Node next;
    }

    private Node first;
    private Node last;
    private int size = 0;

    void addFirst(int i){
        Node n = new Node();
        n.value = i;
        if(first == null){
            first = n;
            last = n;
        }else{
            n.next = first;
            first = n;
        }
        size++;
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    void addLast(int i){
        Node n = new Node();
        n.value = i;
        if(first == null){
            first = last = n;
        }else{
            last.next = n;
            last = n;
        }
        size++;
    }

    void deleteFirst(){
        Node n = first.next;
        if(first == last){
            first = last = null;
        }
        else{
            first.next = null;
            first = n;
        }
        size--;
    }
    void deleteLast(){
        Node n = first;
        while(n.next.next!=null){
            n = n.next;
        }
        n.next = null;
        last = n;
        size--;
    }

    boolean contains(int i){
        Node n = first;
        while(n!=null){
            if(n.value == i){
                return true;
            }else{
                n = n.next;
            }
        }
        return false;
    }

    int indexof(int i){
        Node n = first;
        int count = 0;
        while(n!=null){
            if(n.value == i){
                return count;
            }else{
                n = n.next;
                count++;
            }
        }
        return -1;
    }
    int size(){
        return size;
    }
    void reverse(){
        Node prev = null;
        Node curr = first;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first = prev;
    }
}
