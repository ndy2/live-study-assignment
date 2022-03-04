package week10_multithread.study;

public class ThreadGroupInfoEx {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myThreadGroup = new ThreadGroup("myThreadGroup");
        WorkThread workThreadA = new WorkThread(myThreadGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myThreadGroup, "workThreadB");
        workThreadA.start();
        workThreadB.start();

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("[main 스레드 그룹의 list() 메소드 호출]");
        mainGroup.list();

        Thread.sleep(3000);
        myThreadGroup.interrupt();
        System.out.println("main terminated");
    }

    static class WorkThread extends Thread{

        public WorkThread(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    System.out.println(getName()+" running");
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted!");
                    break;
                }
            }
            System.out.println(getName() + " terminated");
        }
    }
}
