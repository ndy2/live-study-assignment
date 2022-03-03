package week10_multithread.study;

import java.util.function.ToIntBiFunction;

public class Calculator{
    int save;

    enum OP{ADD((a,b) -> a+b),
        SUB((a,b) -> a-b),
        MUL((a,b) -> a*b),
        DIV((a,b) -> a/b);

        final ToIntBiFunction<Integer, Integer> func;

        OP(ToIntBiFunction<Integer, Integer> func) {
            this.func = func;
        }

        public int calc(int num, int save) {
            return func.applyAsInt(num, save);
        }
    }

    synchronized void calc(Calculator.OP opcode, int num){
        int before = save;
        save = opcode.calc(save, num);
        System.out.println("[" + Thread.currentThread().getName() + "]" +  "before : " + before + " after : " + save);
        System.out.println("[" + Thread.currentThread().getName() + "]" + "sleep 2s");
        sleep(2000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("[error] " +  e.getClass().getSimpleName() + " message : + " + e.getMessage());
        }
    }
}
