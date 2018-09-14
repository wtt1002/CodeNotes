package qiuzhao.JD;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package: qiuzhao.JD
 * Description： 可重入锁
 * Author: TingTing W
 * Date: Created in 2018/9/12 10:51
 */
public class LockDemo {
    public static void main(String[] args){

        Sub s=new Sub();
        s.test();

    }
}
class parent {

    protected Lock lock=new ReentrantLock();

    public void test(){
        lock.lock();
        try{
            System.out.println("Parent");
        }finally{
            lock.unlock();
        }
    }


}

class Sub extends parent{

    @Override
    public void test() {
        //
        lock.lock();
        try{
            super.test();
            System.out.println("Sub");

        }finally{
            lock.unlock();
        }
    }


}