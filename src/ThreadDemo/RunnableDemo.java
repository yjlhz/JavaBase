package ThreadDemo;

/**
 * 通过实现Runnable接口来创建线程
 */
public class RunnableDemo {
    public static void main(String[] args){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.run();
        thread.start();
        for (int i = 0; i < 1000; i++){
            System.out.println("1000");
        }
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("1024");
        }
    }
}