package as2345;

public class ListNode<T> {

    private T data;
    private ListNode<T> next;
    private int len;

    public T getData() {
        return data;
    }

    public ListNode(T data) {
        this.data = data;
        this.next = null;
        this.len=1;
    }

    public int length(){
        return len;
    }

    public ListNode<T> atLast(){
        ListNode<T> cur = this;
        while(cur.next!=null){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode<T> at(int position){
        ListNode<T> cur = this;
        for (int i = 0; i < position; i++) {
            cur = cur.next;
            if(cur == null){
                throw new IllegalArgumentException("out of range "+ position);
            }
        }
        return cur;
    }

    public void add(ListNode<T> nodeToAdd, int position){
        if(position<0){
            throw new IllegalArgumentException("음수의 position 에는 노드를 추가 할 수 없습니다.");
        }

        if(position>len){
            throw new IllegalArgumentException(String.format("head의 길이 %d 보다 position %d 이 큽니다. 가능 : %d~%d", len, position, 0 , len-1));
        }

        ListNode<T> leftNode = this.at(position);
        ListNode<T> save = leftNode.next;
        leftNode.next = nodeToAdd;

        ListNode<T> addEnd = nodeToAdd.atLast();
        addEnd.next = save;

        len+=nodeToAdd.length();
    }

    public ListNode<T> remove(int positionToRemove){
        if(positionToRemove>len){
            throw new IllegalArgumentException(String.format("head의 길이 %d 보다 positionToRemove %d 이 큽니다. 가능 : %d~%d", len, positionToRemove, 0 , len-1));
        }

        if(positionToRemove==0){
            len-=1;
            return this.next;
        }
        if(positionToRemove==len-1){
            at(positionToRemove-1).next = null;
        }else{
            at(positionToRemove-1).next = at(positionToRemove+1);
        }
        len-=1;
        return this;
    }

    public boolean contains(ListNode<T> nodeToCheck){

        ListNode<T> cur = this;
        while(cur!=null){
            if(cur==nodeToCheck){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
