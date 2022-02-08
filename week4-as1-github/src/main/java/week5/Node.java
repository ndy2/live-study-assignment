package week5;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    private int value;
    private Node left,right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void printDfs() {
        if(left!=null) left.printDfs();
        System.out.print(value+" ");
        if(right!=null) right.printDfs();
    }

    public void printBfs() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.getValue()+" ");
            if(cur.getLeft()!=null){
                queue.add(cur.getLeft());
            }
            if(cur.getRight()!=null){
                queue.add(cur.getRight());
            }
        }
    }
}
