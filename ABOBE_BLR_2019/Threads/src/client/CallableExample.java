package client;

import entity.Sum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = service.submit( new Sum(1,100));
        Future<Integer> f2 = service.submit( new Sum(100,3100));
        Future<Integer> f3 = service.submit( new Sum(15,90));


        while (!f1.isDone()) {
            System.out.println("Processing !!!");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(f1.get());


        while (!f2.isDone()) {
            System.out.println("Processing !!!");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(f2.get());

        while (!f3.isDone()) {
            System.out.println("Processing !!!");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(f3.get());

        service.shutdown();

    }
}
