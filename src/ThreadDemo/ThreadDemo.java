package ThreadDemo;

/**
 * 创建线程
 */
public class ThreadDemo {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.run();
        myThread.start();
        for (int j = 0;j < 1000; j++){
            System.out.println("1000");
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 1000; i++){
            System.out.println("1024");
        }
    }
}