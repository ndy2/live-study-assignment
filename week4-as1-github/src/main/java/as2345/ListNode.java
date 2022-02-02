package as2345;

public class ListNode<T> {

    T data;
    ListNode<T> next;

    ListNode add(ListNode head, ListNode nodeToAdd, int position){
        if(head==null && position!=0){
            throw new IllegalArgumentException("null 에는 position 0의 node 만 추가 할 수 있습니다.");
        }
        return this;
    }

    ListNode remove(ListNode head, int positionToRemove){
        return this;
    }

    boolean contains(ListNode head, ListNode nodeToCheck){
        return false;
    }

}
