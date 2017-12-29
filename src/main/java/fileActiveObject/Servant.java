package fileActiveObject;

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

    public Future add(String fileName){
        Future future = new Future();
        this.scheduler.add(new AddFileRequest(this.buffer, future, fileName));
        return future;
    }


    public Future write(String fileName, String data) {
        Future future = new Future();
        this.scheduler.add(new WriteFileRequest(this.buffer,future, fileName, data));
        return future;
    }

    public Future remove(String fileName){
        Future future = new Future();
        this.scheduler.add(new DeleteFileRequest(buffer, future, fileName));
        return future;
    }

    public Future read(String fileName){
        Future future = new Future();
        this.scheduler.add(new ReadFileRequest(buffer, future, fileName));
        return future;
    }


}
