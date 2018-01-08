package fileActiveObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jacek on 29.11.17.
 */
public class Future {

    private Object object = null;
    private boolean flag = false;
    private ReentrantLock lock = new ReentrantLock();
    private Condition stateChanged = lock.newCondition();

    public void setFuture(Object object){
        //this.object = object;
        this.lock.lock();

        this.object = object;
        this.flag = true;

        this.stateChanged.signalAll();
        this.lock.unlock();
    }

    public Object getObject() {
        //return this.object;
        try {
            lock.lock();
            while (!this.flag)
                this.stateChanged.await();
            return this.object;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            lock.unlock();
        }
    }

    public void setFlag(){this.flag = true;}

    public boolean isReady(){
        //return object != null;
        return this.flag;
    }


}
