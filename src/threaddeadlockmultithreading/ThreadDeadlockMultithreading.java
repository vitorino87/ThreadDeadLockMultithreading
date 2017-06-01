/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddeadlockmultithreading;

/**
 *
 * @author tiago.lucas
 */
public class ThreadDeadlockMultithreading implements Runnable{

    /**
     * @param args the command line arguments
     */
    A a = new A();
    B b = new B();

    public ThreadDeadlockMultithreading() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this,"Racing Thread");
        t.start();
        a.foo(b);//get lock on a in this thread
        System.out.println("Back in main thread");
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new ThreadDeadlockMultithreading();
    }

    @Override
    public void run() {
        b.bar(a);//get lock on b in other thread.
        System.out.println("Back in other thread");
    }
    
}
