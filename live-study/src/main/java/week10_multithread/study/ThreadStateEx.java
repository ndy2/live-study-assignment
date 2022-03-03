package week10_multithread.study;

public class ThreadStateEx {

    public static void main(String[] args) {
        TargetThread targetThread = new TargetThread("targetThread");
        StatePrintThread statePrintThread = new StatePrintThread(targetThread, "statePrintThread");
        statePrintThread.start();
    }

    static class StatePrintThread extends Thread{
        private final Thread targetThread;

        StatePrintThread(Thread targetThread, String name) {
            super(name);
            this.targetThread = targetThread;
        }


        @Override
        public void run() {
            while(true){
            State state = targetThread.getState();
            System.out.println("[statePrintThread] " + "타겟 스레드 상태 : " + state);
            if(state == State.NEW){
                targetThread.start();
            }
            if(state == State.TERMINATED){
                break;
            }
            mySleep(500);
            }
        }
    }

    static class TargetThread extends Thread{
        public TargetThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int k = 1;
            for (int i = 0; i < 1_000_000_000; i++) { k += i;}
            mySleep(1500);
            for (int i = 0; i < 1_000_000_000; i++) { k -= i;}
            System.out.println("k = " + k);
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
