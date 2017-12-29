package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public class DeleteFileRequest implements IMethod {

    private FileBuffer buffer;
    private Future future;
    private String fileName;

    public DeleteFileRequest(FileBuffer buffer, Future future, String fileName) {
        this.buffer = buffer;
        this.future = future;
        this.fileName = fileName;
    }


    public void call(){
        this.future.setFuture(this.buffer.removeFile(fileName));
        this.future.setFlag();
    }

    public boolean guard(){
        return ! this.buffer.isEmpty();
    }

}
