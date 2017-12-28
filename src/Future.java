/**
 * Created by jacek on 29.11.17.
 */
public class Future {

    private File file;

    public void setFuture(File file){
        this.file = file;
    }

    public File getObject() {
        return this.file;
    }

    public boolean isReady()
        {
        return this.file != null;
    }


}
