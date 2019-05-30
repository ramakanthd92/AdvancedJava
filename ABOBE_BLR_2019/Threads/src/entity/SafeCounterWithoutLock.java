package entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class UnsafeCounter {
    private int counter;

    int getValue() {
        return counter;
    }

    void increment() {
        counter++;
    }
}

public class SafeCounterWithoutLock {
    private final AtomicInteger counter = new AtomicInteger(0);

    int getValue() {
        return counter.get();
    }

    void increment() {
        while (true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if (counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
		SafeCounterWithoutLock counter = new SafeCounterWithoutLock();
//        UnsafeCounter counter = new UnsafeCounter();
        IntStream.range(0, 1000).forEach(count -> service.submit(counter::increment));
	//	service.awaitTermination(100, TimeUnit.MILLISECONDS);

        service.shutdown();
        System.out.println(counter.getValue()); // 1000
    }
}