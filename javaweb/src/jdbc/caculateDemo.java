package jdbc;

import org.junit.Assert;
import org.junit.Test;

public class caculateDemo {
    public int add(int a,int b){
        return a+b;
    }
    public int divid(int a,int b){
        return a/b;
    }
    @Test
    public void text1(){
        System.out.println("text11111");
    }
    @Test
    public void text2(){
        caculateDemo c = new caculateDemo();
        Assert.assertEquals(15,c.add(10,5));
    }
}
