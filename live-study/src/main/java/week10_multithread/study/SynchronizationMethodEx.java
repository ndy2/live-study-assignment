package week10_multithread.study;

import static week10_multithread.study.Calculator.OP.*;

/**
 * 동기화 메소드 및 동기화 블록 - synchronized
 * - 단 하나의 스레드만 실행할 수 있는 메소드 또는 블록을 말한다. (임계영역 - critical section)
 * - 다른 스레드는 메소드나 블록이 실행이 끝날 때까지 대기해야 한다.
 */
public class SynchronizationMethodEx {

    public static void main(String[] args) {
        //공유 객체
        Calculator calculator = new Calculator();

        Thread addThread = new AddThread(calculator, "addThread");
        Thread subThread = new SubThread(calculator, "subThread");
        System.out.println("[main] addThread.State ="+ addThread.getState());
        System.out.println("[main] subThread.State ="+ subThread.getState());

        addThread.start();
        System.out.println("[main] addThread.State ="+ addThread.getState());
        System.out.println("[main] subThread.State ="+ subThread.getState());
        subThread.start();  // addThread 와 subThread 의 순서는 보장 x
        System.out.println("[main] addThread.State ="+ addThread.getState());
        System.out.println("[main] subThread.State ="+ subThread.getState());
        Calculator.sleep(6000);
        System.out.println("[main] final save: " +  calculator.save);
        System.out.println("[main] addThread.State ="+ addThread.getState());
        System.out.println("[main] subThread.State ="+ subThread.getState());
    }

    static class AddThread extends Thread{
        private final Calculator calculator;

        public AddThread(Calculator calculator, String name) {
            super(name);
            this.calculator = calculator;
        }

        @Override
        public void run() {
            System.out.println("[addThread] addThread.State ="+ getState());
            calculator.calc(ADD, 30);
        }
    }

    static class SubThread extends Thread{
        private final Calculator calculator;

        public SubThread(Calculator calculator, String name) {
            super(name);
            this.calculator = calculator;
        }

        @Override
        public void run() {
            System.out.println("[subThread] subThread.State ="+ getState());
            calculator.calc(SUB, 5);
        }
    }
}
