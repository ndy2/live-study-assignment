package week10_multithread.study;

import java.awt.*;

public class BeepPrintExample2 {

    // main thread - JVM 이 실행
    public static void main(String[] args) {
        Thread beepThread = new BeepThread();
        Thread printThread = new PrintThread();
        beepThread.start();
        printThread.start();

        Thread beepThread2 = new Thread(
                () -> {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    for (int i = 0; i < 5; i++) {
                        toolkit.beep();
                        System.out.println(Thread.currentThread().getName() + " 땅");
                        mySleep(500);
                    }
                }
        );

        Thread printThread2 = new Thread(
                () -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " 띵");
                        mySleep(500);
                    }
                }
        );
        beepThread2.start();
        printThread2.start();

        System.out.println(Thread.currentThread().getName() + " 나는 메인");
    }



    static class BeepThread extends Thread{
        @Override
        public void run() {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                System.out.println(this.getName() + " 땅");
                mySleep(500);
            }
        }
    }


    static class PrintThread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() +" 띵");
                mySleep(500);
            }
        }
    }

    static void mySleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("[error] " +  e.getClass().getSimpleName() + " message : + " + e.getMessage());
        }
    }
}
