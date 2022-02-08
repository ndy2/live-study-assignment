package as2345;

public class LinkedList {

    private ListNode<Integer> head;

    public ListNode<Integer> getHead() {
        return head;
    }

    public LinkedList(Integer integer) {
        this.head = new ListNode<>(integer);
    }

    public ListNode<Integer> add (ListNode<Integer> nodeToAdd, int position){
        head.add(nodeToAdd,position);
        return nodeToAdd;
    }

    public ListNode<Integer> remove(int positionToRemove){
        return head.remove(positionToRemove);
    }

    public boolean contains(ListNode<Integer> nodeToCheck){
        return head.contains(nodeToCheck);
    }

    public int length() {
        return head.length();
    }

    public ListNode<Integer> at(int position) {
        return head.at(position);
    }
}
