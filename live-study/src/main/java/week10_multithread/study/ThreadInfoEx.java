package week10_multithread.study;

import java.util.Map;
import java.util.Set;

import static week10_multithread.study.DaemonEx.*;

public class ThreadInfoEx {

    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();
        threads.forEach(
                t -> {
                    System.out.println("name : " + t.getName() + ((t.isDaemon())?" 데몬 스레드":" 주 스레드"));
                    System.out.println("\t"+"소속 그룹 : "+ t.getThreadGroup().getName());
                    System.out.println();
                }

        );
    }
}
