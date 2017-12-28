/**
 * Created by jacek on 29.11.17.
 */
public class DeleteMethod  implements  IMethod{

    private FileBuffer buffer;
    private Future future;

    public DeleteMethod(FileBuffer buffer, Future future) {
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
