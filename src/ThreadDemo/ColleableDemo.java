package ThreadDemo;

import java.util.concurrent.*;

/**
 * 通过实现callable接口来实现创建线程
 */
public class ColleableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> fl1 = executorService.submit(new MyCollable(4));
        Future<Integer> fl2 = executorService.submit(new MyCollable(3));
        System.out.println("fl1 = " + fl1.get() + "\n" + "fl2 = " + fl2.get());
        executorService.shutdown();

    }

}

class MyCollable implements Callable<Integer>{
    private Integer count;

    public MyCollable(Integer count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 1;
        if (count != 0){
            for (int i = 1; i <= count; i++){
                sum *= i;
            }
        }else {
            sum = 0;
        }
        return sum;
    }
}