package as2345;

import java.util.EmptyStackException;

public class Stack {

    private int[] arr;
    private int top;

    public Stack() {
        arr = new int[0];
        top = -1;
    }

    void push(int data){
        top+=1;
        if(arr.length == top){
            int[] temp = new int[arr.length+1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            temp[arr.length] = data;
            arr = temp;
        } else{
            arr[top] = data;
        }
    }

    int pop(){
        if(top==-1){
            System.out.println("EmptyStack");
            throw new EmptyStackException();
        }else{
            return arr[top--];
        }
    }
}
