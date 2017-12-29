package fileActiveObject;

public class ReadFileRequest implements IMethod {

    private Future future;
    private FileBuffer buffer;
    private String fileName;


    public ReadFileRequest(FileBuffer buffer, Future future, String fileName){
        this.buffer = buffer;
        this.future = future;
        this.fileName = fileName;
    }


    public boolean guard(){
        return this.buffer.findFile(this.fileName) != null;
    }


    public void call(){
        this.future.setFuture(this.buffer.readFile(fileName));
        this.future.setFlag();
    }
}
