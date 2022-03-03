package week10_multithread.study;

public class ThreadPriorityEx {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {

            Thread thread = new CalcThread("CalcThread "+i);
            if(i!=10){
                thread.setPriority(Thread.MIN_PRIORITY);
            }else{
                thread.setPriority(Thread.MAX_PRIORITY);    //가장 먼저 끝난다.
            }
            thread.start();
        }
    }

    static class CalcThread extends Thread{
        public CalcThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            mySleep(3);
            System.out.println(getName() + " Done");
        }
    }

    private static void mySleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("[error] " +  e.getClass().getSimpleName() + " message : + " + e.getMessage());
        }
    }
}
