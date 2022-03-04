package week10_multithread.study;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 작업 처리 완료 후 결과가 있는 작업의 완료 처리를 Blocking 방식으로
 */
public class ResultByCallableEx {

    public static void main(String[] args) {

        //현재 CPU 의 core 수
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(nThreads);

        Callable<Integer> sumTask = () -> IntStream.range(1, 10).sum();

        Future<Integer> result = es.submit(sumTask);
        try {
            Integer sum = result.get();// sum = 45;
            System.out.println("sum = " + sum);
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
