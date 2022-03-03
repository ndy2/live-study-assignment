package week10_multithread.study.statecontroll;

public class JoinEx {

    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            sumThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1~100 의 합 " + sumThread.getSum());
    }

    static class SumThread extends Thread{
        private long sum;

        public long getSum() {
            return sum;
        }

        public void setSum(long sum) {
            this.sum = sum;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
        }
    }
}
