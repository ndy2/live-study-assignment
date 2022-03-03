package week10_multithread.study;

public class Main {

    // main thread - JVM 이 실행
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("[Run] Runnable");
        task.run();

        Runnable thread = new MyThread();
        thread.run();
    }
    
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("[Run] Thread");
        }
    }

}
