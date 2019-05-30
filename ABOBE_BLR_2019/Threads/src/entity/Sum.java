package entity;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {

    private int start, end;

    public Sum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for(Integer i = start; i <= end ; i++) {
            sum += i;
        }
        return sum;
    }
}
