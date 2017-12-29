package fileActiveObject;

import java.util.Timer;

/**
 * Created by jacek on 29.11.17.
 */
public class ActiveObject {

    private Scheduler scheduler;
    private Proxy proxy;
    private FileBuffer buffer;
    private TimeManager timer;

    public ActiveObject(int bufferSize){
        this.scheduler = new Scheduler();
        this.buffer = new FileBuffer(bufferSize);
        this.proxy = new Servant(buffer, scheduler);
        this.timer = new TimeManager(1);
        scheduler.start();
    }

    public Proxy getProxy(){
        return this.proxy;
    }

    public void start(){
        this.scheduler.start();
    }

    public TimeManager getTimer() {
        return timer;
    }

}
