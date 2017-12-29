package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public class DeleteFileRequest implements IMethod {

    private FileBuffer buffer;
    private Future future;

    public DeleteFileRequest(FileBuffer buffer, Future future) {
        this.buffer = buffer;
        this.future = future;
    }


    public void call(){
        this.future.setFuture(this.buffer.removeFile());
    }

    public boolean guard(){
        return ! this.buffer.isEmpty();
    }

}
