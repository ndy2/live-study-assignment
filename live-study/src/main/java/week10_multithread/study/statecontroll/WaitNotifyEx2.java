package week10_multithread.study.statecontroll;

public class WaitNotifyEx2 {

    public static void main(String[] args) {
        DataBox dataBox = new DataBox();

        Producer producer = new Producer(dataBox);
        Consumer consumer = new Consumer(dataBox);

        consumer.start();
        producer.start();
    }

    static class DataBox{
        private String data;

        public synchronized String getData() {
            if(this.data == null){
                try {
                    wait(); //Consumer를 일시정지 상태로
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String ret = data;
            data = null;
            notify(); // Producer에게 Consume을 다했음을 알림
            return ret;
        }

        public synchronized void setData(String data) {
            if(this.data != null){
                try {
                    wait(); // data가 null이면 기다림
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.data = data;
            notify(); // 저장해 놓았으니 가져가라고 알림
        }
    }

    static class Producer extends Thread{
        DataBox dataBox;

        public Producer(DataBox dataBox) {
            super.setName("[Producer Thread]");
            this.dataBox = dataBox;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                String data = "Data "+i;
                System.out.println(getName()+" data = " + data);
                dataBox.setData(data);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer extends Thread {
        DataBox dataBox;

        public Consumer(DataBox dataBox) {
            super.setName("[Consumer Thread]");
            this.dataBox = dataBox;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                String data = dataBox.getData();
                System.out.println(getName()+" data = " + data);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
