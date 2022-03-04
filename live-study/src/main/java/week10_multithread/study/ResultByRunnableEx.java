package week10_multithread.study;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Result result = new Result();
        Task task1 = new Task(result);
        Task task2 = new Task(result);

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Result> future1 = es.submit(task1, result);
        Future<Result> future2 = es.submit(task2, result);

        result = future1.get();
        System.out.println("결과 = " + result.data);
        result = future2.get();
        System.out.println("결과 = " + result.data);
    }
    static class Task implements Runnable{

        Result result;

        public Task(Result result) {
            this.result = result;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                result.add(i);
            }
        }
    }

    static class Result{
        int data;

        synchronized void add(int val){
            data += val;
        }
    }
}
