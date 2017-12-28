  /**
 * Created by jacek on 29.11.17.
 */
public class AddMethod implements IMethod {


    private FileBuffer buffer;
    private File file;

    public  AddMethod(FileBuffer buffer, File file){
        this.buffer = buffer;
        this.file = file;
    }

    @Override
    public boolean guard(){
        return !this.buffer.isFull();
    }

    @Override
    public void call(){
        this.buffer.add(file);
    }



}
