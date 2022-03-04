package week10_multithread.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import static java.lang.Thread.currentThread;

public class ExecuteVsSubmitEx {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = ()
                    -> {
                ThreadPoolExecutor executor = (ThreadPoolExecutor) es;
                int poolSize = executor.getPoolSize();
                System.out.println("[총 스레드 개수 : " + poolSize + "] 작업 스레드 이름 : " + currentThread().getName() + " run!");
                throw new RuntimeException("예외 빵!");
            };
//            es.execute(runnable);  // -> 예외 발생시 스레드 종료
            Future<?> result = es.submit(runnable);// -> 예외 발생시 스레드 재활용, 작업 결과 받을 수 있음
            Thread.sleep(10);
        }

        es.shutdown();
    }
}
