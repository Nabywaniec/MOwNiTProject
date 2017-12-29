package fileActiveObject;

public class ReadFileRequest implements IMethod {

    private FileBuffer buffer;
    private String fileName;


    public ReadFileRequest(FileBuffer buffer, String fileName){
        this.buffer = buffer;
        this.fileName = fileName;
    }

    @Override
    public boolean guard(){
        return this.buffer.findFile(this.fileName) != null;
    }

    @Override
    public void call(){
        this.buffer.readFile(fileName);
    }
}
