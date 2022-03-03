package week10_multithread.study;

import java.awt.*;

public class BeepPrintExample1 {

    // main thread - JVM 이 실행
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Runnable beepTask = () ->{
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            sleep(500);
        }};
        Thread beepThread = new Thread(beepTask);

        Runnable printTask = () ->{
          for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            sleep(500);
        }};
        Thread printThread = new Thread(printTask);

        beepThread.start();
        printThread.start();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("[error] " +  e.getClass().getSimpleName() + " message : + " + e.getMessage());
        }
    }
}
