package fileActiveObject;

public class WriteFileRequest implements IMethod {

    private final String addContent;
    private Future future;
    private FileBuffer buffer;
    private String fileName;

    public WriteFileRequest(FileBuffer buffer, Future future, String fileName, String addContent){
        this.buffer = buffer;
        this.future = future;
        this.fileName = fileName;
        this.addContent = addContent;
    }

    public boolean guard(){
        return !this.buffer.isFull();
    }

    public void call(){
        this.future.setFuture(this.buffer.writeFile(fileName, addContent));
        this.future.setFlag();
    }
}
