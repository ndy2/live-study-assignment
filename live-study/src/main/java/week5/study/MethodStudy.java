package week5.study;

import java.util.Arrays;

public class MethodStudy {

    public static void main(String[] args){
        int s = MethodStudy.sum(1,2,3,4);
        System.out.println("s = " + s);
    }

    static int sum(int... values){
        return Arrays.stream(values).sum();
    }
}
