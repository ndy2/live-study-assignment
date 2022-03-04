package week10_multithread.study;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * 작업 처리 완료 후 결과가 없는 작업의 완료 처리를 Blocking 방식으로
 */
public class NoResultEx {

    public static void main(String[] args) {

        //현재 CPU 의 core 수
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(nThreads);

        Runnable sumTask = () -> {
            int sum = IntStream.range(1, 10).sum();
            System.out.println("sum : " + sum);
        };

        Future<?> result = es.submit(sumTask);
        try {
            Object o = result.get(); // null
            //main thread 는 Blocking
        } catch (InterruptedException e) {
            //작업 처리 도중 스레드가 interrupt 될 결우
        } catch (ExecutionException e) {
            //작업 처리 도중 예외가 발생된 경우
        }
        System.out.println("main thread terminated ");
        es.shutdown();
    }
}
