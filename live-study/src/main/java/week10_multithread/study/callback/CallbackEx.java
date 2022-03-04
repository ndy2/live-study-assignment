package week10_multithread.study.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackEx {

    private ExecutorService es;
    private CompletionHandler<Integer, Void> callback;
    public CallbackEx() {
        this.es = Executors.newFixedThreadPool(2);
        callback = new CompletionHandler<>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("Completion 실행 결과 : " + result);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("failed 실행 " + exc.getClass());
            }
        };
    }

    public void doWork(String a, String b){
        Runnable task = () -> {
            try{
                int result = Integer.parseInt(a) + Integer.parseInt(b);
                callback.completed(result, null);
            } catch (NumberFormatException e){
                callback.failed(e, null);
            }
        };
        es.submit(task);
    }

    private void shutDown() {
        es.shutdown();
    }

    public static void main(String[] args) {
        CallbackEx callbackEx = new CallbackEx();
        callbackEx.doWork("1","2");
        callbackEx.doWork("3", "예외 빵");
        callbackEx.shutDown();
    }
}
