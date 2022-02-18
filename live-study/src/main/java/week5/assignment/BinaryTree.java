package week5.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public void add(int value){
        Node newNode = new Node(value);
        if(this.root == null){
            this.root = newNode;
        }else{
            Node cur = this.root;
            Node parent = null;
            String dir=" ";
            while(cur!=null){
                parent = cur;
                if(value < cur.getValue()){
                    dir = "left";
                    cur = cur.getLeft();
                }else{
                    dir = "right";
                    cur = cur.getRight();
                }
            }

            if(dir.equals("left")) parent.setLeft(newNode);
            else parent.setRight(newNode);
        }
    }


    private Node findNode(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.getValue() == node.getValue()){
                return cur;
            }
            if(cur.getRight()!=null){
                queue.add(cur.getRight());
            }
            if(cur.getLeft()!=null){
                queue.add(cur.getLeft());
            }
        }
        throw new IllegalArgumentException("No such node : value of " + node.getValue());
    }

    private void printRootBfs(){
        root.printBfs();
    }

    private void printRootDfs(){
        root.printDfs();
    }

    public void bfs(Node node){
        try{
            findNode(node).printBfs();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void dfs(Node node){
        try{
            findNode(node).printDfs();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
