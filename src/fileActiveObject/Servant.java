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

    public void add(File file){
        this.scheduler.add(new AddFileRequest(this.buffer,file));

    }


    public Future write(String fileName, String data) {
        return null;
    }

    public void remove(File file){
        Future future = new Future();
        this.scheduler.add(new DeleteFileRequest(buffer, future));
        return future;
    }

    public Future read(String fileName){
        Future future = new Future();
        this.scheduler.add(new ReadFileRequest(buffer, fileName ));
        return future;
    }


}
