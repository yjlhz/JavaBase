package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ʹ��ReenTrantLock����ָ���߳�
 *
 */
public class LockTest01 {

	public static void main(String[] args) {
		
		Print2 p = new Print2();
		
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					p.print1();
				}
				
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					p.print2();
				}
			}
		};
		
		Thread t3 = new Thread(){
			public void run(){
				while(true){
					p.print3();
				}
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class Print2{
	
	//������
	private ReentrantLock r = new ReentrantLock();
	//������
	private Condition c1 = r.newCondition();
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();
	
	private int flag = 1;
	
	public void print1(){
		//��Ҫ��ʼͬ���ĵط�������
		r.lock();
		while(flag != 1){
			try {
				//�õ�ǰ�߳̽���ȴ�״̬
				c1.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("monkey");
		flag = 2;
		//����Ļ���c2�߳�
		c2.signal();
		//��ִ�н������ͷ���
		r.unlock();
	}
	//wait �ͷŶ�����
	//sleep ���ͷ�
	//notify ���ͷ�
	public void print2(){
		r.lock();
		while(flag != 2){
			try {
				c2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("1024");
		flag = 3;
		//����c3�߳�
		c3.signal();
		r.unlock();
		
	}
	
	public void print3(){
		r.lock();
		while(flag != 3){
			try {
				c3.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("888");
		flag = 1;
		c1.signal();
		r.unlock();
		
	}
}