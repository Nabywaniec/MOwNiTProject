/**
 * Created by jacek on 29.11.17.
 */
public class Servant implements Proxy {

    private FileBuffer buffer;
    private Scheduler scheduler;

    public Servant(FileBuffer buffer, Scheduler scheduler){
        this.buffer = buffer;
        this.scheduler = scheduler;
    }

    public void add(File file){
        this.scheduler.add(new AddMethod(this.buffer,file));

    }

    public Future remove(){
        Future future = new Future();
        this.scheduler.add(new DeleteMethod(buffer, future));
        return future;
    }

    public Future read(String fileName){
        Future future = new Future();
        this.scheduler.add(new ReadMethod(buffer, fileName ));
        return future;
    }


}
