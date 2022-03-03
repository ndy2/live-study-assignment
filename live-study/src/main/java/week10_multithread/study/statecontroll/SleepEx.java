package week10_multithread.study.statecontroll;

import java.awt.*;

public class SleepEx {

    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++) {
            toolkit.beep();
            mySleep(3000);
        }
    }

    static void mySleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
