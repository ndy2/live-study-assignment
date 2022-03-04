package week10_multithread.study;

public class DaemonEx {

    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread 종료");
    }

    static class AutoSaveThread extends Thread{

        public void save(){
            System.out.println("작업 내용을 저장함.");
        }

        @Override
        public void run() {
            while(true){
                //3초 단위로 저장
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                save();
            }
        }
    }
}
