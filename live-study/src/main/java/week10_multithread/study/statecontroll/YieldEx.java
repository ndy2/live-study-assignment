package week10_multithread.study.statecontroll;

public class YieldEx {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        mysleep( 3000);
        threadA.work = false;   // A 가 일을 양보하러감

        System.out.println("ThreadA -> Yeild");
        mysleep( 3000);

        System.out.println("ThreadA -> Stop");
        threadA.stop = true;   // A 가 일을 관둠

        System.out.println("ThreadB -> Stop");
        threadB.stop = true;   // B 가 일을 관둠

        System.out.println("RUNNABLE -> TERMINATED");

    }

    private static void mysleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread{
        public boolean stop = false;
        public boolean work = true;

        @Override
        public void run() {
            while(!stop){
                if(work){
                    System.out.println("[Thread A] 작업 작업");
                } else {
                    Thread.yield();
                }
                mysleep(100);
            }
            System.out.println("[Thread A] 종료");

        }
    }

    static class ThreadB extends Thread{
        public boolean stop = false;
        public boolean work = true;

        @Override
        public void run() {
            while(!stop){
                if(work){
                    System.out.println("[Thread B] 작업 작업");
                } else {
                    Thread.yield();
                }
                mysleep(100);
            }
            System.out.println("[Thread B] 종료");
        }
    }
}
