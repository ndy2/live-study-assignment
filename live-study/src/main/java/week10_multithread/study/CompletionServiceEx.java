package week10_multithread.study;

import java.util.concurrent.*;

public class CompletionServiceEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(es);

        System.out.println("[작업 처리 요청]");
        for (int i = 0; i < 3; i++) {
            int j = i;
            cs.submit(() -> j);
        }

        System.out.println("[처리 완료된 작업 확인]");
        es.submit(() -> {
            while(true) {
                try {
                    Future<Integer> future = cs.take();
                    int ret = future.get();
                    System.out.println("처리 결과 = " + ret);
                } catch (InterruptedException | ExecutionException e) {
                    break;
                }
            }
        });

        Thread.sleep(3000);
        es.shutdownNow();
    }
}
