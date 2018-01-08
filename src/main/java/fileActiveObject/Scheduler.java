package fileActiveObject;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jacek on 29.11.17.
 */
public class Scheduler extends Thread {

    private Queue<IMethod> queue;
    private Lock lock;
    private Condition stateChanged;


    public Scheduler(){
        this.queue = new ConcurrentLinkedQueue<IMethod>();
        this.lock = new ReentrantLock();
        this.stateChanged = this.lock.newCondition();
    }

    public void add(IMethod method){
        lock.lock();

        this.queue.add(method);
        stateChanged.signalAll();

        lock.unlock();
    }

    @Override
    public void run() {

        boolean flag = false;
        while (!flag) {
            lock.lock();
            try {
                while (this.queue.size() == 0)
                    this.stateChanged.await();

                IMethod method = this.queue.poll();
                if (method != null && method.guard()) {
                    method.call();
                } else {
                    this.add(method);
                }
            } catch (Exception e) {

            }
            finally{
                lock.unlock();
            }
        }


    }
}
