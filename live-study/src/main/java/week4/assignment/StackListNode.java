package week4.assignment;

public class StackListNode {

    private ListNode<Integer> arr;

    public StackListNode() {
        arr = new ListNode<>(0);
    }

    public void push(int data){
        arr.add(new ListNode<>(data),0);
    }

    public int pop() throws Exception {
        ListNode<Integer> ret = arr.remove(0);
        if (ret == null) {
            throw new Exception("No more stack");
        }
        arr =ret;
        return ret.getData();
    }

}
