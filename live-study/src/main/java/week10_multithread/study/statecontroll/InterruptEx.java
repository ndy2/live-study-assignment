package week10_multithread.study.statecontroll;

public class InterruptEx {

    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        printThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThread.interrupt();
    }

    static class PrintThread extends Thread{

        @Override
        public void run() {
            /*try {
                while(true){
                    System.out.println("프린트 중");
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("중지");
                e.printStackTrace();
            }*/

            while(true){
                System.out.println("프린트 중");
//                if(Thread.interrupted()){
                if(isInterrupted()){
                    break;
                }
            }
        }
    }
}
