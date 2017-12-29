package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public class ActiveObject {

    private Scheduler scheduler;
    private Proxy proxy;
    private FileBuffer buffer;

    public ActiveObject(int bufferSize){
        this.scheduler = new Scheduler();
        this.buffer = new FileBuffer(bufferSize);
        this.proxy = new Servant(buffer, scheduler);
        scheduler.start();
    }

    public Proxy getProxy(){
        return this.proxy;
    }

    public void start(){
        this.scheduler.start();
    }

}
