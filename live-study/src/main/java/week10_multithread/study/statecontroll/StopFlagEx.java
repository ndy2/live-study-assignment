package week10_multithread.study.statecontroll;

public class StopFlagEx {

    public static void main(String[] args) {

        PrintThread thread = new PrintThread();
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setStop(true);
    }

    static class PrintThread extends Thread{
        private boolean stop;

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        @Override
        public void run(){
            while(!stop){
                System.out.println("실행 중");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //쓰레드 자원 정리
            System.out.println("정리 중");
            System.out.println("실행 종료");
        }
    }
}
