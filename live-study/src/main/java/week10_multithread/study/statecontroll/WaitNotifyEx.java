package week10_multithread.study.statecontroll;

public class WaitNotifyEx {

    public static void main(String[] args) {

        WorkObj workObj = new WorkObj();
        ThreadA threadA = new ThreadA(workObj);
        ThreadB threadB = new ThreadB(workObj);

        threadA.start();
        threadB.start();
    }

    static class WorkObj{
        public synchronized void methodA() {
            System.out.println("ThreadA calls WorkObj.methodA()");
            notify(); //Thread A -> B를 실행대기로 만들고
            try {
                wait();   //자신은 일시정지
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void methodB(){
            System.out.println("ThreadB calls WorkObj.methodB()");
            notify(); //Thread B -> A를 실행대기로 만들고
            try {
                wait();   //자신은 일시정지
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread{
        private final WorkObj workObj;

        public ThreadA(WorkObj workObj) {
            this.workObj = workObj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                workObj.methodA();
            }
        }
    }


    static class ThreadB extends Thread{
        private final WorkObj workObj;

        ThreadB(WorkObj workObj) {
            this.workObj = workObj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                workObj.methodB();
            }
        }
    }
}
