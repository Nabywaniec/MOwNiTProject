package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public class AddFileRequest implements IMethod {


    private Future future;
    private FileBuffer buffer;
    private String fileName;

    public AddFileRequest(FileBuffer buffer, Future future, String fileName){
        this.buffer = buffer;
        this.future = future;
        this.fileName = fileName;
    }


    public boolean guard(){
        return !this.buffer.isFull();
    }

    public void call(){
        this.future.setFuture(this.buffer.add(fileName));
        this.future.setFlag();
    }



}
